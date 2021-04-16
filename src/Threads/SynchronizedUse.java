/*
 * package Threads;
 * 
 * class SynClass extends Thread { synchronized public void wish(String name) {
 * for(int i=0;i<5;i++) { System.out.println("Good Morning"); try {
 * Thread.sleep(1000); } catch(Exception e) {
 * System.out.println(e.getMessage()); } System.out.println(name); } } } class
 * MyThread extends Thread { SynClass s; String name; public MyThread(SynClass
 * s,String name) { this.name=name; this.s=s; } public void run() {
 * s.wish(name); }
 * 
 * }
 * 
 * public class SynchronizedUse {
 * 
 * public static void main(String args[]) {
 * 
 * SynClass s=new SynClass(); SynClass s1=new SynClass(); MyThread thread=new
 * MyThread(s,"dhoni"); thread.start(); MyThread t=new MyThread(s1, "virat");
 * t.start();
 * 
 * 
 * MyThread thread1=new MyThread(s,"kohli"); thread1.start(); MyThread
 * thread2=new MyThread(s,"sachin"); thread2.start();
 * 
 * //System.out.println("this is synchronized class"); } }
 */