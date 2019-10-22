package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

import lombok.Getter;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private @Getter WebElement contactsText;
	
	@FindBy(xpath="//input[@name='contact_id']")
	private @Getter WebElement NameCheckbox;
	

	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean VerifiedContactsText() {
		return contactsText.isDisplayed();
		
	}
	
	public void ClickOnNameCheckbox() {
		
		NameCheckbox.click();
	}

}
