package Threads;


class JoinsThread extends Thread
{
	
	public void run()
	{
	
		for (int i = 0; i < 5; i++) {
			System.out.println("first thread is running");

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
 class JoinsThread2 extends Thread{
	 public void run()
		{
			for(int i=0;i<5;i++)
			{
			System.out.println("second thread is running");
			  try { Thread.sleep(1000); } catch(Exception e) {
				  System.out.println(e.getMessage()); }
			}
		}
 }
public class JoinThread {

	public static void main(String[] args) {
		JoinsThread t1=new JoinsThread();
		JoinsThread2 t2=new JoinsThread2();
		t1.setPriority(10);
		t1.start();
		
		  try { 
			  
			  t1.join(); } 
		  catch(Exception e) 
		  { System.out.println(e.getMessage());}
		 
		t2.start();
		try
		{
			t2.join();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("main thread is running");
		}
	
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
	}

}
