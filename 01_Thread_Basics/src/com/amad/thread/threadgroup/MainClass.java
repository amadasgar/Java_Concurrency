package com.amad.thread.threadgroup;

public class MainClass {

	public static void main(String[] args) {
		int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();
		MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
		Task task = new Task();
		for (int i = 0; i < numberOfThreads; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}
	}
}
