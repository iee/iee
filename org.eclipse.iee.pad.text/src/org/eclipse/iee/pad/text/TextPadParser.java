package org.eclipse.iee.pad.text;

import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.pad.text.elements.Node;
import org.eclipse.iee.pad.text.elements.Span;
import org.eclipse.iee.pad.text.elements.TextNode;
import org.jsoup.Jsoup;
import org.jsoup.select.NodeVisitor;
import org.osgi.service.component.annotations.Component;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.RGBColor;

import com.google.common.base.Strings;
import com.steadystate.css.parser.CSSOMParser;

/**
 * {@link IPadParser} implementation. Creates instance of text pad.
 */
@Component
public class TextPadParser implements IPadParser {

	@Override
	public TextPart create(Map<String, String> padParams, String value) {
		TextPart textPad = new TextPart();
		textPad.setId(padParams.get("id"));
		Node root = parseDoc(value);
		textPad.setRoot(root);
		return textPad;
	}

	private Node parseDoc(String value) {
		Node root = new Node();
		org.jsoup.nodes.Document doc = Jsoup.parse(value);
		final Deque<Node> stack = new LinkedList<>();
		stack.add(root);
		final CSSOMParser parser = new CSSOMParser();
		doc.traverse(new NodeVisitor() {
			
			@Override
			public void tail(org.jsoup.nodes.Node node, int depth) {
				Node n = stack.pop();
				stack.peek().appendChild(n);
			}
			
			@Override
			public void head(org.jsoup.nodes.Node node, int depth) {
				Node newNode;
				if (node instanceof org.jsoup.nodes.TextNode) {
					newNode = new TextNode().setText(((org.jsoup.nodes.TextNode) node).text());
				} else if (node instanceof org.jsoup.nodes.Element) {
					Span span = new Span();
					if (node.hasAttr("style")) {
						try {
							CSSStyleDeclaration styleDecl = parser.parseStyleDeclaration(new InputSource(new StringReader(node.attr("style"))));
							if ("italic".equals(styleDecl.getPropertyValue("font-style"))) {
								span.setItalic(true);
							} else {
								span.setItalic(false);
							}
							if ("bold".equals(styleDecl.getPropertyValue("font-weight"))) {
								span.setBold(true);
							} else {
								span.setBold(false);
							}
							if (styleDecl.getPropertyValue("font-family") != null) {
								span.setFont(styleDecl.getPropertyValue("font-family"));
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("font-size"))) {
								span.setFontSize(new Integer(styleDecl.getPropertyValue("font-size")));
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("color"))) {
								RGBColor rgbColorValue = ((CSSPrimitiveValue)styleDecl.getPropertyCSSValue("color")).getRGBColorValue();
								Color fg = new Color(
										(int) rgbColorValue.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER)
										);
								span.setFgColor(fg);
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("background-color"))) {
								RGBColor rgbColorValue = ((CSSPrimitiveValue)styleDecl.getPropertyCSSValue("background-color")).getRGBColorValue();
								Color bg = new Color(
										(int) rgbColorValue.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER)
										);
								span.setBgColor(bg);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					newNode = span;
				} else {
					newNode = new Node();
				}
				stack.push(newNode);
			}
		});
		return root;
	}
	
	@Override
	public String getType() {
		return "Text";
	}
	
}