package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shippingpage {

	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public shippingpage(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id="cgv")
	WebElement termsofservice;

	@FindBy(name="processCarrier")
	WebElement proceedtocheckout;

	public void clickonproceedtocheckout() {

		proceedtocheckout.click();
	}

	public void clickontermsofservice() {

		termsofservice.click();
	}


}
