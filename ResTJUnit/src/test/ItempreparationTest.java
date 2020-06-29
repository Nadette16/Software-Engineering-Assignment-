package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.ItemPreparation;

public class ItempreparationTest {
ItemPreparation test;

@Before
public void setUp()
{
		test = new ItemPreparation();
	}

	@Test
	public void testgetAvailableCooks() {
		assertEquals(test.getAvailableCooks(), 4);
	}
	
	@Test
	public void testgetPreparationTime() {
		assertEquals(test.getPreparationTime(), null);
	}
	
	@Test
	public void testprepareItem() {
		assertFalse ("No cook is available. Kindly wait", getAvailableCooks() > 0 );
	}

	public int getAvailableCooks() {
		// TODO Auto-generated method stub
		return 0;
	}
}
