package primitive;

import parser.Parser;

import com.example.parser.Interpreter;

public class PUPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		System.out.println("PU : stylo d�sactiv�");

	}

}
