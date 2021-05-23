package com.skilldistillery.app;

import java.util.Iterator;
import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] foodTruckArr = new FoodTruck[5];
	public boolean quit = false;
	private int ti = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		Scanner scanner = new Scanner(System.in);
		app.run(scanner);

		while (!app.quit) {
			int selection = app.presentMenuReturnSelection(scanner);
			switch (selection) {
			case 1:
				app.presentTrucksInfo();
				break;
			case 2:
				app.seeAverageRating();
				break;
			case 3:
				app.seeHighestRatedTruck();
				break;
			case 4:
				app.quit = true;
			default:
				break;
			}

		}
		scanner.close();
	}

	public void seeAverageRating() {
		double sum = 0.0;
		int numTrucks = 0;
		for (int i = 0; i < foodTruckArr.length; i++) {
			if (foodTruckArr[i] != null) {
				numTrucks += 1;
				sum += foodTruckArr[i].getRating();
			}
		}
		System.out.println("\nAverage rating of all trucks: " +sum / numTrucks + "\n");
	}

	public void seeHighestRatedTruck() {
		FoodTruck highestRatedTruck = null;
		int highestRating = 0;
		for (FoodTruck foodTruck : foodTruckArr) {
			if (foodTruck != null) {
				if (foodTruck.getRating() > highestRating) {
					highestRatedTruck = foodTruck;
				}
			}
		}
		System.out.println("\n Higheset rated truck is: \n" + highestRatedTruck.toString());
	}

	public void run(Scanner scanner) {
		while (!quit && ti < 5) {
			System.out.print("Enter truck name: ");
			String name = scanner.next();
			if (name.equals("quit")) {
				quit = true;
			} else {
				System.out.print("Enter food type: ");
				String type = scanner.next();
				System.out.print("Enter rating 0-10: ");
				int rating = scanner.nextInt();
				System.out.println("/////////////////////////////////");
				addTruckToArray(new FoodTruck(name, type, rating));
				ti++;
			}
		}
	}

	public void presentTrucksInfo() {
		for (FoodTruck foodTruck : foodTruckArr) {
			if (!(foodTruck == null)) {
				System.out.println("Name: " + foodTruck.getName());
				System.out.println("Food Type: " + foodTruck.getFoodType());
				System.out.println("Rating: " + foodTruck.getRating());
				System.out.println("/////////////////////////////////");
			}
		}
	}

	public void addTruckToArray(FoodTruck t) {
		foodTruckArr[ti] = t;
	}

	public int presentMenuReturnSelection(Scanner scanner) {
		String promptSelection = "Select 1 through 4.\n" + "1. List all existing food trucks.\n"
				+ "2. See the average rating of food trucks.\n" + "3. Display the highest-rated food truck.\n"
				+ "4. Quit the program.\n" + "/////////////////////////\n";
		System.out.println(promptSelection);

		return (scanner.nextInt());
	}

//	public String listAllExistingFoodTrucks() {
//		String info = "";
//
//		for (int i = 0; i < foodTruckArr.length; i++) {
//			if (!foodTruckArr[i].equals("quit")) {
//				info += foodTruckArr[i].toString();
//			}
//		}
//
//		return info;
//	}
}