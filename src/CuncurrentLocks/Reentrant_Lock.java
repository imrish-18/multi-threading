package CuncurrentLocks;

import java.util.concurrent.locks.ReentrantLock;

class Display
{
	ReentrantLock lock=new  ReentrantLock();
	public void wish(String name)
	{
		lock.lock();
		for(int i=0;i<4;i++) {
		System.out.println("good morning");
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(name);
	}
		lock.unlock();
}
}

class DisplayImpl extends Thread
{
	Display d;
	String name;
	public DisplayImpl(Display d ,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.wish(name);
	}
}
public class Reentrant_Lock {

	public static void main(String[] args) {
		Display d=new  Display();
	DisplayImpl dis=new DisplayImpl(d, "jason");
	DisplayImpl disp=new DisplayImpl(d, "roy");
	dis.start();
	disp.start();

	}

}
