package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addresspage {
	
	//create object of Webdriver
			WebDriver ldriver;

			//constructor
			public addresspage(WebDriver rdriver) {


				ldriver=rdriver;

				PageFactory.initElements(rdriver, this);

			}
			
			@FindBy(name="processAddress")
			WebElement proceedtocheckout;
			
			public void clickonproceedtocheckout() {
				
				proceedtocheckout.click();
			}


}
