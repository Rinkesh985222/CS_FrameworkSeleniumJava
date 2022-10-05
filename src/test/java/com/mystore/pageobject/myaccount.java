package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaccount {
	
	//create object of Webdriver
		WebDriver ldriver;
		
		//constructor
		public myaccount(WebDriver rdriver) {
			
			ldriver = rdriver;
			
			PageFactory.initElements(rdriver, this);
			
			
		}
		
		//identify Webelement
		
		@FindBy(id="email_create")
		WebElement createemailid;
		
		@FindBy(id="SubmitCreate")
		WebElement submitcreate;
		
		@FindBy(id="email")
		WebElement regemailaddress;
		
		@FindBy(id="passwd")
		WebElement regpassword;
		
		@FindBy(id="SubmitLogin")
		WebElement signin;
		
		//identify action on webelement
		
		public void enterCreateEmaiAddress(String emailAdd) {
			
			createemailid.sendKeys(emailAdd);
		}
		
		public void clickSubmitCreate() {
			
			submitcreate.click();
		}
		
        public void enteremailaddress(String emailAdd) {
			
        	regemailaddress.sendKeys(emailAdd);
		}

        public void enterpassword(String pwd) {
			
        	regpassword.sendKeys(pwd);
		}
        
        public void clickonsignin() {
			
        	signin.click();
		}
        
        public String getPageTitle() {
        	return(ldriver.getTitle());
        }
        
}
