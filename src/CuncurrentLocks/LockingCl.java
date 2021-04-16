package CuncurrentLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Lock extends Thread
{
	static ReentrantLock lock=new ReentrantLock();
	Lock(String name)
	{
		super(name);
	}
	public void run()
	{
		do {
			
		try
		{
			if(lock.tryLock(3000,TimeUnit.MILLISECONDS))
		
		{
			System.out.println(Thread.currentThread().getName()+" got lock");
			Thread.sleep(25000);
			lock.unlock();
			System.out.println(Thread.currentThread().getName()+" releases the lock");
			break;
		}
		else
		{
			System.out.println(Thread.currentThread().getName()+" unable to get lock and will try again"); 
		}
	}
		catch(Exception e) {}
		}
		while(true);
	}
}
public class LockingCl {

	public static void main(String[] args) {
	Lock l=new Lock("first");
	Lock l1=new Lock("second");
	l.start();
	l1.start();

	}

}
