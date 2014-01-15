package com.example.parser;

public class Line {

	private double startX, startY, endX, endY;
	private Line ligne;

	public Line() {

	}

	public Line get_line() {
		return ligne;
	}

	public double get_startX() {
		return startX;
	}

	public void set_startX(double precedent_x) {
		startX = precedent_x;

	}

	public double get_startY() {
		return startY;
	}

	public void set_startY(double precedent_y) {
		startY = precedent_y;

	}

	public double get_endx() {
		return endX;
	}

	public void set_endx(double changex) {
		endX = changex;

	}

	public double get_endy() {
		return endY;
	}

	public void set_endy(double changey) {
		endY = changey;

	}

}
