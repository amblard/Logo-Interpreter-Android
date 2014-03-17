package com.example.parser;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnGesturePerformedListener {

	private Button boutonParser;

	private EditText userinput;
	private Editable input;
	private GestureLibrary gestureLibrary;
	public static int largeurEcran, hauteurEcran;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Display ecran = getWindowManager().getDefaultDisplay();
		largeurEcran = ecran.getWidth();
		hauteurEcran = ecran.getHeight();

		boutonParser = (Button) findViewById(R.id.button1);
		boutonParser.setOnClickListener(this);

		userinput = (EditText) findViewById(R.id.editText1);
		userinput.setMaxHeight((int) (hauteurEcran/2.9));
		userinput.setWidth(largeurEcran);
		userinput.setMaxWidth(largeurEcran);


		gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
		   if (!gestureLibrary.load()) {
		     finish();
		   }
		 
		   GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
		   gestures.addOnGesturePerformedListener(this);
		

	}

	public void runDrawCanvas() {
		Intent intent = new Intent(getApplicationContext(), DrawCanvas.class);
		intent.putExtra("com.example.parser.input", input.toString());
		startActivity(intent);
	}

	@Override
	public void onClick(View arg0) {
		input = userinput.getText();
		runDrawCanvas();

	}

	@Override
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
		
		// on récupère les prédictions faites par la reconaissance de mouvement
		ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
		 
		   if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
		     String result = predictions.get(0).name;
		     int cursorPosition = userinput.getSelectionStart(); // on récupère la position du curser
		     String input = userinput.getText().toString();
		     String debut = input.subSequence(0, cursorPosition).toString();
		     String fin= input.subSequence(cursorPosition, input.length()).toString();
		     String cmdToAdd;
		     
		     // c'est un cercle -> repeat
		     if ("circle".equalsIgnoreCase(result)) {
		    	 cmdToAdd = "\nREPEAT [ ]";
		    	 userinput.setText(debut+ cmdToAdd + fin);
		    	 userinput.setSelection(debut.length()+cmdToAdd.length());
		       //Toast.makeText(this, "CIRCLE", Toast.LENGTH_LONG).show();
		     } 
		     // dessin d'un LT
		     else if ("lt".equalsIgnoreCase(result)) {
		    	 cmdToAdd = "\nLT ";
		    	 userinput.setText(debut+ cmdToAdd + fin);
		    	 userinput.setSelection(debut.length()+cmdToAdd.length());
		      // Toast.makeText(this, "LT", Toast.LENGTH_LONG).show();
		     }
		     // dessin d'un RT
		     else if ("rt".equalsIgnoreCase(result)) {
		    	 cmdToAdd = "\nRT ";
		    	 userinput.setText(debut+ cmdToAdd + fin);
		    	 userinput.setSelection(debut.length()+cmdToAdd.length());
			       //Toast.makeText(this, "RT", Toast.LENGTH_LONG).show();
			 }
		     // ATTENTION le fd ne peut pas être reconnu car un "gesture" doit être composé d'au moins "deux traits"
		     else if ("fd".equalsIgnoreCase(result)) {
			       Toast.makeText(this, "FD", Toast.LENGTH_LONG).show();
			 }
		     else {
		    	 Toast.makeText(this, "Commande non reconnue", Toast.LENGTH_LONG).show();
		     }
		   }
		
	}

}
