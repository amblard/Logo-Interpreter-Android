package com.example.parser;

import java.io.StringReader;

import parser.ParseException;
import parser.Parser;
import primitive.BKPrimitive;
import primitive.CLEANPrimitive;
import primitive.CSPrimitive;
import primitive.CustomPrimitive;
import primitive.FDPrimitive;
import primitive.HOMEPrimitive;
import primitive.LTPrimitive;
import primitive.NoSuchPrimitiveException;
import primitive.PDPrimitive;
import primitive.PUPrimitive;
import primitive.Primitive;
import primitive.PrimitiveDictionnary;
import primitive.REPEATPrimitive;
import primitive.RTPrimitive;
import primitive.TOPrimitive;
import android.util.Log;

public class Interpreter {

	private PrimitiveDictionnary primitives;
	private Turtle turtle;
	public final String REPEAT_COMMAND = "REPEAT";

	public Interpreter(RenderView ui) {

		turtle = new Turtle(ui);

		primitives = new PrimitiveDictionnary();

		initializePrimitives();
	}

	public Turtle getTurtle() {
		return turtle;

	}

	private void initializePrimitives() {
		primitives.put("BK", new BKPrimitive());
		primitives.put("BACK", new BKPrimitive());
		primitives.put("CLEAN", new CLEANPrimitive());
		primitives.put("CS", new CSPrimitive());
		primitives.put("CLEANSCREEN", new CSPrimitive());
		primitives.put("FD", new FDPrimitive());
		primitives.put("FORWARD", new FDPrimitive());
		primitives.put("HOME", new HOMEPrimitive());
		primitives.put("LT", new LTPrimitive());
		primitives.put("LEFT", new LTPrimitive());
		primitives.put("PD", new PDPrimitive());
		primitives.put("PENDOWN", new PDPrimitive());
		primitives.put("PU", new PUPrimitive());
		primitives.put("PENUP", new PUPrimitive());
		primitives.put(REPEAT_COMMAND, new REPEATPrimitive());
		primitives.put("RT", new RTPrimitive());
		primitives.put("RIGHT", new RTPrimitive());
		primitives.put("TO", new TOPrimitive());
	}

	public void execute(String text) throws NoSuchPrimitiveException {

		// tester s'il s'agit d'une proc�dure

		CustomPrimitive customPrim = primitives.getCustomPrimitive(text
				.split(" ")[0]);

		if (customPrim != null) {
			customPrim.execute(this, null);
			return;
		}

		// sinon c'est une primitive de base
		Parser parser = new Parser(new StringReader(text));
		while (parser.getToken(1).kind != Parser.EOF) {
			// Log.e("Parser", "NEW TOKEN");
			try {
				String primitiveId = (String) parser.primitive();

				if (primitiveId == "") {
					break;
				}
				Log.e("PRIMITIVE ID", primitiveId);

				Primitive prim = primitives.get(primitiveId);
				if (prim == null) {
					throw new NoSuchPrimitiveException(primitiveId);
				}

				prim.execute(this, parser);

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public void createCustomPrimitive(String name, String list) {
		primitives.put(name, new CustomPrimitive(list));
	}

}
