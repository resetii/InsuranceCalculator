// James Campion
// The main of this project calls the respective classes to do all the work needed
// This class generates the user menus and manages inputs 
import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceRiskCalculator {
	// displays the user options menu
	public static void dispMenu() {
		System.out.println("\n   Here are your choices: ");
		System.out.println("1. List members.");
		System.out.println("2. Add a new member.");
		System.out.println("3. Save members.");
		System.out.println("4. Load members.");
		System.out.println("5. Asssess members.");
		System.out.println("6. Save assessments as JSON.");
		System.out.println("7. Exit.");
		System.out.print("Please enter the number of your choice: ");
	}
	
	public static void dispWelcome() {
		System.out.println("***************************************************");
		System.out.println("             *Insurance Score Card*");
		System.out.println("  This app scores a potential customer");
		System.out.println("  on various health attributes: blood");
		System.out.println("  pressure, age, height, weight, and");
		System.out.println("  family history of disease. It writes");
		System.out.println("  each member's insurance grade to a");
		System.out.println("  JSON file so that they can be easily");
		System.out.println("  shared on a web-based data exchange.");
		System.out.println("***************************************************");
	}

	// Calls the override toString function to print all rooms
	public static void printRoomsToScreen(ArrayList<Room> emps) {
//		for (Room emp : emps) {
//			System.out.println(emp.toString());
//		}
	}
	
	public static void main(String[] args) {
		// build scanner and have user provide file path
		Scanner sc = new Scanner(System.in);
		int choice;
		dispWelcome();
		System.out.print("Enter name of member file: ");
		String fname = sc.nextLine();

		//ArrayList<Room> emps = RoomReader.readRoomsFromFile(fname);
		//System.out.printf("%d members were read.", emps.size());
		
		// if data is bad return error
		if (emps == null) {
			System.out.println("Error. Data read failure.");
		} else {
			do {
				dispMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					// list members
			
					
 				} else if (choice == 2) {
 					// add new member
				} 		
 				else if (choice == 3) {
 					// save members
				} 		
 				else if (choice == 4) {
 					// load members
				} 		
 				else if (choice == 5) {
 					// assess members
				} 		
 				else if (choice == 6) {
 					// save assessments as json
				} 		
			} while (choice != 7);  // exit
		}		
		sc.close();
	}
}