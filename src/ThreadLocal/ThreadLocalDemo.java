package ThreadLocal;
class CustomerThread extends Thread
{
	static Integer custId=0;
	private static ThreadLocal tl=new ThreadLocal() {
		protected Object initialValue()
		{
			return ++custId;
			
		}
	};
	public CustomerThread(String name) {
	
		super(name);
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" executing with custId "+ tl.get());
	
}
}

public class ThreadLocalDemo {

	public static void main(String args[])
	{
		
		CustomerThread c1=new CustomerThread("customer-thread-1");
		CustomerThread c2=new CustomerThread("customer-thread-2");
		CustomerThread c3=new CustomerThread("customer-thread-3");
		CustomerThread c4=new CustomerThread("customer-thread-4");
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
	}
}
