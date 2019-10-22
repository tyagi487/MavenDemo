package com.crm.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	public LoginPage loginPage;

	public HomePage homepage;
	
	public TestUtil testutil;
	
	public ContactsPage contactpage;
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		LaunchBrowser();
		System.out.println("Browser for HomePage is launched");
		
		testutil=new TestUtil();
		
		loginPage = new LoginPage();
		Thread.sleep(7000);
		homepage=loginPage.login((getvalue("username")), (getvalue("password")));
		System.out.println("Login Successfully for Home Page");
		
	}
	
	@Test( priority = 1)
	public void VerfiyHomePageTittleTest() {
		System.out.println("VerfiyHomePageTittleTest method is  Executing");
		System.out.println("Actul HomePage Tittle is"+" "+driver.getTitle());
		String ActualTillle=homepage.VerfiyHomePageTittle();
		Assert.assertEquals(ActualTillle, "CRMPRO", "HomePage Tittle is not matched");  //"HomePage Tittle is not matched" will print when it is not matched
	}
	

	@Test(priority = 2)
	public void VerifyUserNameLableTest() throws InterruptedException {
		System.out.println("VerifyUserNameLableTest method is  Executing");
		

		
		System.out.println("Switiching to main frame for UsernameLable");
		testutil.switchtoFrame();
		
		//driver.switchTo().frame("mainpanel");   //another way to switching frame
		
		Assert.assertTrue(homepage.VerifyUserNameLable());
		Reporter.log("UserNameLableTest verified", true);
	
	}
	
	@Test(priority=3)
	public void ClickOnContactsLinkTest() {
		System.out.println("ClickOnContactsLinkTest method is  Executing");
	
		System.out.println("Switching to main fram for contacts Link");
		testutil.switchtoFrame();
		
		//driver.switchTo().frame("mainpanel");
		
		 contactpage=homepage.ClickOnContactsLink();
		 System.out.println("Click on contacts link successfully");
	}
	
	/*@Test
	public void ClickOnDealsLinkTest() {
		System.out.println("ClickOnDealsLinkTest method is  Executing");
		
	}
	
	@Test
	public void ClickOnTasksLinkTest() {
		System.out.println("ClickOnTasksLinkTest method is  Executing");
		
	}*/


	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		System.out.println("teaeDown method for HomePage");
	Thread.sleep(5000);
		driver.close();
		System.out.println("window close for HomePage");
	}
	
        
	
	
	
	
}
