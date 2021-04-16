package Threads;


class Sthrea extends Thread{
	
public void run() {
	for(int i=0;i<5;i++) {
		System.out.println("sleeping thread is running");
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
public class SleepMethod {

	public static void main(String[] args) {
	
	Sthrea t=new Sthrea();
	t.start();
	t.interrupt();// interrupt the thread who is sleeping or waiting state
	System.out.println("end thread");

	}

}
