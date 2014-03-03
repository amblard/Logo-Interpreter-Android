package primitive;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public interface Primitive {

	public void execute(Interpreter interp, Parser parser)
			throws NoSuchPrimitiveException;
}
