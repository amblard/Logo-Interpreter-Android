/**
 * 
 */
package com.example.parser;


import primitive.NoSuchPrimitiveException;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

/**
 * @author Traing
 *
 */
public class DrawCanvas extends Activity {
	
	private RenderView renderView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b=getIntent().getExtras();
		String input=b.getString("com.example.parser.input");
		Log.d("input",input);
		renderView=new RenderView(this);
		Interpreter interpreter = new Interpreter(renderView);
		
		try {
			interpreter.execute(input);

			Log.d("PARSING", "Parsing OK !!!!"+input);

			
			renderView.setBackgroundColor(Color.WHITE);
			
			setContentView(renderView);
			

		} catch (NoSuchPrimitiveException e) {
			
			Log.d("PARSING", "Parsing NO !!!!");
			
		}


		



	}

}
