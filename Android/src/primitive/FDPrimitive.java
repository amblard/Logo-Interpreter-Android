package primitive;

import parser.ParseException;
import parser.Parser;
import android.util.Log;

import com.example.parser.Interpreter;

public class FDPrimitive implements Primitive {
	Object value = null;
	// private Turtle turtle;

	public double getValue() {
		return (Double) value;
	}
	
	@Override
	public void execute(Interpreter interp, Parser parser) {
		

		try {
			value =  parser.simpleExp();
			System.out.println("CLASS value "+value.getClass());

			if(value instanceof Double){				
				interp.returnValue = (Double) value;
				interp.getTurtle().forward((Double) value);
			}
			else {
				System.out.println("FD must have a numeric (double) argument");
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
