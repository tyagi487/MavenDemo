package com.crm.qa.testCases;

import java.io.IOException;

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

public class ContactsPageTest extends TestBase{

	
	public LoginPage loginPage;
	public HomePage homepage;
	public TestUtil testutil;
	public ContactsPage contactpage;
	
	
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		LaunchBrowser();
		System.out.println("Browser for ContactPage is launched");
		
		testutil=new TestUtil();
		
		 contactpage=new ContactsPage();
		
		loginPage = new LoginPage();
		Thread.sleep(7000);
		homepage=loginPage.login((getvalue("username")), (getvalue("password")));
		System.out.println("Login Successfully for Contacts Page");
		testutil.switchtoFrame();
		contactpage=homepage.ClickOnContactsLink();
		
		
	}
	
	@Test(priority=1)
      public void VerifiedContactsTextTest(){
    	  
    	  System.out.println("VerifiedContactsTextTest method is  Executing");
    	  
    	  Assert.assertTrue(contactpage.VerifiedContactsText(), "Contacts text is missing on page");
    	  Reporter.log("Verified Contacts Text");
    	   
    	  System.out.println("Clicking on Name CheckBox");
    	  contactpage.ClickOnNameCheckbox();
    	  
    	  Reporter.log("Clicked on Checkbox", true);
	}
	
	

	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		System.out.println("teaeDown method for ContactsPage");
	Thread.sleep(5000);
		driver.close();
		System.out.println("window close for ContactsPage");
	}
	
	
	
}
