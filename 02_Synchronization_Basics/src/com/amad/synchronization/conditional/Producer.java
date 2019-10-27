package com.amad.synchronization.conditional;

public class Producer implements Runnable {

	private EventStorage storage;
	
	public Producer(EventStorage eventStorage) {
		this.storage = eventStorage;
	}
	
	@Override
	public void run() {
		for(int i = 0; i  < 100; i++){
			storage.set();
		}
	}

}
