package com.assignment1.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assignment1.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties props;
	

	public TestBase(){
		try{
			props=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/assignment1/config/config.properties");
			props.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void intialization(){
		String browserName = props.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"/src/main/java/com/assignment1/config/chromedriver.exe");
			driver= new ChromeDriver();
			
		}//Assignment only done for chrome only, we can extend the same with other browsers also using else if
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECIT_WAIT,TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
		
	}
}
