package com.abc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	
	WebDriver driver;
	
	public MyInfoPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name = "firstname")
	WebElement firstname;
	
	@FindBy(name ="lastname")
	WebElement lastname;
	
	
	@FindBy(xpath = "//*[@href='/web/index.php/pim/viewMyDetails']")
	WebElement Myinfo;
	
	@FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 --strong']")
	WebElement UserName;
	
	@FindBy(xpath = "//*[@class='oxd-userdropdown-name']")
	WebElement User;
	
	@FindBy(name="firstName")
	WebElement userFirstName;
	
	@FindBy(name="lastName")
	WebElement userLastName;
	
		
	public String validateUserDetails() throws InterruptedException {
	    
		Thread.sleep(3000);
		Myinfo.click();
		Thread.sleep(3000);
		String fetchedusername = UserName.getText();
		return fetchedusername;
	}
	
	public String fetchUserName() throws InterruptedException {
		
		Thread.sleep(3000);
		return User.getText();
		
	}
	
	public String getFirstName() {
		
		System.out.println(userFirstName.getAttribute("value"));
		return userFirstName.getAttribute("value");
	}
	
	public String getlastName() {
		System.out.println(userLastName.getAttribute("value"));
		return userLastName.getAttribute("value");
	}

}
