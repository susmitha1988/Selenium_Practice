package seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	@Test
	public void multiplewindows() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.linkText("Open a popup window")).click();
		driver.findElement(By.linkText("SeleniumTutorial")).click();
		Set<String> Mwindows=driver.getWindowHandles();
	    Iterator<String> IT=Mwindows.iterator();
	    String window1=IT.next();
	    String window2=IT.next();
	    Thread.sleep(2000);
	    String window3=IT.next();
	    Thread.sleep(2000);
	    driver.switchTo().window(window3);
	    	
	    }

}
