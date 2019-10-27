package com.amad.synchronization;

public class ParkingCash {

	private static final int cost = 2;
	private long cash;

	public ParkingCash() {
		cash = 0;
	}

	public synchronized void vehiclePay() {
		cash += cost;
	}

	public void close() {
		System.out.printf("Closing accounting");
		long totalAmmount;
		synchronized (this) {
			totalAmmount = cash;
			cash = 0;
		}
		System.out.printf("The total amount is : %d", totalAmmount);
	}
}
