package Threads;


class Thread1 extends Thread
{
	public void run()
	{
		for(int j=0;j<4;j++)
		{
			System.out.println("this is another thread");
		}
	}
	public void start()
	{
		super.start();
		for(int j=0;j<4;j++)
		{
			System.out.println("this is start method");
		}
	}
}
public class MultiThreading extends Thread {

	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("hello this is first thread");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	MultiThreading multi=new MultiThreading();
	Thread1 thread=new Thread1();
	thread.start();
	multi.start();
for(int i=0;i<5;i++)
{
	System.out.println("hello this is  thread");
}
	}

}
