package main;

public class item {
	public static String name;
	public static String category;
	public static int price;
	
	//constructor without arguments
	public item() {
		
	}
	
	//constructor with arguments
	public item(String itemName, String itemCategory, int itemPrice) {
		item.name = itemName;
		item.category = itemCategory;
		item.price = itemPrice;
	}
	
	//setter for price variable
	public void setPrice(int itemPrice) {
		item.price = itemPrice;
	}
	
	//setter for name variable
	public void setName(String itemName) {
		item.name = itemName;
	}
	
	//setter for category
	public void setCategory(String itemCategory) {
		item.category = itemCategory;
	}
	
	//getter for price
	public static int getPrice() {
		return price;
	}
	
	//getter for name
	public static String getName() {
		return name;
	}
	
	//getter for category
	public static String getCategory() {
		return category;
	}
}
