package com.amad.thread.sleep_resume;

import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) {
		ConsoleClock clock = new ConsoleClock();
		Thread thread = new Thread(clock);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
