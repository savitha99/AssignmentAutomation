package com.assignment1.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.assignment1.base.TestBase;

public class BaseTest extends TestBase {
	
	public BaseTest(){
		super();
		
	}
	@BeforeClass
	public void setUp(){
		intialization();
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	

}
