package primitive;

import parser.Parser;

import com.example.parser.Interpreter;


public class PDPrimitive implements Primitive {

	@Override
	public void execute(Interpreter interp, Parser parser) {
		System.out.println("PD : stylo activ�");

	}

}
