import java.util.Scanner;

public class Scenario {
	
	// fields
	static int items;
	static int controlItemNumber;
	static int numberOfItems;
	static int totalRooms;
	static int numberOfCustomers;
	
	
	// main
	public static void main(String[] args) {
		
		// input
		Scanner in = new Scanner(System.in);
		
		// clothingItems = 0 : uses Random number
		// clothingItems = 1-20 : uses the number given
		System.out.println("What Clothing Items value do you want? (0 = Random) ");
		controlItemNumber = in.nextInt();
		
		// number of customers
		System.out.println("How many Customers do you want? ");
		numberOfCustomers = in.nextInt();
		
		// number of dressing rooms
		System.out.println("How many Dressing Rooms do you want? ");
		totalRooms = in.nextInt();
		
		// close input
		in.close();
		
		// dressing rooms
		DressingRoom dr = new DressingRoom(totalRooms);
		
		// threads based on customer count
		for (int i = 0; i < numberOfCustomers; i++) {
			
			// customer
			Customer cust = new Customer(controlItemNumber);
			
			// items
			numberOfItems = cust.getNumberOfItems();
			
			// total items
			items += numberOfItems;
			
			// create thread
			dr.RequestRoom(numberOfItems);
			
		} // for
		
		// delay waiting for thead
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		// average items per customer
		int averageitemsPerCustomer = items / numberOfCustomers;
		System.out.println("Average number of items was " + averageitemsPerCustomer);
		
		
		// output average run time
		System.out.println("Average Run Time in nanoseconds " + dr.getRunTimer() / numberOfCustomers);
		
		// output average wait time
		System.out.println("Average Wait Time in nanoseconds " + dr.getWaitTimer() / numberOfCustomers);
		
		// output number of customers
		System.out.println("Total Number of Customers is " + numberOfCustomers);
		
		
	} // main
	
	
} // class
