package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productpage {

	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public productpage(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id="quantity_wanted")
	WebElement quantity;

	@FindBy(id="group_1")
	WebElement size;

	@FindBy(id="color_14")
	WebElement color;

	@FindBy(name="Submit")
	WebElement addtocart;

	@FindBy(linkText="Proceed to checkout")
	WebElement proceedtocheckout;


	public void enterquantity(String Qty) {

		quantity.clear();
		quantity.sendKeys(Qty);
	}

	public void selectsize(String sizetype) {

		Select obj=new Select(size);
		obj.selectByVisibleText(sizetype);
	}

	public void choosecolor() {

		color.click();
	}

	public void clickonaddtocart() {

		addtocart.click();
	}

	public void clickproceedtocheck() {

		proceedtocheckout.click();
      
	}
	
}
