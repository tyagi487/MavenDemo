package com.crm.qa.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoingPageTest extends TestBase {

	public LoginPage loginPage;

	HomePage homepage;

	
	
	@BeforeMethod
	public void setup() throws IOException {
		LaunchBrowser();
		loginPage = new LoginPage();
		
	}

	@Test(priority = 1)
	public void loginPageTittleTest() {
		
		

		Reporter.log("loginPageTittleTest");
		Reporter.log(driver.getTitle());
		String ActualTittle = loginPage.validatePageTitlle();
		String ExpTittle = "CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(ExpTittle, ActualTittle);
		Reporter.log("loginPageTittle varified");

	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		Reporter.log("crmLogoImageTest");
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
		Reporter.log("Validate CRM Logo", true);

	}

	@Test(priority = 3)
	public void LoginTest() throws IOException, InterruptedException {

		Reporter.log("LoginTest method");
		Thread.sleep(10000);
		loginPage.login((getvalue("username")), (getvalue("password")));
		
		Reporter.log("Successfull login to CRM");

	}

	@AfterMethod
	public void tearDown() {
		Reporter.log("tearDown");
		driver.close();
		Reporter.log("window close");
	}

}
