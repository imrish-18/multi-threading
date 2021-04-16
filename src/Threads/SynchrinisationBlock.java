package Threads;


class DisplayThread
{
	public void disp(String name)
	{
		for(int i=0;i<3;i++)
		System.out.println("hello rishabh sharma ");
		synchronized(DisplayThread.class) {
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
}
class DispImpl extends Thread
{
	 DisplayThread dis;
	String name;
	public DispImpl(DisplayThread dis,String name) {
		this.dis=dis;
		this.name=name;
	}
	public void run()
	{
		dis.disp(name);
	}
	
}
public class SynchrinisationBlock {

	public static void main(String[] args) {
		
DisplayThread dis=new DisplayThread();

DispImpl impl=new DispImpl(dis,"sachin");

DispImpl impl1=new DispImpl(dis,"raina");
impl.start();
impl1.start();

	}

}
