package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class LTPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		String value = null;
		try {
			value = (String) parser.simpleExp();
			interp.getTurtle().TurnLEFT(Double.parseDouble(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("LT : la tortue tourne a gauche de " + value);

	}

}
