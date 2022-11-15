package com.abc.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.abc.base.BaseSetup;
import com.abc.pages.BasePage;
import com.abc.pages.EmployeePage;

public class TC01_SearchEmployees extends BaseSetup{
	
	BasePage basePage;
	EmployeePage employeePage;
	
	SoftAssert softAssert = new SoftAssert();
	@Test(priority = 0)
	public void login(Method m) {
		basePage = new BasePage(driver);
		basePage.launchApplication();
		basePage.login();
		extentTest.info(m.getName());
	}
	
	@Test(priority = 1)
	public void searchEmployeesByName(Method m) throws InterruptedException {
		employeePage = new EmployeePage(driver);
		employeePage.searchUsersByName("Linda Jane Anderson");
		extentTest.info(m.getName());
	}
	
	@Test(priority = 2)
	public void validateEmployeeResults() {
		softAssert.assertEquals("Linda Jane Anderson", employeePage.validateEmployeeName());
		softAssert.assertEquals("Administration", employeePage.validateEmployeeSubUnit());
		extentTest.info("**check  employee results");
	}

	@Test(priority = 3)
	public void logout() {
		System.out.println("last one");
		softAssert.assertAll();
		
	}
}
