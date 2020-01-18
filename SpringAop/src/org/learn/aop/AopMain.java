package org.learn.aop;

import org.learn.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ApplicationContext context= new  ClassPathXmlApplicationContext("spring.xml");

ShapeService  shapeService = context.getBean("shapeService", ShapeService.class);
System.out.println("^^^^^^Call Circle getname : "+shapeService.getCircle().getName());
System.out.println("^^^^^^Call Triangle getname : "+shapeService.getTriangle().getName());
System.out.println("^^^^^^Call Triangle Setname : ");
shapeService.getTriangle().setName("Dummy name"); //This is the second call to the setter as first call would already been made during spring initialization, ie. s
//setting the name to "triangle name" However the advice will get executed  for the call  that we make here (Dummy name) not during spring initialization.
System.out.println("vvvvvvvv Call Triangle SetCoordinates : ");
shapeService.getTriangle().setCoordinates(90);
System.out.println("^^^^^^Call Triangle getname : "+shapeService.getTriangle().getName());
System.out.println("vvvvvvvv Call Triangle SetAngle : ");
shapeService.getTriangle().setAngle(180);
System.out.println("vvvvvvvv Call Triangle getAngle : ");
shapeService.getTriangle().getAngle();
System.out.println("vvvvvvvv Call Triangle getCoordinates  : ");
shapeService.getTriangle().getCoordinates();
	}

}
