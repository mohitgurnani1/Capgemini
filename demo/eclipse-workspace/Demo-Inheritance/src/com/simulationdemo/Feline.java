package com.simulationdemo;

public class Feline extends Animal{

	public Feline(String type, String location) {
		super(type, location);
		// TODO Auto-generated constructor stub
	}

	public void roam(){
		System.out.println("I roam alone....");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	/*	public Feline() {
//		CHAINING CONSTRUCTOR USING 'super'
		super("NA","NA");
	}
*/
	


}
