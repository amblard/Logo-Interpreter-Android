package primitive;

import java.util.List;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class REPEATPrimitive implements Primitive {
	Object nbLoops = null;
	
	@Override
	public void execute(Interpreter interp, Parser parser)
			throws NoSuchPrimitiveException {
		
		String text = "";

		try {
			nbLoops =  parser.simpleExp();
			if(nbLoops instanceof Double){				
				interp.returnValue = (Double) nbLoops;
			
				System.out.println("DOUBLE REPEAT "+nbLoops);	
				
				
				List<Object> list = parser.listExp();
				
				
				// Convertir tous les Object en String et les concat�ner.
				Object obj;
				
				for (int i = 0; i < list.size();i++) {
					obj = list.get(i);
					
		
						text += obj.toString() + " ";
				
					
					
					
					System.out.println("OBJET "+text);
				}
				text = text.replaceAll(",", "");
				System.out.println("LISTE CONCACT "+text);
				double nbRepeat = (Double)nbLoops;
				for (int i = 0; i < (int)nbRepeat; i++) 
					interp.execute(text);
				interp.returnValue = (Double) nbLoops;
					
						
				
				
			}
			else {
				throw new NoSuchPrimitiveException("REPEAT must have a numeric argument REPEAT n [ instruction list]");
				
			}
			
			
			//loopNb = Integer.parseInt((String) parser.simpleExp());
	
		} catch (ParseException e) {
			throw new NoSuchPrimitiveException("Invalid arguments for REPEAT : REPEAT n [ instruction list]");
			
		}		
		
	}

}
