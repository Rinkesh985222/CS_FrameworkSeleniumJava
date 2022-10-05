package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountcreationdetails {
	
	//create object of Webdriver
		WebDriver ldriver;
		
		//constructor
		public accountcreationdetails(WebDriver rdriver) {
			
			
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
			
			}
		
		//identify web element
		
		@FindBy(id="uniform-id_gender2")
		WebElement titleMrs;
		
		@FindBy(id="customer_firstname")
		WebElement firstname;
		
		@FindBy(id="customer_lastname")
		WebElement lastname;
		
		@FindBy(id="passwd")
		WebElement password;
		
		@FindBy(id="firstname")
		WebElement addressfirstname;
		
		@FindBy(id="lastname")
		WebElement addresslastname ;
		
		@FindBy(id="address1")
		WebElement address;
		
		@FindBy(id="city")
		WebElement city;
		
		@FindBy(id="id_state")
		WebElement state;
		
		@FindBy(id="postcode")
		WebElement postcode;
		
		@FindBy(id="id_country")
		WebElement country;
		
		@FindBy(id="phone_mobile")
		WebElement mobile;
		
		@FindBy(id="alias")
		WebElement addressalias;
		
		@FindBy(id="submitAccount")
		WebElement register;
		
		//identify action to be performed on webelements
		
		public void selectTitleMrs() {
			
			titleMrs.click();
		}
		
public void enterfirstname(String fname) {
			
	firstname.sendKeys(fname);
		}


public void enterlastname(String lname){
	lastname.sendKeys(lname);
}

public void enterpassword(String pwd) {
	
	password.sendKeys(pwd);
}

public void addressFirstName(String afn) {
	
	addressfirstname.sendKeys(afn);
}

public void addressLastName(String aln) {
	
	addressfirstname.sendKeys(aln);
}
		
public void enteraddress(String addr ) {
	
	address.sendKeys(addr);
}

public void entercity(String City ) {
	
	city.sendKeys(City);
	
}	

public void selectstate(String text ) {
	
	Select obj=new Select(state);
	obj.selectByVisibleText(text);
}	

public void enterpostcode(String postcodename ) {
	
	postcode.sendKeys(postcodename);

}		

public void selectcountry(String text ) {
	
	Select obj=new Select(country);
	obj.selectByVisibleText(text);
}

public void entermobile(String contact ) {
	
	mobile.sendKeys(contact);

}	

public void enteralias(String text ) {
	addressalias.clear();
	addressalias.sendKeys(text);

}	

public void clickonregister() {
	
	register.click();

}	


}