
public class Customer {

	int NumberOfItems;
	
	// Constructor
	public Customer() {
		NumberOfItems = 6;
	} // Constructor
	
	
	// Constructor takes Items
	public Customer(int items) {
		
		int ClothingItems = items;
		
		if(ClothingItems == 0) {
			// 0 is random
			NumberOfItems = GetRandomNumber(20);
		} else {
			// set it to items
			NumberOfItems = ClothingItems; 
		}
		
	} // Constructor
	
	
	// random
	public static int GetRandomNumber(int maxValue) {
		int x = 1 + (int)(Math.random()) * maxValue;
		return x;
	} // random
	
	
	
	// getter
	public int getNumberOfItems() {
		return NumberOfItems;
	}
	
	
} // class
