package com.abc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abc.utils.ReadConfig;

public class BasePage {
	WebDriver driver;
	ReadConfig readConfig;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication() {
		readConfig = new ReadConfig();
		driver.get(readConfig.getUrl());
	}

	@FindBy(name = "username")
	WebElement Username;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;
	
	public void login() {
		Username.sendKeys(readConfig.getUsername());
		Password.sendKeys(readConfig.getPassword());
		loginButton.click();
	}
}
