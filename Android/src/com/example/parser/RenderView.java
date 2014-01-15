package com.example.parser;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class RenderView extends View {

	private List<Line> lignes;
	private Paint paint;
	private Line ligne;

	public RenderView(Context context) {
		super(context);
		lignes = new ArrayList<Line>();
		paint = new Paint();
		paint.setColor(Color.BLACK);

	}

	public void NewLine(double x, double y, double a, double b) {

		Log.d("ajout", "ajout de la ligne111");
		// on créer une nouvelle ligne
		ligne = new Line();

		ligne.set_startX(x);
		ligne.set_startY(y);
		ligne.set_endx(a);
		ligne.set_endy(b);

		Log.d("ajout", "startX" + ligne.get_startX());
		Log.d("ajout", "startY=" + ligne.get_startY());
		Log.d("ajout", "endx=" + ligne.get_endx());
		Log.d("ajout", "endy=" + ligne.get_endy());

		if (ligne == null) {
			Log.d("ajout", "test2");
		}
		Log.d("NewLine", "" + this);
		// on l'ajoute a la liste des lignes
		lignes.add(ligne);

		// on rafraichit l'image
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {

		if (ligne == null) {
			Log.d("ajout", "test");
		}
		Log.d("onDraw", "" + this);

		// pour chaque ligne dans la liste on la trace
		for (int i = 0; i < lignes.size(); i++) {
			Line l = lignes.get(i);
			Log.d("ajout", "dessin");
			canvas.drawLine((float) l.get_startX(), (float) l.get_startY(),
					(float) l.get_endx(), (float) l.get_endy(), paint);

		}
	}
	
	public void clean() {
		
		lignes.clear();
		
	}
	
}
