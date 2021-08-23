package oop_singleton_test;

public class Car {
	
	private int carNum;
	private static int serialNum = 10000;
	
	public Car() {
		serialNum++;
		carNum = serialNum;
	}

	public int getCarNum() {
		return carNum;
	}
	
}
