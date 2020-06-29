package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Order;
import main.item;


public class ordertest{
	private Order testOrder;
	
	
	@Before
	public void setUp()
	{
		testOrder = new Order();
		}
	


	@Test
	public void testOrder() {
		Assert.assertNotNull(testOrder);
	}

	@Test
	public void testIsDelivery() {
		testOrder.setOrderType("delivery");
		assertTrue(testOrder.isDelivery());
	}

	@Test
	public void testIsPickup() {
		testOrder.setOrderType("pickup");
		assertTrue(testOrder.isPickup());
	}

	@Test
	public void testGetOrderType() {
		testOrder.setOrderType("pickup");
		assertEquals(testOrder.getOrderType(), "pickup");
	}
	@Test
	public void testCalcBill() {
		item Item = new item("Garlic Bread","Appetizer",250);
		testOrder.additem(Item, 4);
		int expected = testOrder.calcBill();
	    int actual = 1000;
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void testGetBill() {
		item item = new item("Garlic Bread","Appetizer",200);
		testOrder.additem(item, 4);
		testOrder.calcBill();
		int expected = testOrder.getBill();
	    int actual = 800;
		Assert.assertNotEquals(expected, actual);

}
}
