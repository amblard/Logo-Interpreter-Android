package primitive;

import parser.Parser;

import com.example.parser.Interpreter;

public class CSPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		System.out
				.println("CS : effacer l'ecran et retour de la tortue a l'origine");
		if (interp.getTurtle() != null)
			interp.getTurtle().cleanScreen();
	}

}
