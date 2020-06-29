package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.item;

public class itemtest {

	@Test
public void testItem() {
		new item("Bacon","sidedish",10);
		assertEquals(item.price, 10);
		assertEquals(item.name, "Bacon");
}

	@Test
	public void testGetPrice() {
		new item("Salad","side dish",10);
		assertEquals(item.getPrice(),10);
	}
	@Test
	public void testGetName() {
		new item("Salad","side dish",10);
		assertEquals(item.getName(),"Salad");
	}

	@Test
	public void testGetCategory() {
		new item("Salad","sidedish",10);
		assertEquals(item.getCategory(),"sidedish");
		}

}
