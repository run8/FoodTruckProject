package com.skilldistillery.app;

public class FoodTruck {
	private static int id = 1;
	private int truckId;
	private String name;
	private String foodType;
	private int rating;

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		truckId = id;
		id += 1;
	}

	public void setName(String name) {
		System.out.println("in setName");
		this.name = name;
	}

	public String getName() {
		String nameCopy = name;
		return nameCopy;
	}

	public String getFoodType() {
		String foodTypeCopy = foodType;
		return foodTypeCopy;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public int getId() {
		return id;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String toString() {
		String truckInfo = "Truck name: " + name + "\nTruch ID: " + truckId + "\nFood type: " + foodType + "\nRating: "
				+ rating + "\n" + "/////////////////////////\n";
		return truckInfo;
	}
}
