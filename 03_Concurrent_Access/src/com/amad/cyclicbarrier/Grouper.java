package com.amad.cyclicbarrier;

public class Grouper implements Runnable {

	private final Result result;

	public Grouper(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		int finalResult=0; 
        System.out.printf("Grouper: Processing results...\n");
        int data[]=result.getData(); 
        for (int number:data){ 
          finalResult+=number; 
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}

}
