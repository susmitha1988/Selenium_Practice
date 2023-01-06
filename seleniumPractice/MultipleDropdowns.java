package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/contact-sales/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement noofemployees=driver.findElement(By.name("NoOfEmployees"));
		WebElement country=driver.findElement(By.name("Country"));
		multipledropdowns(noofemployees,"26 - 50");
		multipledropdowns(country,"Australia");

		//driver.quit();

	}
	
	public static void multipledropdowns(WebElement we,String value) throws InterruptedException {
		
		Select st=new Select(we);		
		List<WebElement> li=st.getOptions();
		for(WebElement option:li) {
			if(option.getText().equals(value)) {
				option.click();
				Thread.sleep(2000);
			}
		}
	}

}
