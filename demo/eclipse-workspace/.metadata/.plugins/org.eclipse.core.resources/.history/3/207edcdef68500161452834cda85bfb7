
public class Consumer implements Runnable{

	Container c;
	
	public Consumer(Container c){
		this.c=c;
	}
		

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			{
	try {
		c.get();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

			}
			
}


}
