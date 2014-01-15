package primitive;

import parser.Parser;

import com.example.parser.Interpreter;

public interface Primitive {

	public void execute(Interpreter interp, Parser parser)
			throws NoSuchPrimitiveException;
}
