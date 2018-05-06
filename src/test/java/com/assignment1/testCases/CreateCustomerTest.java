package com.assignment1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment1.pages.CreateCustomerPage;
import com.assignment1.pages.CustomerViewPage;
import com.assignment1.pages.HomePage;

public class CreateCustomerTest extends BaseTest {
	private CreateCustomerPage createCustomerPage;
	private HomePage homePage;
	private CustomerViewPage viewPage;
	
	
	@Test(priority=1)
	public void ValidateNewUserTitle(){
		createCustomerPage=new CreateCustomerPage();
		String title=createCustomerPage.getTitle();
		Assert.assertEquals(title, "New User | Active Admin Depot","Actual did not meet the expectation");
		
	}
	@Test(dependsOnMethods={"ValidateNewUserTitle"},description="Cancel User Creation")
	public void cancelUserCreation(){
		homePage=new HomePage();
		homePage.clickUserMenu();
		createCustomerPage=homePage.clickNewuser();
		fillFormData();
		homePage=createCustomerPage.cancelUserCreation();
	}
	
	
	@Test(dependsOnMethods={"ValidateNewUserTitle"},description="Create User")
	public void createUser(){
		homePage.clickNewuser();
		fillFormData();
		viewPage =createCustomerPage.submitExpectingSuccess();
	}
	@Test(dependsOnMethods={"createUser"},description="Read Customer Details")
	public void readCustomerDetails(){
		String actualUserName =viewPage.getUserName();
		String actualEmail=viewPage.getEmailAddr();
		Assert.assertEquals(actualUserName,props.getProperty("user"), "Actual did not match expected");
		Assert.assertEquals(actualEmail,props.getProperty("email"), "Actual did not match expected");	
	}
	@Test(dependsOnMethods={"readCustomerDetails"},description="Edit Customer Details")
	public void editCustomerDetails(){
		viewPage.clickEditButton();
		Assert.assertEquals(viewPage.getEditPageTitle(), "Edit User");
	}
	
	@Test(dependsOnMethods={"editCustomerDetails"},description="Edit Customer Details")
	public void cancelEdit(){
		homePage =viewPage.cancelEdit();
}
	
	
	private void fillFormData() {
		createCustomerPage.createUser(props.getProperty("user"),props.getProperty("pwd"),props.getProperty("email"));
	}
	
	
	
	
	
	
	

}
