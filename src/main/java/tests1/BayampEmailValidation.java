package com.bayamp.uiautomation.uitests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BayampEmailValidation{
	
	public WebDriver driver;
	public String url;
	
	
	@BeforeClass
	public void setUp()throws Exception {
		driver = new FirefoxDriver();
		url = "http://webmail.bayamp.com";
	}
	
	@Test
	public void loginTestEmail() throws Exception {
	    //WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		WebElement userName = driver.findElement(By.id("user"));
		userName.sendKeys("user1@Bayamp.com");
		
		driver.findElement(By.id("pass")).sendKeys("user1");
		driver.findElement(By.id("login_submit")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='roundcube_cell']/a[1]/img")).click();	
		
		String validate = driver.findElement(By.xpath("//*[@id='rcmbtn101']")).getText();
		System.out.println(validate);
		Assert.assertEquals("Logout", validate);
	}
	
	@AfterClass
	public void closeWind(){
		driver.close();
		driver.quit();
		}
	}
