package com.amad.thread.finalization.join;

import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		DataSourceLoader dsLoader = new DataSourceLoader();
		Thread dsThread = new Thread(dsLoader, "DataSourceThread");

		NetworkConnectionsLoader nsLoader = new NetworkConnectionsLoader();
		Thread nsThread = new Thread(nsLoader, "NetworkConnectionsLoader");

		dsThread.start();
		nsThread.start();

		try {
			dsThread.join();
			nsThread.join();
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}

		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}
