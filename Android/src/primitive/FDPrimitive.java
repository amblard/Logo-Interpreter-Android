package primitive;

import parser.ParseException;
import parser.Parser;
import android.util.Log;

import com.example.parser.Interpreter;

public class FDPrimitive implements Primitive {
	String value = null;
	// private Turtle turtle;

	public double getValue() {
		return Double.parseDouble(value);
	}
	
	@Override
	public void execute(Interpreter interp, Parser parser) {
		

		try {
			value = (String) parser.simpleExp();
			interp.returnValue = Double.parseDouble(value);

			interp.getTurtle().forward(Double.parseDouble(value));

		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
