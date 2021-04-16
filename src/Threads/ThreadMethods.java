package Threads;

class YieldThread extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("child thread is executing");
			Thread.yield();
		}
	}
}
class YieldThread1 extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("child thread is running");
			Thread.yield();
		}
	}
}

public class ThreadMethods {

	public static void main(String[] args) {
	
		YieldThread thread=new YieldThread();
		//thread.setPriority(10);
		thread.start();
		YieldThread1 thread1=new YieldThread1();
		//thread1.setPriority(3);
		thread1.start();
		
		for(int i=0;i<5;i++) {
Thread.yield();
			System.out.println("main thread");
		}
		System.out.println(thread.getPriority());
		System.out.println(thread1.getPriority());
		

	}

}
