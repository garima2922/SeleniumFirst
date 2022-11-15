package com.abc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

	WebDriver driver;
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='oxd-main-menu']/li[2]/a")
	WebElement sideMenuPIMButton;
	
	@FindBy(xpath = "//*[@class='oxd-topbar-body']//ul/li[2]")
	WebElement employeeTab;
	
	@FindBy(xpath = "(//*[@class='oxd-form']/div/div//*[@placeholder='Type for hints...'])[1]")
	WebElement usernameBox;
	
	@FindBy(xpath = "//*[@class='oxd-autocomplete-dropdown --positon-bottom']/div")
	List <WebElement> userNames;
	
	@FindBy(xpath ="(//*[@class='oxd-grid-item oxd-grid-item--gutters'])[2]//input")
	WebElement userIDBox;
	
	@FindBy(xpath = "//*[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']//*[text()='0212']")
	WebElement ID;
	
	
	
	public void searchUsersByName(String name) throws InterruptedException {
		sideMenuPIMButton.click();
		employeeTab.click();
		usernameBox.sendKeys("a");
		Thread.sleep(3000);
//		for(int a=0; a<userNames.size(); a++) {
//			if(userNames.get(a).getText().contains("Linda Jane Anderson")) {
//				userNames.get(a).click();
//			}
//		}
		for(WebElement users : userNames) {
			if(users.getText().contains(name)) {
				users.click();
				break;
			}
		}
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//*[@class='oxd-form-actions']/button[2]")
	WebElement searchButton;
	@FindBy(xpath = "//*[@class='oxd-table orangehrm-employee-list']/div[2]//*[@role='cell'][3]")
	WebElement usernameFromTable;
	@FindBy(xpath = "//*[@class='oxd-table orangehrm-employee-list']/div[2]//*[@role='cell'][7]")
	WebElement subUnitFromTable;
	
	public String validateEmployeeName() {
		searchButton.click();
		String searchedUserName = usernameFromTable.getText();
		return searchedUserName;
	}
	
	
	public String validateEmployeeSubUnit() {
		
		String subunitName = subUnitFromTable.getText();
		return subunitName;
	}
	
	public String validateEmployeeID() {
		searchButton.click();
		String searchedUserID = ID.getText();
		return searchedUserID;
	}
	
	public void searchUsersByID(String ID) throws InterruptedException {
		sideMenuPIMButton.click();
		employeeTab.click();
		userIDBox.sendKeys(ID);
		Thread.sleep(3000);
		
	}
	
	
	
	
}

