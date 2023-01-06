package seleniumPractice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShot {
	@Test
	public void screenshot() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("drop1"));
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file,new File(System.getProperty("user.dir")+"\\screenshot.png"));
	}

}
