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
    MovingPoint mp0 = new MovingPoint();
    MovingPoint mp1 = new MovingPoint(1.0, 3.14, 22.5, 2.11);
    MovingPoint mp2 = new MovingPoint(100.23, 2000.34, 225, 10);

		// first print: pass
    System.out.println(mp0);
    System.out.println(mp1);
    System.out.println(mp2);

    mp0.move(2);
    mp1.move(3);
    mp2.move(2);

		// second print: pass
    System.out.println(mp0);
    System.out.println(mp1);
    System.out.println(mp2);

    mp0.accelerateBy(4.0); // pass
    mp1.turnBy(-157); // FUCKUP
    mp2.turnBy(15);
    mp2.accelerateBy(-0.134);
    mp0.move(10);
    mp1.move(10);
    mp2.move(10);
    System.out.println(mp0);
    System.out.println(mp1);
    System.out.println(mp2);
	} // debug method

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
		// simple change
		direction = (direction + angle);

		// make sure it's in the interval [0;360]
		while (direction > 360) {
			direction -= 360;
		} // while greater

		// make sure it's in the interval [0;360]
		while (direction < 0) {
			direction += 360;
		} // while lesser

		// handle "negative zero" output
		if (1 / direction < 0) {
			direction += 0.0;
		} // negative zero
	}	// turnBy


	// change the speed
	public void accelerateBy(double change) {
		// make the simple speed change
		speed += change;

		// set speed to 0, if less than 0
		if (speed < 0) {
			speed = 0;
		} // fi	

		/* 
		// turn the point around, if speed < 0
		if (speed < 0) {
			speed = speed * -1;
			direction = (direction + 180) % 360;
		} //fi */

	} // accelerateBy


	// return text in the format: "[x;y] d s"
	public String toString() {
		return "["+x+";"+y+"] "+direction+" "+speed;
	} // toString
} // class
