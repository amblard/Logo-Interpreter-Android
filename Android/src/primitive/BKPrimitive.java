package primitive;

import parser.ParseException;
import parser.Parser;

import android.util.Log;

import com.example.parser.Interpreter;

public class BKPrimitive implements Primitive {
	Object value = null;

	@Override
	public void execute(Interpreter interp, Parser parser) throws NoSuchPrimitiveException {
		

		try {
			value =  parser.simpleExp();
			if(null == value)
				throw new NoSuchPrimitiveException("BK must have a numeric (double) argument");
			
			
			if(value instanceof Double){				
				interp.returnValue = (Double) value;
				interp.getTurtle().backward((Double) value);
			}
			else {
				throw new NoSuchPrimitiveException("BK must have a numeric (double) argument");
	
			}

		} catch (ParseException e) {
			throw new NoSuchPrimitiveException("Invalid argument for BK");
		}
	}

}
