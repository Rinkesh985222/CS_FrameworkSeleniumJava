package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchresultpage {

	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public Searchresultpage(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(linkText="Faded Short Sleeve T-shirts")
	WebElement searchresultproduct;
	
	@FindBy(linkText="More")
	WebElement More;
	
	@FindBy(xpath="\"Faded Short Sleeve T-shirts\"")
	WebElement tshirtproduct;
	
	@FindBy(xpath="//a[@class='addToWishlist wishlistProd_1']")
	WebElement addtowishlist;
	
	@FindBy(xpath="//p[@class='fancybox-error']")
	WebElement alertforaddtowishlist;
	

	public String getsearchresultproductname() {
		return (searchresultproduct.getText());

	}
	
	public void clickonmorelink() {
		
		More.click();
	}
	
	public void mousehoverontshirtproduct() {
		
		Actions actionobj=new Actions(ldriver);
		actionobj.moveToElement(tshirtproduct).build().perform();
	}
	
	public void clickonaddtowishlist() {
		
		addtowishlist.click();
	}
	
	public String getalert() {
		
		return(alertforaddtowishlist.getText());
	}


}
