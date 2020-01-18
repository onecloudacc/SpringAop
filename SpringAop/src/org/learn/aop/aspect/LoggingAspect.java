package org.learn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//First example
	@Before("execution (public String getName())")  // Logging advice will run "before" the execution of getName() method in both the triangle and Circle class.
	public void LoggingAdvice() {
		System.out.println("Aspect called for getName() method across all classe where this method is found");

	}

	
	// second example : 
	
	@Before("execution (public String org.learn.aop.model.Circle.getName())")  // Logging advice will run "before" the execution of getName() method  with no aruguments only in circle class. 
	public void LoggingAdvice2() {
		System.out.println("Aspect called for getName() method in Circle class ");

	}
	
	// Third example : 
	
	@Before("execution (public String  get*())")  // Logging advice will run "before" the execution of any Getter()  that has no aruguments  and  the return type as "String" based on the wild cardused
	public void LoggingAdvice3() {
		System.out.println("Aspect called for any Getter method()  that has the return type as String");

	}
	
	//Fourth example
	@Before("execution (public *  get*())")  // Logging advice will run "before" the execution of any Getter()  that has no aruguments  and any "RETURN type" based on the wild cardused
	public void LoggingAdvice4() {
		System.out.println("Aspect called for any Getter method()  that has any return type");

	}
	
	
	@Before("execution (public *  get*(*))")  // Logging advice will run "before" the execution of any Getter(*) which has ARGUMENT  that has any "RETURN type" based on the wild cardused
	public void LoggingAdvice5() {
		System.out.println("Aspect called for any Getter method()  that has  ARGUMENT and  any return type");

	}
	
	@Before("samplePointCut()")  // Logging advice will run "before" the execution of any Getter(*) which does or doesnot (irrespective) have   ARGUMENT,  that has any "RETURN type" based on the wild cardused
	public void LoggingAdvice6() {
		System.out.println("Aspect called for any Getter method()   irrespective of  ARGUMENT that has any return type");

	}
	
	@Before("executeAdviceForAllMethodsWithInCircle()")  // Logging advice will run "before" the execution of any Getter(*) which does or doesnot (irrespective) have   ARGUMENT,  that has any "RETURN type" based on the wild cardused
	public void LoggingAdvice7() {
		System.out.println("Advice executeAdviceForAllMethodsWithInCircle called ");

	}
	
	////POINTCUT EXAMPLE
	
// If you want multiple advices to be executed for any method, then point cut is useful.advice method will make use of this pointcuts.
	// point cut is notthing but the wildcard expression
	
	@Pointcut("execution (public *  get*(..))") 
	public void samplePointCut()
	{
	}
	
	@Pointcut("within(org.learn.aop.model.Circle)") 
	public void executeAdviceForAllMethodsWithInCircle()
	{
		
	}
	
	//with argument
	@Before("args(String)")  
	public void LoggingAdvice8() {
		System.out.println(" a method which takes the string as a argument is called");

	}
	
	
	//get the argument value that is passed and assign the datatype of string to that argument
		@Before("args(param)")  
		public void LoggingAdvice9( String param) {
			System.out.println(" a method which takes the string as a argument is called and its value is : "+param );

		}
		
		// @After annotation
		
		@After("args(num)")   // this advice will run AFTER the setter is called no matter what is the result of setter class.even if the setter method throws exception this advice will execute.
		public void LoggingAdvice10( int num) {
			System.out.println(" LoggingAdvice10:  A method which takes the int as a argument is called AFTER the setter method (setCoordinates)  and its value is : "+num );

		}
		
		@AfterReturning("args(num)")   // this advice will run AFTER the setter is called. This will run only if the SETTER completes successfully.
		public void LoggingAdvice11( int num) {
			System.out.println(" LoggingAdvice11 :  A method which takes the int as a argument is called AFTER the setter method (setCoordinates) and setter methods is success  and its value is : "+num );

		}
		
		
		@AfterThrowing("args(num)")   // this advice will run AFTER the setter is called. This will run only if the SETTER completes with error or Exception.
		public void LoggingAdvice12( int num) {
			System.out.println(" LoggingAdvice12 :  A method which takes the int as a argument is called AFTER the setter method (setCoordinates) and setter methods is NOT success  and its value is : "+num );

		}
		
		@AfterReturning(pointcut="args(num)",returning="returnString")   // this advice will run AFTER the setter is called. This will run only if the SETTER completes successfully.This will catch the returned string from the setter method 
		public void LoggingAdvice13( int num, int returnString) {
			System.out.println(" LoggingAdvice13 :  A method which takes the int as a argument is called AFTER the setter method (setCoordinates) and setter methods is success  and its input value is : "+num + "Returned String value is" + returnString );

		}
		
		
		@AfterReturning(pointcut="args(num)",returning="returnString")   // this advice will run AFTER the setter is called. This will run only if the SETTER completes successfully.This will catch the returned any DATATYPE from the setter method 
		public void LoggingAdvice14( int num, Object returnString) {
			System.out.println(" LoggingAdvice14 :  A method which takes the int as a argument is called AFTER the setter method (setCoordinates) and setter methods is success  and its input value is : "+num + "Returned Object value is" + returnString );

		}
		
		
		@AfterThrowing(pointcut="args(num)",throwing="Ex")   // this advice will run AFTER the setter is called. This will run only if the SETTER completes with error or Exception and the Exception can be caught in the advice method
		public void LoggingAdvice15( int num, Exception Ex) {
			System.out.println(" LoggingAdvice15 :  A method which takes the int as a argument is called AFTER the setter method (setCoordinates) and setter methods is NOT success  and its value is : "+num +" : exception is:--> " + Ex);

		}
		
		@Around("execution (public int org.learn.aop.model.Triangle.getAngle())")
		public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) // return object as it returns any primititive datatypes
		{
			Object returnValue=null;
			try {
				System.out.println("In Around advice block : beforee advice");
				returnValue=proceedingJoinPoint.proceed();// This is when the ACTUAL TARGET mathod execution happens, meaning getAngle mmethod gets called now.
				System.out.println("In Around advice block : After advice");
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				System.out.println("After throwing");
				e.printStackTrace();
				
			}
			System.out.println(" Finally ");
			return returnValue;
		}
		
		@Before("@annotation(org.learn.aop.aspect.Loggable)")
		public void customAnnoation()
		{
		System.out.println("Executing Custom Annotation : Loggable  before getCoordinates is called");	
			
		}
}
