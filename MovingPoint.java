/*
// Problem 3 
// Hjemmeopgave 2 - Indledende Programmering
// Asbjørn Olling
*/ 

// a point in 2-dimensional space which moves
//
// movement is described by direction and speed
// angle: 
// 	positive x: 0 degrees
// 	positive y: 90 degrees
// 	range: 0-360
// speed:
// 	a non-negative value
// 	distance in one time unit
// 	range 0-20.0 (20.0 max speed)
// position:
// 	x and y coords

import java.lang.Math;
import java.awt.geom.Point2D; // class to inherit from

public class MovingPoint extends Point2D.Double {
	// introduce variables specific to moving points
	public double direction;
	public double speed;

	public static void main(String[] a){
		// pass
		MovingPoint mp1 = new MovingPoint(1., 2, 180, 2.0);
		System.out.println(mp1);

		// print2 - pass
		mp1.move(3);
		System.out.println(mp1);

		// print3 - pass
		mp1.turnBy(-540);
		System.out.println(mp1);

		mp1.accelerateBy(4.0);
		mp1.move(2);
		System.out.println(mp1);

		mp1.accelerateBy(-7.0);
		mp1.move(2);
		System.out.println(mp1);
		mp1.accelerateBy(3.0);
		mp1.move(1.43);
		System.out.println(mp1);
	} // lop

	// makes a point with dir 90, speed 0, at coords 0,0
	public MovingPoint() {
		x = 0;
		y = 0;
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
		x += Math.cos(Math.toRadians(direction)) * speed * duration;
		y += Math.sin(Math.toRadians(direction)) * speed * duration;
	} // move


	// change the angle
	public void turnBy(double angle) {
		// simple change, making sure to keep value under 360
		direction = (direction + angle) % 360;

		// handle "negative zero" output
		if (1 / direction < 0) {
			direction += 0.0;
		} // negative zero
	}	// turnBy


	// change the speed
	public void accelerateBy(double change) {
		// make the simple speed change
		speed += change;

		// if speed negative, make sped positive
		// and change the angle
		if (speed < 0) {
			speed = speed * -1;
			direction = (direction + 180) % 360;
		} // fi
	} // accelerateBy


	// return text in the format: "[x;y] d s"
	public String toString() {
		return "["+x+";"+y+"] "+direction+" "+speed;
	} // toString
} // class
