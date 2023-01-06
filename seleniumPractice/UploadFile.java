package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UploadFile {
@Test
public void uploadfile() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://omayo.blogspot.com/");
	WebDriverWait wait=new WebDriverWait(driver,null);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("timerButton")))).click();
	//driver.findElement(By.id("uploadfile")).sendKeys("File path");
}
}
