package Threads;


class Thread2  implements Runnable 
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++)
		System.out.println("this is runnable thread");
		
	}
	
}
public class RunnableThread {

	public static void main(String args[])
	{
		Thread2 t=new Thread2();
		Thread thread=new Thread(t,"first thead");
		thread.start();
		
		System.out.println(thread.getName());
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<3;i++)
			System.out.println("this is main thread");
		Thread t3=new Thread();
		t3.run();
		
		System.out.println(Thread.currentThread().getPriority());
		
		
		
		
		
	}
}
