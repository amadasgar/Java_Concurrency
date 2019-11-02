package com.amad.semaphores;

public class MainClass {

	public static void main(String[] args){
		PrintQueue printQueue=new PrintQueue();
		Thread[] threads=new Thread[12]; 
        for (int i=0; i < threads.length; i++){ 
          threads[i]=new Thread(new Job(printQueue),"Thread"+i); 
        }
        for (int i=0; i < threads.length; i++){ 
            threads[i].start(); 
          }
	}
}
