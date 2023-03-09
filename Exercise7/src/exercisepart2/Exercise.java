package exercisepart2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise {
	
	final static Scanner scanner = new Scanner(System.in);
	static BrowserHistory browserhistory = new BrowserHistory();
	
	static void visit() {
		System.out.println("Enter a url :");
		String inputString = scanner.nextLine();
		
		browserhistory.visit(inputString);
		
	}
	
	static void fetch() {
		System.out.println("Enter the extension to fetch urls: ");
		String inputString = scanner.nextLine();
		
		browserhistory.fetch(inputString);
	}
	
	static void delete() {
		System.out.println("Enter the extension to delete all urls containing the extension :");
		String inputString = scanner.nextLine();
		
		browserhistory.delete(inputString);
	}
	
	static void getSize() {
		System.out.println("Enter the extension to number of urls: ");
		String inputString = scanner.nextLine();
		
		browserhistory.getSize(inputString);
	}
	
	static void search() {
		System.out.println("Enter any word to search for :");
		String inputString = scanner.nextLine();
		
		browserhistory.search(inputString);
	}
	
	public static void main(String[] args) {
		String input = "";
		
		while(true) {
			try {
				System.out.println("------------------");
				System.out.println("\n1. Visit \n2. fetch History \n3. delete history \n4. size \n5. search \n6. exit");
				input = scanner.nextLine();
				int number = Integer.parseInt(input);
				
				if(number == 6) {
					break;
				}
				
				switch(number) {
				case 1: visit();
					break;
				case 2: fetch();
					break;
				case 3: delete();
					break;
				case 4: getSize();
					break;
				case 5: search();
					break;
				default: System.out.println("Enter a numder between 1 and 6");
				}
			}catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}
		}
	}
}
