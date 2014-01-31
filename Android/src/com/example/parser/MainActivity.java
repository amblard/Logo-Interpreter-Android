package com.example.parser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private Button boutonParser;

	private EditText userinput;
	private Editable input;

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
		Log.d("","");
		Log.d("","");
		Log.d("","");
		

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

}
