package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] foodTruckArr = new FoodTruck[5];
	public boolean quit = false;
	private int ti = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		Scanner scanner = new Scanner(System.in);
		
		app.run(scanner);
		app.presentTrucksInfo();
		System.out.println("Hello");
//		int selection = app.presentMenuReturnSelection(scanner);
//		System.out.println("selection: " + selection);
		
		scanner.close();
	}

	public void run(Scanner scanner) {

		while (!quit && ti < 2) {
			System.out.print("Enter truck name: ");
			String name = scanner.next();
			if (name.equals("quit")) {
				quit = true;
			} else {
				System.out.print("Enter food type: ");
				String type = scanner.next();
				System.out.print("Enter rating 0-10: ");
				int rating = scanner.nextInt();
				addTruckToArray(new FoodTruck(name, type, rating));
				ti++;
			}
		}
	}

//	public String getTruckDataFromUser() {
//		String info = "";
//
//	}

	public void presentTrucksInfo() {
		for (FoodTruck foodTruck : foodTruckArr) {
			if(!(foodTruck == null)) {
			System.out.println("Name: " + foodTruck.getName());
			System.out.println("Food Type: " + foodTruck.getFoodType());
			System.out.println("Rating: " + foodTruck.getRating());
			System.out.println("/////////////////////////////////");
			}
		}
	}

	public void addTruckToArray(FoodTruck t) {
		foodTruckArr[ti] = t;
//		ti++;
	}

	public int presentMenuReturnSelection(Scanner scanner) {
		String promptSelection = "Select 1 through 4.\n" + "1. List all existing food trucks.\n"
				+ "2. See the average rating of food trucks.\n" + "3. Display the highest-rated food truck.\n"
				+ "4. Quit the program.\n" + "/////////////////////////";
		System.out.println(promptSelection);

		return (scanner.nextInt());
	}

	public String collectAllExistingFoodTrucks() {
		String info = "";

		for (int i = 0; i < foodTruckArr.length; i++) {
			if (!foodTruckArr[i].equals("quit")) {
				info += foodTruckArr[i].toString();
			}
		}

		return info;
	}
}