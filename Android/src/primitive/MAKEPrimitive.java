package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class MAKEPrimitive implements Primitive{
	
	String primitiveId = null;
	String value = null;
	
	public double getValue() {
		return Double.parseDouble(value);
	}
	
	@Override
	public void execute(Interpreter interp, Parser parser) {
		try {
			primitiveId = (String) parser.primitive();
			value = (String) parser.simpleExp();
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		interp.ListVariable(primitiveId, Double.parseDouble(value));
	}
}
