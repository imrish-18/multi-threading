package Threads;
class StaticSynchronisation extends Thread
{
	  static synchronized public void wish(String name)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Good Morning");
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println(name);
		}
	}
}
class MyStaticThread extends Thread
{
	StaticSynchronisation s;
	String name;
	public MyStaticThread(StaticSynchronisation s,String name) {
	this.name=name;
	this.s=s;
	}
	public void run()
	{
		s.wish(name);
	}
	
}
public class StaticSyn {

	public static void main(String[] args) {
	StaticSynchronisation stat=new StaticSynchronisation();
	StaticSynchronisation stat1=new StaticSynchronisation();
	
	MyStaticThread thread=new MyStaticThread(stat, "dhoni");
	MyStaticThread thread1=new MyStaticThread(stat1, "virat");
	thread.start();
	thread1.start();

	}

}
