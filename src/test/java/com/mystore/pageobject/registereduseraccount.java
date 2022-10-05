package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registereduseraccount {

	//create object of Webdriver
	WebDriver ldriver;

	//constructor
	public registereduseraccount(WebDriver rdriver) {


		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	//identify webelement

	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement username;

	@FindBy(linkText="Sign out")
	WebElement signout;

	@FindBy(name="search_query")
	WebElement Searchbox;

	@FindBy(name="submit_search")
	WebElement submit_search;

	public void signout1() {

		signout.click();
	}

	public String getusername() {

		String text=username.getText();
		return text;
	}

	public void enterdatainsearchbox(String searchkey) {

		Searchbox.sendKeys(searchkey);
	}

	public void clickonsearchbutton() {

		submit_search.click();
	}


}
