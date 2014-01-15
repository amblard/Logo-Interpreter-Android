package primitive;

import parser.Parser;

import com.example.parser.Interpreter;

public class HOMEPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		System.out.println("HOME : la tortue retourne au centre");

	}

}
