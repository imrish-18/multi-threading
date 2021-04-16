package ThreadLocal;

class ParentThread extends Thread
{
	//public static ThreadLocal tl=new ThreadLocal<>();
	// get null in childthreadlocal value so we use InheritableThreadLocal
	public static InheritableThreadLocal tl=new InheritableThreadLocal();
	public void run()
	{
		tl.set("pp");
		System.out.println(tl.get()+" ParentThreadLocal value");
	ChildThread thread=new ChildThread();
	thread.start();
	}
	}
class ChildThread extends Thread
{
	public void run()
	{
		System.out.println(ParentThread.tl.get()+" childthreadLocal value");
		
	}
}
public class InheritableThread {
public static void main(String args[])
{
	ParentThread pt=new ParentThread();
	pt.start();
}
}
