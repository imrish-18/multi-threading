package ThreadGroup;


public class ThreadGroupFirst {

	public static void main(String[] args) {
	ThreadGroup g=new ThreadGroup("first");
	System.out.println(g.getParent().getName());
	ThreadGroup g1=new ThreadGroup(g,"second");
	System.out.println(g1.getParent().getName());
	
	Thread t1=new Thread(g,"first");
	Thread t2=new Thread(g,"second");
	
	g.setMaxPriority(3);
	
	Thread t3=new Thread(g,"third");
	System.out.println(t1.getPriority());
	System.out.println(t2.getPriority());
	System.out.println(t3.getPriority());
	System.out.println(g.activeCount());
	System.out.println(g.activeGroupCount());
	g.list();
	}

}
