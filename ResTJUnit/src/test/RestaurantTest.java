package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Assert;
import org.junit.Test;


import main.Restaurant;

public class RestaurantTest extends Restaurant{ 
	
	 @Test
	    public void openTimeTest() throws Exception {
	        String edmT1 = "11";

	        DateTimeFormatter fmt = ISODateTimeFormat.dateTimeParser();
	        DateTime openTime = fmt.parseDateTime(edmT1);
	        assertFalse("Hour is 11", openTime.getHourOfDay() == 7);
	        assertFalse("Minute is 53", openTime.getMinuteOfHour() == 53);
	        assertTrue("Second is 0",openTime.getSecondOfMinute() == 0);
	       
	    }
	 
	 @Test
	    public void closeTimeTest() throws Exception {
	        String edmT2 = "22";

	        DateTimeFormatter fmt = ISODateTimeFormat.dateTimeParser();
	        DateTime closeTime = fmt.parseDateTime(edmT2);
	        assertFalse("Hour is 22", closeTime.getHourOfDay() == 7);
	        assertTrue("Minute is 0", closeTime.getMinuteOfHour() == 0);
	        assertTrue("Second is 0", closeTime.getSecondOfMinute() == 0);
	       
	    }
	@Test
			public void testValidOrderTime() {
				int orderHour = 9, orderMint = 15;
				assertFalse(validOrderTime(orderHour, orderMint));
				orderHour = 14; orderMint = 10;
				assertTrue(validOrderTime(orderHour, orderMint));
				orderHour = 10; orderMint =30;
				assertFalse(validOrderTime(orderHour, orderMint));		
			}
	GregorianCalendar g1;

    static GregorianCalendar openTime;
    static {
        openTime = new GregorianCalendar();
        openTime.setTimeZone(TimeZone.getTimeZone("GMT+00"));
        openTime.setTimeInMillis(0L);
    }
@Test
    public void testBasicConstructor() {
        g1 = new GregorianCalendar();
        assertNotNull(g1);
    }
@Test
    public void testopenTime() {
        Assert.assertEquals(1,                    openTime.get(Calendar.DATE));
        Assert.assertEquals(1,                    openTime.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(1,                    openTime.get(Calendar.DAY_OF_YEAR), 1);
       Assert.assertEquals(Calendar.THURSDAY,    openTime.get(Calendar.DAY_OF_WEEK), Calendar.THURSDAY);
        Assert.assertEquals(1,                    openTime.get(Calendar.DAY_OF_WEEK_IN_MONTH), 1);
     Assert.assertEquals(Calendar.AM,          openTime.get(Calendar.AM_PM), Calendar.AM);
        Assert.assertEquals(0,                    openTime.get(Calendar.HOUR), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.HOUR_OF_DAY), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.MINUTE), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.SECOND), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.MILLISECOND), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.ZONE_OFFSET), 0);
        Assert.assertEquals(0,                    openTime.get(Calendar.DST_OFFSET), 0);
    }

  
}