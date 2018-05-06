package com.assignment1.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment1.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(css=".action_item>a")
	private WebElement newUserButton;
	
	@FindBy(id="index_table_users")
	private WebElement table;
	

@FindBy(css="#users>a")
private WebElement userMenu;

	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public CreateCustomerPage clickNewuser(){
		newUserButton.click();
		return new CreateCustomerPage();
	}
	
	public HomePage clickUserMenu(){
		userMenu.click();
		return new HomePage();

	}
	
	public List<String> getNoOfRows(){
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr//td//.."));
		List<String> rowsData = new ArrayList<String>();
		for(WebElement row:rows){
			List<WebElement> rowElements = row.findElements(By.xpath("//td"));

			List<String> rowData = new ArrayList<String>();

			for(WebElement column:rowElements){
			    rowData.add(column.getText().toString());
			}
	}

		return rowsData;


	}
}
