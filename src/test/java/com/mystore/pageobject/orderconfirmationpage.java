package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderconfirmationpage {

	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public orderconfirmationpage(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement confirmorder;

	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successalert;

	@FindBy(linkText="Sign out")
	WebElement signout;

	public void clickonconfirmorder() {

		confirmorder.click();
	}

	public String getsuccessmessage() {

		return(successalert.getText());
	}

	public void clickonsignout() {

		signout.click();
	}

}
