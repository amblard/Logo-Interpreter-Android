package primitive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.ParseException;
import parser.Parser;

import com.example.parser.Interpreter;
import com.example.parser.Variable;

public class RTPrimitive implements Primitive {
	String value = null;
	private static Pattern pattern;
	private static Matcher matcher;
	
	@Override
	public void execute(Interpreter interp, Parser parser) {
		
		try {
			value=(String) parser.generalExp();
			  pattern = Pattern.compile("[a-zA-Z]");
			  matcher = pattern.matcher(value);  
			  
			  Boolean match=false;
			  while(matcher.find()) {
				  match=true;
		        }
			 
			// si c'est des nombres  
			if(match==false){

				interp.returnValue = Double.parseDouble(value);
				
				interp.getTurtle().TurnRIGHT(Double.parseDouble(value));
				
			}
			else{
				
				for (Variable var : interp.Variables) {
					if(value.compareTo(var.name)==0){
						
						interp.getTurtle().TurnRIGHT(var.value);
					}
				}
									
			}	
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
