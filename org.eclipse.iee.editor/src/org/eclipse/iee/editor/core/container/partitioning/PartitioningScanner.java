package org.eclipse.iee.editor.core.container.partitioning;


import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * Scanner searches for embedded partitions in document.
 */
public class PartitioningScanner extends RuleBasedPartitionScanner {
		
	/** Token which represents the embedded partition. */
	public static final IToken EMBEDDED_TOKEN = new Token(PartitioningManager.CONTENT_TYPE_EMBEDDED);

	/** Token which represents the plain text partition. */
	public static final IToken PLAINTEXT_TOKEN = new Token(PartitioningManager.CONENT_TYPE_PLAINTEXT);

	/** Creates a new embedded partition scanner. */
	public PartitioningScanner(String partitionBeginToken, String partitionEndToken) {
		IPredicateRule[] rules = new IPredicateRule[1];
		rules[0] = new MultiLineRule(
			partitionBeginToken,
			partitionEndToken,
			EMBEDDED_TOKEN, '\\', false);
		
		setPredicateRules(rules);
		setDefaultReturnToken(PLAINTEXT_TOKEN);
	}
}
