import static org.junit.Assert.*;

import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.junit.Test;

public class JavaTranslatorTest {

	@Test
	public void testTranslateString() {
		String input = "a=x[0][1]";
		String result = JavaTranslator.translate(input);
		System.out.println(result);
	}

	@Test
	public void testTranslateICompilationUnitStringInt() {
		fail("Not yet implemented");
	}

}
