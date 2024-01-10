package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGParctice 
{
	@Test(invocationCount = 2,priority = 1)
	public void createCustomer() {
		System.out.println("create");
	}
	@Test(enabled = false)
	public void modifyCustomer() {
		System.out.println("modify");
	}
	@Test()
	public void deleteCustomer() {
		//Assert.fail();
		System.out.println("delete");
	}
	@Test (dependsOnMethods = "deleteCustomer")
	public void updateCustomer() {
		System.out.println("update");
	}
	

}
