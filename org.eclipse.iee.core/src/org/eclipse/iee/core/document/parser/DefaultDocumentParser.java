package org.eclipse.iee.core.document.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.eclipse.iee.core.document.DirectiveBlock;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.TextDocumentPart;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class DefaultDocumentParser implements IDocumentParser {

	/** Registered pad factories. */
	private final Map<String, IPadParser> fPadParsers = new HashMap<String, IPadParser>();

	public DefaultDocumentParser() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.parser.IDocumentParser#parseDocument(java.io.InputStream)
	 */
	@Override
	public DocumentPart parseDocument(InputStream is) throws IOException {
		ANTLRInputStream st = new ANTLRInputStream(is);
		JavaLexer lexer = new JavaLexer(st);
		List<DocumentPart> children = parseChildren(lexer);
		return new DocumentPart(children);
	}

	private List<DocumentPart> parseChildren(JavaLexer lexer) {
		List<DocumentPart> children = new ArrayList<>();
		Token token = lexer.nextToken();
		while (token.getType() != Token.EOF) {
			if (token.getType() == JavaLexer.Pad) {
				children.add(parsePad(token));
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

	private PadDocumentPart parsePad(Token token) {
		String replace = token.getText().replace("/*<", "").replace(">*/", "");
		int indexOf = replace.indexOf("<*/");
		if (indexOf != -1) {
			replace = replace.substring(0, indexOf);
		}
		PadDocumentPart pad = parsePadPart(replace);
		return pad;
	};
	
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterPadParser", policy = ReferencePolicy.DYNAMIC)
	public void registerPadParser(IPadParser parser) {
		String type = parser.getType();
		fPadParsers.put(type, parser);
	}

	public IPadParser getPadParser(String type) {
		return fPadParsers.get(type);
	}
	
	public void unregisterPadParser(IPadParser parser) {
		Set<Entry<String, IPadParser>> entrySet = fPadParsers.entrySet();
		for (Iterator<Entry<String, IPadParser>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<String, IPadParser> entry = iterator.next();
			if (entry.getValue() == parser) {
				iterator.remove();
			}
		}
	}

	public PadDocumentPart parsePadPart(String text) {
		try {
			StringReader r = new StringReader(text);
			StreamTokenizer st = new StreamTokenizer(r);
			String type = readString(st);
			if ("----".equals(type)) {
				type = null;
			}
			Map<String, String> params = readParams(st);
			int nextToken = st.nextToken();
			String value;
			if (nextToken == ':') {
				StringBuilder sb = new StringBuilder();
				int c;
				while ((c = r.read()) != -1) {
					sb.append((char) c);
				}
				value = sb.toString();
			} else {
				value = "";
			}
			PadDocumentPart pad = fPadParsers.get(type).create(params, value);
			return pad;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param st
	 * @return
	 * @throws IOException
	 */
	private static Map<String, String> readParams(StreamTokenizer st)
			throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		int nextToken = st.nextToken();
		if ((char) nextToken == '(') {
			while (true) {
				parseParam(st, params);
				nextToken = st.nextToken();
				if ((char) nextToken == ')') {
					break;
				} else if ((char) nextToken == ',') {

				} else {
					throw new IllegalArgumentException("failed to parse: " + st);
				}
			}
		} else {
			st.pushBack();
		}
		return params;
	}

	/**
	 * @param st
	 * @param params
	 * @throws IOException
	 */
	private static void parseParam(StreamTokenizer st,
			Map<String, String> params) throws IOException {
		int nextToken;
		String param = readString(st);
		nextToken = st.nextToken();
		if ((char) nextToken != '=') {
			throw new IllegalArgumentException("failed to parse: " + st);
		}
		String value = readString(st);
		params.put(param, value);
	}

	/**
	 * @param st
	 * @return
	 * @throws IOException
	 */
	private static String readString(StreamTokenizer st) throws IOException {
		int nextToken = st.nextToken();
		if (nextToken == StreamTokenizer.TT_WORD || nextToken == 34) {
			return st.sval;
		} else if (nextToken == StreamTokenizer.TT_NUMBER) {
			return String.valueOf(st.nval);
		}
		throw new IllegalArgumentException("failed to parse: " + st);
	}


}
