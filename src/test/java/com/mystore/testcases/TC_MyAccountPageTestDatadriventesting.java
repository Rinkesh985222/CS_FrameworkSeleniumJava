package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountcreationdetails;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;
import com.mystore.pageobject.registereduseraccount;
import com.mystore.utilities.ReadExcel;

public class TC_MyAccountPageTestDatadriventesting extends BaseClass {


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

	@Test(dataProvider="LoginDataProvider")
	public void veryfylogin(String email,String password,String expectedusername) throws IOException {

		logger.info("veryfylogin test case execution started");
		indexpage indexpg = new indexpage(driver);

		indexpg.clickonsignin();
		logger.info("clicked on sign in link");

		myaccount myaccountpg = new myaccount(driver);
		myaccountpg.enteremailaddress(email);
		logger.info("email address is entered");
		myaccountpg.enterpassword(password);
		logger.info("password is entered");
		myaccountpg.clickonsignin();
		logger.info("clicked on signin button");
		
		registereduseraccount regUser=new registereduseraccount(driver);
		String userName=regUser.getusername();
		
		if(userName.equals(expectedusername)) {
			logger.info("veryfylogin passed");
			Assert.assertTrue(true);
			
			regUser.signout1();
		}
		else {
			logger.info("veryfylogin failed");
			capturescreenshot(driver,"veryfylogin");
			Assert.assertTrue(false);
		}

	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider(){
		
		String fileName=System.getProperty("user.dir")+"\\Test Data\\Test Data.xlsx";
		int ttlRow=ReadExcel.getRowCount(fileName, "Sheet1");
		int ttlCol=ReadExcel.getColCount(fileName, "Sheet1");
		
		String data[][]=new String[ttlRow-1][ttlCol];
		
		for(int i=1;i<ttlRow;i++)
		{
			for(int j=0;j<ttlCol;j++)
			{
				data[i-1][j]=ReadExcel.getCellValue(fileName, "Sheet1", i, j);
			}
		}
		
		return data;	
		
	}

}
