package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.crm.qa.Base.TestBase;

import lombok.Getter;

public class LoginPage extends TestBase {
	
	//object Repository
	
	@FindBy(name="username")
	private @Getter WebElement username;
	
	@FindBy(name="password")
	private @Getter WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	private @Getter WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private @Getter WebElement SignUpBtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	private @Getter WebElement crmlogo;
	
	//initlization
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions on Login page
	
	public String validatePageTitlle() {
		
		System.out.println("validatePageTitlle");
		return driver.getTitle();
	}
   
   public HomePage login(String un, String pwd) {
	   System.out.println("Login page called");
	   username.sendKeys(un);
	   password.sendKeys(pwd);
	   loginBtn.click();
	   return new HomePage(); 
   }
   
   public void InvalidLogin() {
	   System.out.println("InvalidLogin called");
	   String exptxt="Sign Up";
	String Actualtxt=driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).getText();
		Assert.assertEquals(Actualtxt, exptxt);
		Reporter.log("Invalid login Verified as SignUp txt is showing",true);
   }

public boolean validateCRMLogo() {
	System.out.println("validateCRMLogo called");
	return  crmlogo.isDisplayed();
}
	
}
