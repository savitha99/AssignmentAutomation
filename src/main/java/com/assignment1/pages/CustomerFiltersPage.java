package com.assignment1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.assignment1.base.TestBase;

public class CustomerFiltersPage extends TestBase {
	
	
	public CustomerFiltersPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#q_username_input>select")
	private WebElement userNameCombo;
	
	
	@FindBy(css="#q_email_input>select")
	private WebElement emailCombo;
	
	@FindBy(id="q_username")
	private WebElement userNameText;
	
	
	@FindBy(id="q_email")
	private WebElement emailTest;
	
	@FindBy(name="commit")
	private WebElement filterButton;
	
	
	public void getUserComboOptions(){
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='q_username_input']/select")));
		dropdown.selectByValue("Equals");
		
	}
	
	public void getEmailCombo(){
		Select select = new Select(emailCombo);
		select.selectByValue("Equals");
		
	
		
	}
	public void setUserName(){
		userNameText.sendKeys(props.getProperty("user"));
	}
	
	public void setEmail(){
		emailTest.sendKeys(props.getProperty("email"));
	}
	
	public void clickFilter(){
		filterButton.click();
	}
	
	public HomePage filterCustomers(){
		setUserName();
		setEmail();
		clickFilter();
		return new HomePage();
	}
	
	
	

}
