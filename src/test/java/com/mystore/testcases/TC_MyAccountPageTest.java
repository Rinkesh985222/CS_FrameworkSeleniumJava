package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountcreationdetails;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;
import com.mystore.pageobject.registereduseraccount;

public class TC_MyAccountPageTest extends BaseClass {


	@Test(enabled=false)
	public void verifyRegistrationAndLogin() {

	    indexpage indexpg = new indexpage(driver);

		indexpg.clickonsignin();
		logger.info("clicked on sign in link");

		myaccount myaccountpg = new myaccount(driver);
		myaccountpg.enterCreateEmaiAddress("cs127@gmail.com");
		logger.info("email address is entered in create account section");

		myaccountpg.clickSubmitCreate();

		logger.info("clicked on create an account button");

		accountcreationdetails accountcreationpg=new accountcreationdetails(driver);

		accountcreationpg.selectTitleMrs();
		accountcreationpg.enterfirstname("Rinkesh");
		accountcreationpg.enterlastname("Kumar");
		accountcreationpg.enterpassword("cs123");
		accountcreationpg.addressFirstName("Rinkesh");
		accountcreationpg.addressLastName("Kumar");
		accountcreationpg.enteraddress("Gol Bagicha Devi Asthan");
		accountcreationpg.entercity("Gaya");
		accountcreationpg.selectstate("Alabama");
		accountcreationpg.enterpostcode("00000");
		accountcreationpg.selectcountry("United States");
		accountcreationpg.entermobile("9852221076");
		accountcreationpg.enteralias("Tekari Road");

		logger.info("entered user details on account creation page:");

		accountcreationpg.clickonregister();

		logger.info("clicked on register button");

		registereduseraccount regUser=new registereduseraccount(driver);
		String userName=regUser.getusername();
		Assert.assertEquals(userName, "Rinkesh Kumar");


	}

	@Test(enabled=false)
	public void veryfylogin() throws IOException {

		logger.info("veryfylogin test case execution started");
		indexpage indexpg = new indexpage(driver);

		indexpg.clickonsignin();
		logger.info("clicked on sign in link");

		myaccount myaccountpg = new myaccount(driver);
		myaccountpg.enteremailaddress("cs127@gmail.com");
		logger.info("email address is entered");
		myaccountpg.enterpassword("cs123");
		logger.info("password is entered");
		myaccountpg.clickonsignin();
		logger.info("clicked on signin button");
		
		registereduseraccount regUser=new registereduseraccount(driver);
		String userName=regUser.getusername();
		if(userName.equals("Rinkesh Kumar")) {
			logger.info("veryfylogin passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("veryfylogin failed");
			capturescreenshot(driver,"veryfylogin");
			Assert.assertTrue(false);
		}

	}
	@Test
	public void signout() {
		
		logger.info("Search product test case execution started");
		indexpage indexpg = new indexpage(driver);

		indexpg.clickonsignin();
		logger.info("clicked on sign in link");

		myaccount myaccountpg = new myaccount(driver);
		myaccountpg.enteremailaddress("cs127@gmail.com");
		logger.info("email address is entered");
		myaccountpg.enterpassword("cs123");
		logger.info("password is entered");
		myaccountpg.clickonsignin();
		logger.info("clicked on signin button");
		registereduseraccount regUser=new registereduseraccount(driver);
		regUser.signout1();
		
		logger.info("signout clicked");
		
		if(myaccountpg.getPageTitle().equals("Login - My Store")){
			logger.info("signout passed");
			Assert.assertTrue(true);
			
		}
		
		else {
			logger.info("signout gets failed");
			try {
				capturescreenshot(driver,"signout");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			Assert.assertTrue(false);
		}
	
	}

}
