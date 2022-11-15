package com.abc.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.abc.base.BaseSetup;
import com.abc.pages.BasePage;
import com.abc.pages.EmployeePage;
import com.abc.pages.MyInfoPage;

public class TC03_VerifyUserInfo extends BaseSetup{
	
	BasePage basePage;
	EmployeePage employeePage;
	MyInfoPage myinfopage;
	String Username;
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(priority = 0)
	public void login() {
		basePage = new BasePage(driver);
		basePage.launchApplication();
		basePage.login();
	}
	
	@Test(priority = 1)
	public void verifyUser() throws InterruptedException {
		
		employeePage = new EmployeePage(driver);
		myinfopage = new MyInfoPage(driver);
		Username = myinfopage.validateUserDetails();
	}
	
	@Test(priority = 2)
	public void validateEmployeeID() throws InterruptedException {
		System.out.println("Username :"+ Username);
		System.out.println("Fetched User name :"+ myinfopage.fetchUserName());
		softAssert.assertEquals(myinfopage.fetchUserName(), myinfopage.getFirstName()+ " "+ myinfopage.getlastName());
		softAssert.assertAll();
		
	}
	
	@Test(priority = 3)
	public void logout() {
		System.out.println("last one");
		
		
	}
	

}

