package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class RTPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		String value = null;
		try {
			value = (String) parser.simpleExp();
			interp.returnValue = Double.parseDouble(value);
			
			interp.getTurtle().TurnRIGHT(Double.parseDouble(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("RT : la tortue tourne a droite de " + value);

	}

}
