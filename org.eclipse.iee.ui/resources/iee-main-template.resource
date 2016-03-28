import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import static java.lang.Math.*;
import Jama.Matrix;
import com.ieecloud.ieeutils.Function;
import static com.ieecloud.ieeutils.FunctionUtils.*;
import org.eclipse.iee.core.IWorksheet;

public class Iee implements IWorksheet {
	
	@Override
	public void calculate() throws Exception {
		// TODO put code here
	}
	
    public static void main(String[] args) throws Exception {
    	new Iee().calculate();
    }
}