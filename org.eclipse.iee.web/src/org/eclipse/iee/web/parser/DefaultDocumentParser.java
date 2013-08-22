package org.eclipse.iee.web.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.web.JavaLexer;
import org.eclipse.iee.web.document.DirectiveBlock;
import org.eclipse.iee.web.document.Document;
import org.eclipse.iee.web.document.DocumentPart;
import org.eclipse.iee.web.document.PadDocumentPart;
import org.eclipse.iee.web.document.TextDocumentPart;

public class DefaultDocumentParser {

	private PadManager padManager;

	public DefaultDocumentParser(PadManager padManager) {
		super();
		this.padManager = padManager;
	}

	public Document parseDocument(InputStream is) throws IOException {
		ANTLRInputStream st = new ANTLRInputStream(is);
		JavaLexer lexer = new JavaLexer(st);
		List<DocumentPart> children = parseChildren(lexer);
		return new Document(new DocumentPart(children));
	}

	private List<DocumentPart> parseChildren(JavaLexer lexer) {
		List<DocumentPart> children = new ArrayList<>();
		Token token = lexer.nextToken();
		while (token.getType() != Token.EOF) {
			if (token.getType() == JavaLexer.Pad) {
				children.add(new PadDocumentPart(parsePad(token)));
			} else if (token.getType() == JavaLexer.DirectiveStart) {
				DirectiveBlock block = new DirectiveBlock("hide", parseChildren(lexer));
				children.add(block);
			} else if (token.getType() == JavaLexer.DirectiveEnd) {
				return children;
			} else {
				children.add(new TextDocumentPart(JavaLexer.tokenNames[token
						.getType()], token.getText()));
			}
			token = lexer.nextToken();
		}
		return children;
	}

	private Pad parsePad(Token token) {
		String replace = token.getText().replace("/*<", "").replace(">*/", "");
		int indexOf = replace.indexOf("<*/");
		if (indexOf != -1) {
			replace = replace.substring(0, indexOf);
		}
		Pad pad = padManager.parsePad(replace);
		return pad;
	};

}
