package org.learn.aop.model;

import org.learn.aop.aspect.Loggable;

public class Triangle {

	private String name;
	private int coordinates;
	private int angle;

	public int getAngle() {
		System.out.println("Triangle class : getAngle Method");
		return angle;
	}


	public int setAngle(int angle) {
		this.angle = angle;
		System.out.println(" Triangle SETTER setAngle  executed ");
		return angle;
	}

   
	@Loggable
	public int getCoordinates() {
		System.out.println(" Trainle Class : getCoordinates Method");
		return coordinates;
	}


	public void setCoordinates(int coordinates) {
		this.coordinates = coordinates;
		
		System.out.println("Trianle Setter - setCoordinates method called");
		//throw new RuntimeException();
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
		System.out.println("Trianle Setter - setName method called");
	}
	
	
}
