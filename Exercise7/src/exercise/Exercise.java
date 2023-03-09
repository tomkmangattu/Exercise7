package exercise;

import java.util.Scanner;



public class Exercise{
	
	static BrowserHistory browserHistory = new BrowserHistory();
	static Scanner scanner = new Scanner(System.in);
	
	static void visit() {
		System.out.println("Enter the url you have to visit: ");
		String input = scanner.nextLine();
		browserHistory.visit(input);
		
	}
	
	static void sort() {
		browserHistory.sort();
	}
	
	static void delete() {
		System.out.println("\t History urls");
		browserHistory.displayHistory();
		
		System.out.println("Enter url or url index to delete :");
		String input = scanner.nextLine();
		
		try {
			int number = Integer.parseInt(input);
			browserHistory.deleteHistory(number);
		}catch (NumberFormatException e) {
			browserHistory.deleteHistory(input);
		}
	}
	static void fetch() {
		
		browserHistory.displayHistory();
		
	}
	
	static void search() {
		System.out.println("Enter extension in url to search :");
		String input = scanner.nextLine();
		
		browserHistory.search(input);
	}
	
	static void getSize() {
		browserHistory.getSize();
	}
	
	static void updateHistory() {
		System.out.println("\t History urls");
		browserHistory.displayHistory();
		
		System.out.println("Enter url index to edit :");
		String input = scanner.nextLine();
		
		try {
			int index = Integer.parseInt(input);
			System.out.println("Enter the corrected url :");
			String correctUrl = scanner.nextLine();

			browserHistory.updateHistory(index, correctUrl);
			
		}catch(NumberFormatException e) {
			System.out.println("Enter a number");
		}
	}
	
	public static void main(String[] args) {
		String input = "";
		int choice = 0;
		
		while(true) {
			try {
				System.out.println("---------------------");
				System.out.println("1. visit \n2. sort \n3. delete history \n4. fetch history \n5. search \n6. size \n7. update history \n8. exit");
				System.out.println("Enter your choice");
				
				input = scanner.nextLine();
				choice = Integer.parseInt(input);
				
				if(choice == 8) {
					break;
				}
				
				switch(choice) {
				case 1: visit();
					break;
				case 2: sort();
					break;
				case 3: delete();
					break;
				case 4: fetch();
					break;
				case 5: search();
					break;
				case 6: getSize();
					break;
				case 7: updateHistory();
					break;
				default : System.out.println("Input a number between 1 to 8");
				}
			}catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}
				
			}
	}
}