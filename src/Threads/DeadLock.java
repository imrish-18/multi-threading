package Threads;
class A1
{
	public synchronized void d1(B b)
	{
		System.out.println("Thread1 starts execution of d1 method");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		b.last();
	}
	public synchronized void last()
	{
		System.out.println("Inside  A method");
	}
}
class B
{
	public synchronized void d2(A1 a)
	{
		System.out.println("thread2 starts excection of d2 method");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		a.last();
	}
	public synchronized void last() {
		System.out.println("inside B last method");
	}
}

public class DeadLock extends Thread {
	A1 a=new A1();
	B b=new B();
	public void m1()
	{
		this.start();
		a.d1(b);// this line is executed by main thread
	}
	public void run()
	{
		b.d2(a);// this line is executed by child thread
	}

	public static void main(String[] args) {
	
		DeadLock d=new DeadLock();
		d.m1();

	}

}
