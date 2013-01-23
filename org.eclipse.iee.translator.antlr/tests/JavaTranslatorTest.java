import static org.junit.Assert.*;

import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.junit.Test;

public class JavaTranslatorTest {

	@Test
	public void testTranslateString() {
		String input = "x<y&&x>z";
		String result = JavaTranslator.translate(input);
		System.out.println(result);
	}


}
