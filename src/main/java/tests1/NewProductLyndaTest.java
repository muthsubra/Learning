package com.bayamp.uiautomation.uitests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewProductLyndaTest {

	protected WebDriver driver;
	protected String url;

	@BeforeClass
	public void setUp()throws Exception {
		driver = new FirefoxDriver();
		url = "http://lynda.com";
	}

	@Test
	public void loginTest1() throws Exception {
		
		//WebDriver driver = new FirefoxDriver();
		driver.get(url);
		String mainWindow = driver.getWindowHandle();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait loadWait = new WebDriverWait(driver,20);
		
		//Performing the user selections
		driver.findElement(By.xpath("//*[@id='sub-nav']/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='main-content']/div[1]/div[4]/div/div[1]/a/strong")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='linkedin_button']")).click();
		
		//switch to child window (linkedin)
		for (String childWindow : driver.getWindowHandles()){
			driver.switchTo().window(childWindow);
		}
		//input user login credentials
		driver.findElement(By.xpath("//*[@id='session_key-oauth2SAuthorizeForm']")).sendKeys("kumar152478@gmail.com");
		driver.findElement(By.xpath("//*[@id='session_password-oauth2SAuthorizeForm']")).sendKeys("American50");
		driver.findElement(By.xpath("//*[@id='body']/div/form/div[2]/ul/li[1]/input")).click();
		driver.switchTo().window(mainWindow);
		
		//Validating Switch to main window.
		String validation = driver.findElement(By.xpath("//*[@id='registrationForm']/div[3]/div[2]/div/h5[1]")).getText();
		Assert.assertEquals("Confirm Your Billing Cycle" , validation);
		System.out.println(validation);
	}
		@AfterClass
		public void closeBrowser(){
         driver.close();
         driver.quit();
	}

}
