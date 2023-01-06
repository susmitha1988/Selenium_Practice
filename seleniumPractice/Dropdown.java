package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown {
	@Test
	public void dropdown() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.id("drop1"));
		Select se=new Select(ele);
		Thread.sleep(2000);
		se.selectByVisibleText("doc 3");
		Thread.sleep(2000);
		se.selectByIndex(1);
		Thread.sleep(2000);
		List<WebElement> li=se.getOptions();
		for(WebElement we:li)
		{
			if(we.getText().equals("doc 2")) {
				System.out.println(we.getText());
				we.click();
				break;
			}
		}
		driver.quit();
	}

}
