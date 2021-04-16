package Threads;

class Display 
{
	public  synchronized void dispn()

	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public synchronized void dispc()

	{
		for(int i=65;i<70;i++)
		{
			System.out.println((char)i);
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
class MyThread1 extends Thread
{
	Display d;
	public MyThread1( Display d) {
this.d=d;	
	}
	public void run()
	{
		d.dispn();
	}
	
}
class MyThread2 extends Thread
{
	Display d;
	public MyThread2( Display d) {
this.d=d;	
	}
	public void run()
	{
		d.dispc();
	}
	
}
public class StaticMethod {

	public static void main(String[] args) {
		Display s=new Display();
		MyThread1 t1=new MyThread1(s);
		MyThread2 t2=new MyThread2(s);
		t1.start();
		t2.start();

	}

}
