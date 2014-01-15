package com.example.parser;

import android.graphics.Color;
import android.util.Log;

public class Turtle {

	private double apha;
	// private Paint paint;

	private double startX, startY, endX, endY, angle;
	private RenderView ui;
	private int largeur;
	private int hauteur;

	public Turtle(RenderView ui) {

		// on récupère les dimentions de l'écran pour centrer la turtle
		largeur = MainActivity.largeurEcran;
		hauteur = MainActivity.hauteurEcran;
		Log.d("LARGEUR", "" + largeur);
		Log.d("HAUTEUR", "" + hauteur);
		this.startX = largeur / 2;
		this.startY = hauteur / 2;
		Log.d("LARGEUR", "" + startX);
		Log.d("HAUTEUR", "" + startY);
		this.endX = largeur / 2;
		this.endY = hauteur / 2;
		this.angle = 0.0;
		this.ui = ui;

	}

	public void move(double distance, double sign) {
		// Log.e("COORD TURTLE", "StartX:" + startX + "StartY:" + startY);
		Log.e("ANGLE", "" + angle);
		// Il faut convertir l'angle en radian pour l'utiliser dans Math.cos ou
		// sin
		endX += sign * (distance * Math.cos(Math.toRadians(angle)));
		endY += sign * (distance * Math.sin(Math.toRadians(angle)));

		Log.d("COORDONNEES", "startX=" + startX + "startY=" + startY + "endX:"
				+ endX + "endY:" + endY);
		this.ui.NewLine(this.startX, this.startY, this.endX, this.endY);

		this.startX = endX;
		this.startY = endY;
		Log.e("COORD TURTLE", "StartX:" + startX + "StartY:" + startY);

	}

	public void turn(double angle, double sign) {
		Log.e("ANGLE", "" + this.angle);
		this.angle = (this.angle + angle) * sign;
		Log.e("ANGLE", "" + this.angle);
	}

	public void forward(double distance) {

		Log.d("testdistante", "distance=" + distance);

		move(distance, 1.0);

	}

	public void backward(double distance) {
		move(distance, -1.0);
	}

	public void TurnRIGHT(double angle) {
		turn(angle, 1.0);
	}

	public void TurnLEFT(double angle) {
		turn(angle, -1.0);
	}
	
	public void clean(){
		ui.clean();
	
	}
	
	public void cleanScreen()
	{
		ui.clean();
		origine();
	}
	
	public void origine()
	{
		this.startX = this.largeur / 2;
		this.startY = hauteur / 2;
		
		this.endX = this.largeur / 2;
		this.endY = this.hauteur / 2;
	}
	
	
}
