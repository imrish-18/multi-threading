package com.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable
{

	List<Integer> list=null;
	public Consumer(	List<Integer> list)
	{
		this.list=list;
	}
	@Override
	public void run() {
		while(true)
		{
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 synchronized public void consume() throws InterruptedException
	{
	
			
		
		while(list.isEmpty())
		{
			System.out.println("queue is empty......please wait for the producer to producer the item");
			list.wait();
		
		}

			
		
		Thread.sleep(1000);
		System.out.println("consumed item is.."+list.remove(0));
		list.notify();
	}
	
	
}

class Producer implements Runnable
{
	List<Integer> list=null;
	private int i=0;
	public Producer(List<Integer> list)
	{
		super();
		this.list=list;
	}

	@Override
	public void run() {
	while(true)
	{
		try {
			produce(i++);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	 synchronized public void produce(int i) throws InterruptedException
	{
	
		
		while(list.size()==5)
		{
			System.out.println("queue is full ...please wait for the consumer to consume it");
			list.wait();
		}
		
	
		
		System.out.println("producer is producing some items");
		list.add(i);
		//blockingQueue.add(i);
		Thread.sleep(1000);
		list.notify();
		}
	
	
}


//
//class Consumer implements Runnable {
//
//	// List<Integer> list=null;
//	BlockingQueue<Integer> blockingQueue = null;
//
//	public Consumer(BlockingQueue<Integer> blockingQueue2) {
//		this.blockingQueue = blockingQueue2;
//	}
//
//	@Override
//	public void run() {
//		while (true) {
//			try {
//				consume();
//			} catch (InterruptedException e) { // TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	public void consume() throws InterruptedException {
//		synchronized (blockingQueue) {
//
//			while (blockingQueue.isEmpty()) {
//				System.out.println("queue is empty......please wait for the producer to producer the item");
//				blockingQueue.wait();
//			}
//		}
//		synchronized (blockingQueue) {
//
//			Thread.sleep(1000);
//			System.out.println("consumed item is.." + blockingQueue.poll());
//			blockingQueue.notify();
//		}
//	}
//
//}
//  
//class Producer implements Runnable { // List<Integer> list=null;
//	BlockingQueue<Integer> blockingQueue = null;
//	private int i = 0;
//
//	public Producer(BlockingQueue<Integer> blockingQueue2) {
//		super();
//		this.blockingQueue = blockingQueue2;
//	}
//
//	@Override
//	public void run() {
//		while (true) {
//			try {
//				produce(i++);
//			} catch (InterruptedException e) { // TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	public void produce(int i) throws InterruptedException {
//		synchronized (blockingQueue) {
//
//			while (blockingQueue.size() == 5) {
//				System.out.println("queue is full ...please wait for the consumer to consume it");
//				blockingQueue.wait();
//			}
//		}
//		synchronized (blockingQueue) {
//
//			System.out.println("producer is producing some items..." + i); // list.add(i);
//			blockingQueue.add(i);
//			Thread.sleep(1000);
//			blockingQueue.notify();
//		}
//	}
//
//}
// 
//
//
//
//
//
//
//
//

public class ProducerConsumerImpl {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);
		
		List<Integer> list = new ArrayList<>();
		Thread t1 = new Thread(new Producer(list));
		Thread t2 = new Thread(new Consumer(list));
 		
//		  Thread t1=new Thread(new Producer(blockingQueue)); 
//		  Thread t2=new Thread(new
//		  Consumer(blockingQueue));
//		 
	
		t2.start();
		t1.start();
		

	}

}
