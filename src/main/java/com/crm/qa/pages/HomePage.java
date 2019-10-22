package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

import lombok.Getter;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'User: Akash Tyagi')]")
	private @Getter WebElement userNamelable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private @Getter WebElement ContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private @Getter WebElement DealsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private @Getter WebElement TaskLink;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean VerifyUserNameLable() {
		
		return userNamelable.isDisplayed();
	}
	
	
	public String VerfiyHomePageTittle() {
		return driver.getTitle();
	}
	
	
public ContactsPage ClickOnContactsLink() {
		
	ContactLink.click();
	return new ContactsPage();
		
	}
	
	public DealsPage ClickOnDealsLink() {
		
		DealsLink.click();
		return new DealsPage();
		
	}
	
	public TasksPage ClickOnTasksLink() {
		TaskLink.click();
		return new TasksPage();
	}
	
}
