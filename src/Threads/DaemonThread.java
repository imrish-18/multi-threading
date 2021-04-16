package Threads;

class MyDaemonThread extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++) {
			System.out.println("Child thread");
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

public class DaemonThread {

	public static void main(String[] args) {
		MyDaemonThread thread=new MyDaemonThread();
				//thread.setDaemon(true);
		thread.start();
		thread.interrupt();
		System.out.println("main thread");

	}

}
