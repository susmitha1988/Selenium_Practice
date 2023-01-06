package seleniumPractice;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingDate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/"); 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     Thread.sleep(5000);
	   
	        driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
	        Thread.sleep(2000);
	        Date sampleDate = new Date(9/15/2022); // initialising the date object with the current date 
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM yyyy");
	        String date = formatter.format(sampleDate); // formatting the date object in dd-MMM yyyy format
	        String splitter[] = date.split("-");
	        String monthYear = splitter[1]; // storing the month and year concatenated string excluding the day number
	        String day = splitter[0]; // storing the day number in the current date
	        System.out.println(monthYear);
	        System.out.println(day);

	        selectDate(monthYear,day,driver); // function invocation
	        Thread.sleep(3000);
	}

	        public static void selectDate(String monthYear, String select_day,WebDriver driver) throws InterruptedException
	        { 
	           List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
	           for (int i=0; i<elements.size();i++)
	           {
	              System.out.println(elements.get(i).getText());
	              //Selecting the month
	              if(elements.get(i).getText().equals(monthYear))
	              {
	                 //Selecting the date 
	                 List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));
	                 for (WebElement d:days)
	                 { 
	                    System.out.println(d.getText());
	                    if(d.getText().equals(select_day))
	                    {
	                       d.click();
	                       Thread.sleep(10000);
	                       return;
	                    }
	                 }
	              }
	           }
	           // if we do not find the matching month and year, we click on the arrow button to load new months.
	           driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
	           selectDate(monthYear,select_day,driver); // function invocation
	        }

}	


