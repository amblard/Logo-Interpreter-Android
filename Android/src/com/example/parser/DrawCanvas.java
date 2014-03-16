/**
 * 
 */
package com.example.parser;


import primitive.NoSuchPrimitiveException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


@SuppressLint("WrongCall")
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

			
			TextView txview = new TextView(this.getBaseContext());
			txview.setTextColor(Color.rgb(200,0,0));
			txview.setTextSize(25);
			txview.setText("Erreur : La primitive ["+e.getMessage()+ "] n'est pas valide.");
			setContentView(txview);
			Log.d("PARSING", "Error : "+e.getMessage()+ "is not a valid commande");
			
			
		}


		



	}

}
