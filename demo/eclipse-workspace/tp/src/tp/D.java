package tp;

class D extends C {
	  void m1() {System.out.print("D");}
	  void m2() {
	    m1();
	    ((C)this).m1(); // 1
	    ((B)this).m1(); // 2
	    ((A)this).m1(); // 3
	  }
	  public static void main (String[] args) {
	    new D().m2(); // 4
	   
	  
	  }}
