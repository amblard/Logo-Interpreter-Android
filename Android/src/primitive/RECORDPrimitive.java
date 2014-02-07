package primitive;

import parser.ParseException;
import parser.Parser;
import android.util.Log;

import com.example.parser.Interpreter;

// Primitive pour les tests arithmetiques

public class RECORDPrimitive implements Primitive{
	private int value;

	public int getValue() {
		return value;
	}
	
	
	@Override
	public void execute(Interpreter interp, Parser parser) {


		try {
			value = Integer.parseInt((String) parser.simpleExp());

			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Log.d("RECORD", "RECORD : resultat " + value);

	}

}
