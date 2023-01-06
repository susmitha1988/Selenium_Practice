package com.paex.seleniun.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MypracticeSelenium {
	@Test
	public void TestingBypassingvaliddata() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\eclipse-workspace\\com.KOHLS.LoginPage\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enter your password')]")));
		driver.get("https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&prevRID=QR7PPFK979GVPWV9AGRZ&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_customer_name")).sendKeys("Manasa");
        driver.findElement(By.id("ap_email")).sendKeys("7894561238");
		driver.findElement(By.id("ap_password")).sendKeys("Manasa@123");
		driver.findElement(By.id("ap_password_check")).sendKeys("Manasa@123");
		driver.findElement(By.id("continue")).click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Authentication required");
        
        
		
	}


}
