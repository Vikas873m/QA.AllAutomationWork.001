package practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void practice() 
	{
		SoftAssert sa= new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
	   Assert.assertEquals(1, 1);  //1==1
		sa.assertEquals(false, true);
			sa.assertEquals(2, 1);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		//Assert.assertEquals(0, 1);
		sa.assertEquals("A","A");
		sa.assertAll();
		
		

	}
}
