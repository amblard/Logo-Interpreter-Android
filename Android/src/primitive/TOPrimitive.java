package primitive; 

import java.util.List;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class TOPrimitive implements Primitive {

	public final String END_PROCEDURE_ID = "END";

	@Override
	public void execute(Interpreter interp, Parser parser) {
 
		String primitiveId = null;
		// r�cuperation nom de la proc�dure custom
		try {
			primitiveId = (String) parser.primitive();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String commands = "";
		Object obj = new Object();
		boolean repeatFound = false;
		boolean needFinalBracket = false;
		// r�cup�ration des commandes
		while (obj != null) {
			try {
				obj = parser.expression();
			} catch (ParseException e) {
				e.printStackTrace();
				obj = null;
			}

			if (obj != null) {
				if (obj instanceof String) {
					if (!((String) obj).equalsIgnoreCase(END_PROCEDURE_ID)) {
						if (needFinalBracket == false && repeatFound == true) {
							commands = commands.concat((String) obj + " [");
							needFinalBracket = true;
						} else {
							commands = commands.concat((String) obj + " ");
						}
						if ((interp.REPEAT_COMMAND
								.equalsIgnoreCase((String) obj))) {
							repeatFound = true;
						}
						continue;
					} else {
						if (needFinalBracket == true)
							commands = commands.concat("]");
						obj = null;
					}
				} else {
					@SuppressWarnings("unchecked")
					List<Object> list = (List<Object>) obj;
					for (Object subobj : list) {
						if (!((String) subobj)
								.equalsIgnoreCase(END_PROCEDURE_ID)) {
							commands = commands.concat((String) subobj + " ");
							continue;
						} else {
							obj = null;
							break;
						}
					}
				}
			}
		}

		interp.createCustomPrimitive(primitiveId, commands);
	}
}
