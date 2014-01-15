package primitive;

import java.util.List;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class REPEATPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser)
			throws NoSuchPrimitiveException {
		int loopNb = 0;
		String text = "";

		try {
			loopNb = Integer.parseInt((String) parser.simpleExp());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			// R�cuperer la liste d'expression.
			List<Object> list = parser.listExp();

			// Convertir tous les Object en String et les concat�ner.
			for (Object obj : list) {
				text += (String) obj + " ";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Repeter x fois l'interpr�tation de la liste d'expression.
		for (int i = 0; i < loopNb; i++) {
			interp.execute(text);
		}
	}

}
