import static org.junit.Assert.*;

import org.eclipse.iee.translator.antlr.translator.TexTranslator;
import org.junit.Test;


public class TexTranslatorTest {

	@Test
	public void testTranslate() {
		String input = "2.5";
		String result = TexTranslator.translate(input);
		System.out.println(result);
	}

}
