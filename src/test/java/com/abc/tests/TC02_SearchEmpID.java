package com.abc.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.abc.base.BaseSetup;
import com.abc.pages.BasePage;
import com.abc.pages.EmployeePage;

public class TC02_SearchEmpID  extends BaseSetup{

	BasePage basePage;
	EmployeePage employeePage;
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 0)
	public void login() {
		basePage = new BasePage(driver);
		basePage.launchApplication();
		basePage.login();
	}
	
	@Test(priority = 1)
	public void searchEmployeesByID() throws InterruptedException {
		employeePage = new EmployeePage(driver);
		employeePage.searchUsersByID("0212");
	}
	
	@Test(priority = 2)
	public void validateEmployeeID() {
		softAssert.assertEquals("0212", employeePage.validateEmployeeID());
		
	}
	
	@Test(priority = 3)
	public void logout() {
		System.out.println("last one");
		softAssert.assertAll();
	}
}
