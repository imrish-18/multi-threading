package Threads;
class Mythread extends Thread
{
	public void run() {
	try
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("child thread");
			Thread.sleep(1000);
		}
		
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
public class InterruptedThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Mythread thread=new Mythread();
   thread.start();
   //thread.interrupt();
   System.out.println("main thread");
   System.out.println(Thread.currentThread().getThreadGroup().getName());
   System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
	}

}
