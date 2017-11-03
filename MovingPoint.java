/*
// Problem 3 
// Hjemmeopgave 2 - Indledende Programmering
*/ 

// a point in 2d-space, which moves described by doubles
// representing direction, speed, and coordinates

import java.lang.Math; // used for trigonometric functions in move()
import java.awt.geom.Point2D; // class to inherit from

public class MovingPoint extends Point2D.Double {
	// introduce fields for moving points
	private double direction;
	private double speed;


	// makes a point at the origin (0,0) with dir 90, speed 0 
	public MovingPoint() {
		x = y = 0; // coordinates at origin
		direction = 90;
		speed = 0;
	} // default constructor


	// makes a point with specific coords, dir and speed
	public MovingPoint(double x, double y, double direction, double speed) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.speed = speed;
	}	// specific constructor


	// move the point for a number of time units
	public void move(double duration) {
		double dirInRadians = Math.toRadians(direction);
		// use trigonometry to calculate new coordinates
		x += Math.cos(dirInRadians) * speed * duration;
		y += Math.sin(dirInRadians) * speed * duration;
	} // move


	// change the angle
	public void turnBy(double angle) {
		// simple change
		direction += angle;

		// make sure it's in the interval [0;360]
		// if greater than interval
		while (direction > 360) {
			direction -= 360;
		} // while greater

		// if lesser than interval
		while (direction < 0) {
			direction += 360;
		} // while lesser

		// handle weird "negative zero" result
		if (1 / direction < 0) {
			direction += 0.0;
		} // negative zero
	}	// turnBy


	// change speed
	public void accelerateBy(double change) {
		// make the simple speed change
		speed += change;

		// set speed to 0, if less than 0
		if (speed < 0) {
			speed = 0;
		} // fi	

		/* Alternate (better) solution:
		// Turn the point around, if speed < 0
		if (speed < 0) {
			speed = speed * -1;
			direction = (direction + 180) % 360;
		} //*/

	} // accelerateBy


	// return text in the format: "[x;y] d s"
	public String toString() {
		return "["+x+";"+y+"] "+direction+" "+speed;
	} // toString
} // class
