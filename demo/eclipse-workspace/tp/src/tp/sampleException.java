package tp;

import java.io.IOException;

public class sampleException {

	static int r;
	public static void main(String[] args) throws Exception{
		
		
			    String a = "\n";      // 1
			    String b = "\r";      // 2
		
			    //    String c = "\n"; 
		
	/*	System.out.println("hi");
		try{
		setValue(5,0);
		}
		finally{
		setValue(3, 2);
			System.out.println("b4 good bye");
		}
		System.out.println("bye "+r);
		
		
	*/
		

	}		
	static public void setValue(int val,int den) throws Exception {
		
		try{
		throw new Exception("Mohit");
		}
		finally{
			
			System.out.println("in setvalue final");
		}
		
	}
	
	
	
}
