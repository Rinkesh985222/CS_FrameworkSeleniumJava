package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.Searchresultpage;
import com.mystore.pageobject.addresspage;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;
import com.mystore.pageobject.orderconfirmationpage;
import com.mystore.pageobject.paymentpage;
import com.mystore.pageobject.productpage;
import com.mystore.pageobject.registereduseraccount;
import com.mystore.pageobject.shippingpage;
import com.mystore.pageobject.summarypage;


public class TC_productpageTest extends BaseClass {
	@Test(enabled=false)
	public void veryfysearchproduct() {
		
		String searchkey="T-shirts";
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
		regUser.enterdatainsearchbox(searchkey);
		regUser.clickonsearchbutton();
		
		logger.info("searchkey entered and submit");
		
		Searchresultpage resultpg=new Searchresultpage(driver);
		String searchresultproductname=resultpg.getsearchresultproductname();
		
		logger.info("searchkey result is captured");
		
		if(searchresultproductname.contains(searchkey)) {
			logger.info("search product test case passed");
			Assert.assertTrue(true);
			regUser.signout1();
			}
		else {
			logger.info("search product test case failed");
			try {
				capturescreenshot(driver,"veryfysearchproduct");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Assert.assertTrue(false);
			
			}
		
		
	}
	
	@Test(enabled=false)
	public void veryfybuyproduct() {
		
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
		regUser.enterdatainsearchbox("T-shirt");
		regUser.clickonsearchbutton();
		
		logger.info("searchkey entered and submit");
		Searchresultpage resultpg=new Searchresultpage(driver);
		resultpg.clickonmorelink();
		
		productpage prodpg=new productpage(driver);
		prodpg.enterquantity("2");
		
		prodpg.selectsize("M");
		prodpg.choosecolor();
		prodpg.clickonaddtocart();
		prodpg.clickproceedtocheck();
		
		summarypage sumpg=new summarypage(driver);
		sumpg.clickonproceedtocheckout();
		
		logger.info("summary page proceeded");
		
		addresspage addpg=new addresspage(driver);
		addpg.clickonproceedtocheckout();
		
		shippingpage shipg=new shippingpage(driver);
		shipg.clickontermsofservice();
		
		logger.info("Checked Terms of Service");
		
		shipg.clickonproceedtocheckout();
		
		paymentpage paypg=new paymentpage(driver);
		paypg.clickonpaybycheck();
		
		logger.info("paybycheck passed");
		
		orderconfirmationpage ordconpg=new orderconfirmationpage(driver);
		ordconpg.clickonconfirmorder();
		
		logger.info("Clicked on i confirm order");
		
		String successmessage=ordconpg.getsuccessmessage();
		if(successmessage.equals("Your order on My Store is complete.")) {
			logger.info("Buy product test case passed");
		Assert.assertTrue(true);
		
		ordconpg.clickonsignout();
		}
		else {
			logger.info("Buy product test case failed");
			try {
				capturescreenshot(driver,"veryfybuyproduct");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Assert.assertTrue(false);
		}
		
		
	}
	@Test
	public void veryfyaddtowishlistwithoutlogin() {
		
		logger.info("Search product test case execution started");
		indexpage indexpg = new indexpage(driver);
		
		indexpg.clickonTshirt();
		
		Searchresultpage resultpg=new Searchresultpage(driver);
		//resultpg.mousehoverontshirtproduct();
		resultpg.clickonaddtowishlist();
		String alert=resultpg.getalert();
		
		if(alert.equals("You must be logged in to manage your wishlist.")) {
			
			logger.info("veryfyaddtowishlistwithoutlogin is passed");
			Assert.assertTrue(true);
		}

		else {
			
			logger.info("veryfyaddtowishlistwithoutlogin is failed");
			try {
				capturescreenshot(driver,"veryfyaddtowishlistwithoutlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}
		
	}

}
