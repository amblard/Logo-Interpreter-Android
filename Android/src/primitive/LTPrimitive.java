package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class LTPrimitive implements Primitive {
	Object value = null;
	
	@Override
	public void execute(Interpreter interp, Parser parser) throws NoSuchPrimitiveException {

		try {
			value =  parser.simpleExp();
			if(null == value)
				throw new NoSuchPrimitiveException("LT must have a numeric (double) argument");


			if(value instanceof Double){				
				interp.returnValue = (Double) value;
				interp.getTurtle().TurnLEFT((Double) value);
			}
			else {
				throw new NoSuchPrimitiveException("LT must have a numeric (double) argument");
				
			}

		} catch (ParseException e) {
			throw new NoSuchPrimitiveException("Invalid argument for LT");
		}
		
		
	}

}
