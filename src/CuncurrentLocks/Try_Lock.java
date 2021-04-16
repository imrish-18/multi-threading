package CuncurrentLocks;

import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread
{
	static ReentrantLock lock=new ReentrantLock();
	public MyThread(String name) {
		super(name);
	}
	public void run()
	{
		if(lock.tryLock())
		{
			System.out.println(Thread.currentThread().getName()+" safe operations");
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			lock.unlock();
		}
		else
		{
			System.out.println(Thread.currentThread().getName()+" unsafe operations"); 
		}
	}
	
}
public class Try_Lock {

	public static void main(String[] args) {
	MyThread t1=new MyThread("first");
	MyThread t2=new MyThread("second");
	t1.start();
	t2.start();

	}

}
