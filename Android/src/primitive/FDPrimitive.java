package primitive;

import parser.ParseException;
import parser.Parser;
import com.example.parser.Interpreter;

public class FDPrimitive implements Primitive {
	Object value = null;
	

	public double getValue() {
		return (Double) value;
	}
	
	@Override
	public void execute(Interpreter interp, Parser parser) throws NoSuchPrimitiveException {
		

		try {
			value =  parser.simpleExp();
			if(null == value)
				throw new NoSuchPrimitiveException("FD must have a numeric (double) argument");

			if(value instanceof Double){				
				interp.returnValue = (Double) value;
				interp.getTurtle().forward((Double) value);
			}
			else {
				throw new NoSuchPrimitiveException("FD must have a numeric (double) argument");
				
				
			}

		} catch (ParseException e) {
			throw new NoSuchPrimitiveException("Invalid argument for FD");
		}


	}

}
