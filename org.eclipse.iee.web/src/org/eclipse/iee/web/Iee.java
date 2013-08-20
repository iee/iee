package org.eclipse.iee.web;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * IEE is more than maths plus programming. Synergy in action!
 */

public class Iee {
    public static void main(String[] args) {

    	/*<Formula("id"="b8fe85ef-3938-412e-bfb6-c9f9b51424e6"):h=2+2<*/double h=(2)+(2);/*>>*/
    	/*<Formula("id"="ab99f34f-040e-43d8-b363-d99bffc28179"):h=<*/new Runnable() {/*br*/private  double variable;/*br*/private Runnable init (double var)/*br*/{/*br*/variable = var;return this;/*br*/}/*br*/@Override/*br*/public void run() {/*br*/File file = new File("/home/aefimchuk/intl/runtime-EclipseApplication/test/pads/runtime/ab99f34f-040e-43d8-b363-d99bffc28179");/*br*/try {/*br*/FileUtils.writeStringToFile(file, "" + variable);/*br*/}/*br*/catch(IOException e)/*br*/{/*br*/e.printStackTrace();/*br*/}/*br*/}/*br*/ }.init(h).run();/*>>*/
    			
    	
    }
}