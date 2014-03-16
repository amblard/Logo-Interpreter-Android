package com.example.parser;

import android.util.Log;

public class Turtle {

	private double apha;
	// private Paint paint;

	private double startX, startY, endX, endY, angle;
	private RenderView ui;
	private int largeur;
	private int hauteur;

	public double getX(){		
		return startX;		
	}
	public double getY(){		
		return startY;		
	}
	public Turtle(RenderView ui) {

		if (ui != null){
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
	}

	public void move(double distance, double sign) {

		
		
			// Il faut convertir l'angle en radian pour l'utiliser dans Math.cos ou
			// sin
			endX += sign * (distance * Math.cos(Math.toRadians(angle)));
			endY += sign * (distance * Math.sin(Math.toRadians(angle)));
			

			if(ui != null){
				this.ui.NewLine(this.startX, this.startY, this.endX, this.endY);
				System.out.println("UI  "+distance);

			}
			
				
			this.startX = endX;
			this.startY = endY;

		
		
	}

	public void turn(double angle, double sign) {
		
		this.angle = (this.angle + sign * angle);
		
	}

	public void forward(double distance) {
		System.out.println("TORTUE AVANCE !!"+distance);

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
