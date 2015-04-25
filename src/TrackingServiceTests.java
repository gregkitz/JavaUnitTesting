import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;


public class TrackingServiceTests {
	private TrackingService service;
	
	
	@BeforeClass
	public static void before () {
		System.out.println("Before class"); 
	}
	
	@Before 
	public void setup()
	{
		System.out.println("Before"); 
		service = new TrackingService(); 
	}
	
	
	@Test
	@Category(GoodTestsCategory.class)
	public void NewTrackingServiceTotalIsZero()
	{
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	@Test
	@Category(BadCategory.class)
	public void WhenAddingProteinTotalIncreasesByThatAmount () 
	{
		service.addProtein(10); 
		assertEquals("Service amount was not correct", 10, service.getTotal());
	}
	@Test
	@Category(GoodTestsCategory.class)
	public void WhenRemovingProteinTotalRemainsZero()
	{
		service.removeProtein(5); 
		assertEquals(0,service.getTotal());
	}
	@Test(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException { 
		service.setGoal(-5);
	}
	@Test(timeout = 200)
	public void BadTest(){
		for (int i = 0; i < 10000000; i++){
			service.addProtein(1); 
		}
	}
}
