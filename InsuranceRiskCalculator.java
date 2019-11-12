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
		System.out.println("5. Assess members.");
		System.out.println("6. Save assessments as JSON.");
		System.out.println("7. Exit.");
		System.out.print("Please enter the number of your choice: ");
	}
	
	public static void dispWelcome() {
		System.out.println("***************************************************");
		System.out.println("             *Insurance Score Card*");
		System.out.println("      This app scores a potential customer");
		System.out.println("      on various health attributes: blood");
		System.out.println("      pressure, age, height, weight, and");
		System.out.println("      family history of disease. It writes");
		System.out.println("      each member's insurance grade to a");
		System.out.println("      JSON file so that they can be easily");
		System.out.println("      shared on a web-based data exchange.");
		System.out.println("***************************************************");
	}
	
	public static void main(String[] args) {
		// build scanner and have user provide file path
		Scanner sc = new Scanner(System.in);
		int choice;
		dispWelcome();
		System.out.print("Enter name of member file: ");
		String fname = sc.nextLine();

		ArrayList<Member> emps = MemberReader.readMembersFromFile(fname);
		System.out.printf("%d members were read.", emps.size());
		
		// if data is bad return error
		if (emps == null) {
			System.out.println("Error. Data read failure.");
		} else {
			do {
				dispMenu();
				choice = sc.nextInt();
				if (choice == 1) {
					// list members 
					// DONE
					System.out.println("Here are the members:\n");
					MemberWriter.printMembersToScreen(emps);
					// CHECK
					
 				} else if (choice == 2) {
 					// add new member
 					// DONE
 					Scanner scan = new Scanner(System.in);
					int age, height, weight, sys, dia; 
					String first, last;
					Boolean cancer, diabetes, alz;
					ArrayList<String> hashTags = new ArrayList<String>();
					System.out.print("Enter first name: ");
					first = scan.nextLine();
					System.out.print("Enter last name: ");
					last = scan.nextLine();
					System.out.print("Enter age: ");
					age = Integer.parseInt(scan.nextLine());
					System.out.print("Enter height in inches: ");
					height = Integer.parseInt(scan.nextLine());
					System.out.print("Enter weight in pounds: ");
					weight = Integer.parseInt(scan.nextLine());
					System.out.print("Enter systolic blood pressure: ");
					sys = Integer.parseInt(scan.nextLine());
					System.out.print("Enter diastolic blood pressure: ");
					dia = Integer.parseInt(scan.nextLine());
					System.out.print("Has a family member ever had the following conditions:\n");
					System.out.print("Cancer? ");
					if (scan.nextLine().trim().toLowerCase().equals("y")) {
						cancer = true;
					}
					else { cancer = false;}
					System.out.print("Diabetes? ");
					if (scan.nextLine().trim().toLowerCase().equals("y")) {
						diabetes = true;
					}
					else { diabetes = false;}
					System.out.print("Alzheimers? ");
					if (scan.nextLine().trim().toLowerCase().equals("y")) {
						alz = true;
					}
					else { alz = false;}
					
					emps.add(new Member(first, last, age, height, weight, sys, dia, cancer, diabetes, alz));
				} 		
 				else if (choice == 3) {
 					// save members TEXT DONE
 					Scanner scan1 = new Scanner(System.in);
 					String letterChoice, nameFile;
 					System.out.print("(T)ext, (B)inary, or (X)ML? ");
 					letterChoice = scan1.nextLine();
 					System.out.print("Enter name of output file: ");
 					nameFile = scan1.nextLine();
 					
 					if ( letterChoice.equals("T") || letterChoice.equals("t")) {
 	 					MemberWriter.printMembersToTextFile(emps, nameFile);
 					}
 					
				} 		
 				else if (choice == 4) {
 					// load members TXT DONE
 					Scanner scan2 = new Scanner(System.in);
 					String letterChoice, nameFile;
 					System.out.print("(T)ext, (B)inary, or (X)ML? ");
 					letterChoice = scan2.nextLine();
 					System.out.print("Enter name of input file: ");
 					nameFile = scan2.nextLine();
 					
 					if ( letterChoice.equals("T") || letterChoice.equals("t")) {
 						emps = MemberReader.readMembersFromFile(nameFile);
 					}	
				} 		
 				else if (choice == 5) {
 					// assess members
 					// DONE
 					System.out.println("Here are the assessments:");
 					for (Member emp : emps) {
 						emp.assessment();
 						System.out.println(emp.getMyScore().toString());
 						System.out.print("\n");
 					}
				} 		
 				else if (choice == 6) {
 					// save assessments as json
				} 		
			} while (choice != 7);  // exit
		}		
		sc.close();
	}
}