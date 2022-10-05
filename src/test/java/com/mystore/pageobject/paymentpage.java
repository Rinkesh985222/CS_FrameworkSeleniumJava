package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentpage {
	
	//create object of Webdriver
		WebDriver ldriver;

		//constructor
		public paymentpage(WebDriver rdriver) {


			ldriver=rdriver;

			PageFactory.initElements(rdriver, this);

		}
		
		@FindBy(className="bankwire")
		WebElement paybybankwire;
		
		@FindBy(className="cheque")
		WebElement paybycheck;
		
		public void clickonpaybywire() {
			paybybankwire.click();
			
		}
		
		public void clickonpaybycheck() {
			paybycheck.click();
			
		}
		
		
		
		
		

}
