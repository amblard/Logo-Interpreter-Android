package com.example.parser;

import java.io.StringReader;

import parser.ParseException;
import parser.Parser;
import parser.ParserConstants;
import primitive.BKPrimitive;
import primitive.CLEANPrimitive;
import primitive.CSPrimitive;
import primitive.CustomPrimitive;
import primitive.FDPrimitive;
import primitive.HOMEPrimitive;
import primitive.NoSuchPrimitiveException;
import primitive.LTPrimitive;
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
	public double returnValue;
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


		// lecture du coe utilisateur
		Parser parser = new Parser(new StringReader(text));
		while (parser.getToken(1).kind != ParserConstants.EOF) {
		
			try {
				String primitiveId = (String) parser.primitive();

				if (primitiveId == "") {
					break;
				}
				

				Primitive prim = primitives.get(primitiveId);
				if (prim == null) {
					
					// si c'est pas une primitive classique
					// on regarde si c'est une custom
					CustomPrimitive customPrim = primitives.getCustomPrimitive(primitiveId);
				
					if (customPrim != null) {
						//System.out.println(parser.toString());
						customPrim.execute(this, parser);
						//return;
					}					
					else					
						throw new NoSuchPrimitiveException(primitiveId);
				}
				else
					prim.execute(this, parser);

			} catch (ParseException e) {
				Log.e("ERROR PARSING", e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public void createCustomPrimitive(String name, String list) {
		primitives.put(name, new CustomPrimitive(list));
	}

}
