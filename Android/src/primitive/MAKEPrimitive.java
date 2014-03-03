package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class MAKEPrimitive implements Primitive{
	
	String primitiveId;
	String value;
	
	public double getValue() {
		return Double.parseDouble(value);
	}
	
	@Override
	public void execute(Interpreter interp, Parser parser) {
		
		// recuperation du nom et de la valeur
		try {
			primitiveId = (String) parser.primitive();
			value = (String) parser.simpleExp();
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		interp.ListVariable(primitiveId, Double.parseDouble(value));
	}
}
