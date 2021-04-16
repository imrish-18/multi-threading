package CuncurrentLocks;

import java.util.concurrent.locks.ReentrantLock;

public abstract class ConCurrentLocks {

	public static void main(String[] args) {
	ReentrantLock l=new ReentrantLock();
	l.lock();
	l.lock();
	System.out.println(l.isFair());
	System.out.println(l.isLocked());
	System.out.println(l.getQueueLength());
	}

}
