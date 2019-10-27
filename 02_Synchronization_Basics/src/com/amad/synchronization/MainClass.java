package com.amad.synchronization;

public class MainClass {

	public static void main(String[] args) {
		ParkingCash parkingCash = new ParkingCash();
		ParkingStats parkingStats = new ParkingStats(parkingCash);
		System.out.printf("Parking Simulator\n");

		int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
		Thread threads[] = new Thread[numberSensors];
		for (int i = 0; i < numberSensors; i++) {
			Sensor sensor = new Sensor(parkingStats);
			Thread thread = new Thread(sensor);
			thread.start();
			threads[i] = thread;
		}

		for (int i = 0; i < numberSensors; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of cars: %d\n", parkingStats.getNumberCars());
		System.out.printf("Number of motorcycles: %d\n", parkingStats.getNumberMotorcycles());
		parkingCash.close();
	}
}
