package com.assignment1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.assignment1.base.TestBase;

public class CreateCustomerPage extends TestBase {
	
private HomePage homePage;

@FindBy(id="user_username")
private WebElement userName ;

@FindBy(id="user_password")
private WebElement pwd ;

@FindBy(id="user_email")
private WebElement emailAddr ;

@FindBy(name="commit")
private WebElement submit ;

@FindBy(css=".cancel>a")
private WebElement cancel ;


@FindBy(id="page_title")
private WebElement userMenuTitle;

public CreateCustomerPage() {
	PageFactory.initElements(driver, this);
}

/**
 * 
 * @return String
 */
public String getTitle(){
	homePage=new HomePage();
	homePage.clickUserMenu();
	Assert.assertEquals(userMenuTitle.getText(), "Users");
	homePage.clickNewuser();
	return driver.getTitle();
}

public void createUser(String uName, String passWord,String email){
	
	userName.sendKeys(uName);
	pwd.sendKeys(passWord);
	emailAddr.sendKeys(email);
	
}
public CustomerViewPage submitExpectingSuccess(){
	submit.click();
	return new CustomerViewPage();
	
}
public HomePage cancelUserCreation(){
	cancel.click();
	return new HomePage();
}



}
