package seleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     // Loading the website
	     driver.get("http://www.interviewbit.com/");
	     String parent=driver.getWindowHandle(); // storing the parent window name as a string 
	     List<WebElement> links = driver.findElements(By.tagName("a")); // storing the list of all the elements having an anchor tag
	     Iterator<WebElement> it = links.iterator();
	     // Iterating over the list elements one by one and clicking all the links to open new child windows
	     while(it.hasNext()){
	        it.next().click();
	     }
	     Set<String> s = driver.getWindowHandles(); // Storing the list of all the child windows
	     Iterator<String> I1= s.iterator();
	     // Iterating over the list of child windows 
	     while(I1.hasNext())
	     {
	        String child_window=I1.next();
	        if(!parent.equals(child_window))
	        {
	           driver.switchTo().window(child_window);
	           System.out.println(driver.switchTo().window(child_window).getTitle());
	           driver.close();
	        }
	     }
	     //switch to the parent window
	     driver.switchTo().window(parent);
	  }

}
