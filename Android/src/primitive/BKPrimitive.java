package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class BKPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		String value = null;
		try {
			value = (String) parser.simpleExp();
			interp.returnValue = Double.parseDouble(value);
			
			interp.getTurtle().backward(Double.parseDouble(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("BK : la tortue recule de " + value);

	}

}
