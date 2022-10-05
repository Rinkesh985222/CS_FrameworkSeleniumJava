package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class indexpage {
	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public indexpage(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);


	}

	//identify Webelement

	@FindBy(linkText="Sign in")
	WebElement signin;

	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement Tshirt;

	//identify action on webelement

	public void clickonsignin() {

		signin.click();

	}

	public String getPageTitle() {

		return(ldriver.getTitle());
	}

	public void clickonTshirt() {

		Tshirt.click();
	}


}
