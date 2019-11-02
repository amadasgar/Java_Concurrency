package com.amad.cyclicbarrier;

public class Result {

	private final int[] data;

	public Result(int size) {
		data = new int[size];
	}

	public void setData(int position, int value) {
		data[position] = value;
	}

	public int[] getData() {
		return data;
	}
	
	
}
