package CuncurrentLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable
{
	String name;
	public PrintJob(String name) {
		this.name=name;
	}
	public void run()
	{
		System.out.println(name+" job started by thread "+Thread.currentThread().getName());
		try
		{
			Thread.sleep(2000);;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(name+" job completed by thread  "+Thread.currentThread().getName());
	}
}
public class ThreadPool {

	public static void main(String[] args) {
		PrintJob[] jobs= {
				new PrintJob("sachin"),
				new PrintJob("sehwag"),
				new PrintJob("virat")
		};
		ExecutorService service=Executors.newFixedThreadPool(3);
		for(PrintJob job:jobs)
			service.submit(job);
		service.shutdown();

	}

}
