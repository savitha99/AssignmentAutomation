package com.assignment1.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment1.base.TestBase;

public class CustomerViewPage extends TestBase {
	
@FindBy(id="page_title")
private WebElement viewPageTitle;

@FindBy (css=".flash.flash_notice")
private WebElement infoMsg;

@FindBy(linkText="Edit User")
private WebElement editButton;

@FindBy(linkText="Delete User")
private WebElement deleteButton;


@FindBy (css=".row.row-email>td")
private WebElement emailName;

@FindBy (css=".row.row-username>td")
private WebElement userName;

@FindBy (css=".row.row-created_at>td")
private WebElement createdDate;

@FindBy (id="page_title")
private WebElement editPageTitle;

@FindBy (linkText="Cancel")

private WebElement cancelEdit;


public CustomerViewPage() {
	PageFactory.initElements(driver, this);
}
public String getUserName(){
	return userName.getText();
}

public String getEmailAddr(){
	return emailName.getText();
}
public String getCreatedDate(){
	return createdDate.getText();
}

public void clickEditButton(){
	editButton.click();
}
public String getEditPageTitle() {
	return editPageTitle.getText();
}

public HomePage deleteUser(){
	deleteButton.click();
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
	 return new HomePage();
}

public HomePage cancelEdit(){
	cancelEdit.click();
	return new HomePage();
}



}
