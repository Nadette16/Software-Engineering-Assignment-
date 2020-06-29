package main;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.*;

import Database.databaseHandler;


//import Database.databaseHandler;

public class Restaurant {
	public Calendar openTime = new GregorianCalendar();
	public Calendar closeTime = new GregorianCalendar();
	public Menu menu = new Menu();
	public Order order;
	public static int[] orderTime = new int[2];

public Restaurant() {
	openTime.set(Calendar.HOUR_OF_DAY, 11);
	closeTime.set(Calendar.HOUR_OF_DAY, 22);
	
}

public boolean validOrderTime(int hour, int mint) {
	if(openTime.get(Calendar.HOUR_OF_DAY) > hour || closeTime.get(Calendar.HOUR_OF_DAY)<= hour) {
		return false;
	}
	else {
		return true;
	}
}

public static void main(String[] args){

	databaseHandler db_handler = new databaseHandler();
	int itemID = 1;
	int quantity = 0;
	Calendar time = new GregorianCalendar();
	Scanner sc=new Scanner(System.in);
	Restaurant restaurant = new Restaurant();
	if (time.get(Calendar.HOUR_OF_DAY)<restaurant.openTime.get(Calendar.HOUR_OF_DAY) || time.get(Calendar.HOUR_OF_DAY)>=restaurant.closeTime.get(Calendar.HOUR_OF_DAY) ) {
		System.out.println("=========> Nadette's Restaurant is closed now. <=========");
	}
		else {
			for(;;) {
				restaurant.order = new Order();
				System.out.println("\n\t     =========> Welcome to Nadette's Restaurant <=========");
				System.out.println();
				restaurant.menu.showMenu();
				System.out.println("=> Type 0 to place the order: ");
				for(;;) {
					System.out.print("Type the Item ID: ");
					itemID = sc.nextInt();
					if (itemID == 0)
						break;
					System.out.print("=> Quantity of Item - "+itemID+": ");
					quantity = sc.nextInt();
					restaurant.order.addItem(itemID, quantity);
					
				}

				if (itemID == 0) {
					System.out.println("1. Home Delivery");
					System.out.println("2. Self Pick-up");
					int orderType = sc.nextInt();
					if (orderType == 1) {
						restaurant.order.setOrderType("delivery");
						System.out.print("Type the delivery address: ");
						restaurant.order.deliveryAddress = sc.next();
						restaurant.order.placeOrder();
						System.out.println("Bill = Rs."+restaurant.order.getBill());
						
						try {
							db_handler.prep_stmt = db_handler.conn.prepareStatement("insert into order_tbl (type, delivery_addr, bill) values (?,?,?);");
							db_handler.prep_stmt.setString(1, "delivery");
							db_handler.prep_stmt.setString(2, restaurant.order.deliveryAddress);
							db_handler.prep_stmt.setInt(3, restaurant.order.getBill());
							
							db_handler.prep_stmt.executeUpdate();
							db_handler.prep_stmt.close();
							
						}catch(SQLException se){
						   se.printStackTrace();
						}

					}
					/*else if (orderType == 2) {
						restaurant.order.setOrderType("pickup");
						System.out.println("Enter pick up time (24-h format => <hrs mints>):");
						Restaurant.orderTime[0] = sc.nextInt();
						Restaurant.orderTime[1] = sc.nextInt();
						if (restaurant.validOrderTime(Restaurant.orderTime[0],Restaurant.orderTime[1])) {
							restaurant.order.dt.hourOfDay().setCopy(Restaurant.orderTime[0]);
							restaurant.order.dt.minuteOfHour().setCopy(Restaurant.orderTime[1]);
							restaurant.order.placeOrder();	
							System.out.println(restaurant.order.getBill());
							
							try {
								db_handler.prep_stmt = db_handler.conn.prepareStatement("insert into order_tbl (type, pickupTime, bill) values (?,?,?)");
								db_handler.prep_stmt.setString(1, "pickup");
								db_handler.prep_stmt.setDate(2, (java.sql.Date) restaurant.order.pickupTime);
								db_handler.prep_stmt.setInt(3, restaurant.order.getBill());
								db_handler.prep_stmt.executeUpdate();
								
								db_handler.prep_stmt.close();
							}catch(SQLException se){
							   se.printStackTrace();
							}
						}*/
						else {
							System.out.println("Your order cannot be placed at this time");
						}
					}
				}
			}
		}
	
				
			
	}


