package primitive;

import parser.Parser;

import com.example.parser.Interpreter;

public class CLEANPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		System.out.println("CLEAN : effacer l'ecran");
		
		if (interp.getTurtle() != null)
			interp.getTurtle().clean();
	
	}

}
