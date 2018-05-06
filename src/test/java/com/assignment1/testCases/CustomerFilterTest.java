package com.assignment1.testCases;

import org.testng.annotations.Test;

import com.assignment1.pages.CustomerFiltersPage;
import com.assignment1.pages.HomePage;

public class CustomerFilterTest extends BaseTest{

	private CustomerFiltersPage customerFiltersPage;
	
	private HomePage homePage;
	
	
	@Test
	public void filterCustomers(){
		getUsersPage();
		customerFiltersPage=new CustomerFiltersPage();
		homePage=customerFiltersPage.filterCustomers();
		
	}
	
	private  void getUsersPage(){
		homePage=new HomePage();
		homePage.clickUserMenu();
	}
	
}
