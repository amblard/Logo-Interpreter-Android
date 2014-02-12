package primitive;

import parser.Parser;

import android.util.Log;

import com.example.parser.Interpreter;

public class CustomPrimitive implements Primitive {

	private String commands;

	public CustomPrimitive(String commands) {
		this.commands = commands;
	}

	@Override
	public void execute(Interpreter interp, Parser parser)
			throws NoSuchPrimitiveException {
			interp.execute(commands);
	}

}
