package primitive;

import parser.ParseException;
import parser.Parser;
import android.util.Log;

import com.example.parser.Interpreter;

public class FDPrimitive implements Primitive {

	// private Turtle turtle;

	@Override
	public void execute(Interpreter interp, Parser parser) {
		String value = null;

		try {
			value = (String) parser.simpleExp();

			Log.d("testvaleur", "value=" + value);

			interp.getTurtle().forward(Double.parseDouble(value));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Log.d("Primitive", "FD : la tortue avance de " + value);

	}

}
