package primitive; 

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;

public class TOPrimitive implements Primitive {

	public final String END_PROCEDURE_ID = "END";

	@Override
	public void execute(Interpreter interp, Parser parser) throws NoSuchPrimitiveException {
 
		String primitiveId = null;
		// r�cuperation nom de la proc�dure custom
		try {
			primitiveId = (String) parser.primitive();
		} catch (ParseException e) {
			throw new NoSuchPrimitiveException("Syntax error for To : To primitive InstructionList END");
		}

		String commands = "";
		Object obj = new Object();
		boolean repeatFound = false;
		boolean needFinalBracket = false;
		
		// recuperation des commandes
		while (obj != null) {
			try {
				obj = parser.expression();
				
				if(null != obj){
					if(obj.toString().equalsIgnoreCase(END_PROCEDURE_ID)){
						commands = commands.replaceAll(",", "");
						System.out.println("FIN COMMANDE");
						break;
					}
					
					
					commands = commands.concat(obj.toString() + " ");
					
				}
				else {
					throw new NoSuchPrimitiveException("Syntax error for To : To primitive InstructionList END");
				}

			} catch (ParseException e) {
				obj = null;
				throw new NoSuchPrimitiveException("Syntax error for To : To primitive InstructionList END");
				
			}
			
			/*
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
					System.out.println("TYPE OF OBJECT "+obj.toString());
					if(!(obj instanceof Double)){
						
					
					@SuppressWarnings("unchecked")					
					List<Object> list = (List<Object>) obj;
					
					for (Object subobj : list) {
						if(!(subobj instanceof Double)){
							if (!((String) subobj).equalsIgnoreCase(END_PROCEDURE_ID)) {
								commands = commands.concat((String) subobj + " ");
								continue;
							} else {
								obj = null;
								break;
							}
						}
						else {
							commands = commands.concat(subobj.toString() + " ");
						}
						
					}
					}
					else {
						System.out.println("DOUBBBLLLLLEEEE");
						commands = commands.concat(obj.toString() + " ");
					}
				}
			}
			
			*/
			
		}
		System.out.println("COMMANDE "+commands);
		interp.createCustomPrimitive(primitiveId, commands);
	}
}
