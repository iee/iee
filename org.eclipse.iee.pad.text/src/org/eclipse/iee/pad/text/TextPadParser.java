package org.eclipse.iee.pad.text;

import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.core.document.text.AbstractCompositeNode;
import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
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
		Document root = parseDoc(value);
		textPad.setRoot(root);
		return textPad;
	}

	private Document parseDoc(String value) {
		Document root = new Document();
		org.jsoup.nodes.Document doc = Jsoup.parse(value);
		final Deque<INode> stack = new LinkedList<>();
		stack.add(root);
		final CSSOMParser parser = new CSSOMParser();
		Elements body = doc.getElementsByTag("body");
		body.traverse(new NodeVisitor() {
			
			@Override
			public void tail(org.jsoup.nodes.Node node, int depth) {
				INode n = stack.pop();
				AbstractCompositeNode<INode> peek = (AbstractCompositeNode<INode>) stack.peek();
				peek.addChild(n);
			}
			
			@Override
			public void head(org.jsoup.nodes.Node node, int depth) {
				INode newNode;
				if (node instanceof org.jsoup.nodes.TextNode) {
					newNode = new Text().setText(((org.jsoup.nodes.TextNode) node).text());
				} else if (node instanceof org.jsoup.nodes.Element) {
					Span span = new Span();
					if (node.hasAttr("style")) {
						TextStyle style = span.getStyle();
						try {
							CSSStyleDeclaration styleDecl = parser.parseStyleDeclaration(new InputSource(new StringReader(node.attr("style"))));
							if ("italic".equals(styleDecl.getPropertyValue("font-style"))) {
								style.setItalic(true);
							} else {
								style.setItalic(false);
							}
							if ("bold".equals(styleDecl.getPropertyValue("font-weight"))) {
								style.setBold(true);
							} else {
								style.setBold(false);
							}
							if (styleDecl.getPropertyValue("font-family") != null) {
								style.setFont(styleDecl.getPropertyValue("font-family"));
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("font-size"))) {
								style.setFontSize(new Integer(styleDecl.getPropertyValue("font-size")));
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("color"))) {
								RGBColor rgbColorValue = ((CSSPrimitiveValue)styleDecl.getPropertyCSSValue("color")).getRGBColorValue();
								Color fg = new Color(
										(int) rgbColorValue.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER)
										);
								style.setFgColor(fg);
							}
							if (!Strings.isNullOrEmpty(styleDecl.getPropertyValue("background-color"))) {
								RGBColor rgbColorValue = ((CSSPrimitiveValue)styleDecl.getPropertyCSSValue("background-color")).getRGBColorValue();
								Color bg = new Color(
										(int) rgbColorValue.getRed().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getGreen().getFloatValue(CSSPrimitiveValue.CSS_NUMBER), 
										(int) rgbColorValue.getBlue().getFloatValue(CSSPrimitiveValue.CSS_NUMBER)
										);
								style.setBgColor(bg);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					newNode = span;
				} else {
					newNode = new Span();
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