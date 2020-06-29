package test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import main.Menu;

public class MenuTest extends Menu {
	 @Rule
	  public final TextFromStandardInputStream systemInMock
	    = TextFromStandardInputStream.emptyStandardInputStream();
	
	@Test
public void testaddItem(){
	    systemInMock.provideLines("Item name: ", "another line");
	    Menu inputOutput = new Menu();
	    assertNotEquals("Item name: ", inputOutput.toString());
	

}
}