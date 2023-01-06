package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenLink {
	public static void main(String[] args) {
		
	       String pageURL = "http://www.interviewbit.com";
	       String url = "";
	       HttpURLConnection huc = null;
	       int responseCode = 200;
	       System.setProperty("webdriver.chrome.driver","C:\\Users\\chiru\\Driver\\chromedriver.exe");
	       ChromeOptions options = new ChromeOptions();
	       //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
	       WebDriver driver = new ChromeDriver(options);//Creating an instance of the WebDriver class
	       
	       driver.manage().window().maximize();
	       
	       driver.get(pageURL);
	       
	       List<WebElement> links = driver.findElements(By.tagName("a")); // getting hold of all the elements having the anchor tag
	       
	       Iterator<WebElement> it = links.iterator();
	       // Iterating over the obtained list of elements and checking them one by one
	       while(it.hasNext()){
	           
	           url = it.next().getAttribute("href");
	           
	           System.out.println(url);
	       
	           if(url == null || url.isEmpty()){
	               System.out.println("The linked element has invalid href url.");
	               continue;
	           }
	           
	           if(!url.startsWith(pageURL)){
	               System.out.println("URL belongs to another domain, skipping it.");
	               continue;
	           }
	           
	           try {
	               huc = (HttpURLConnection)(new URL(url).openConnection());
	               
	               huc.setRequestMethod("HEAD");
	               
	               huc.connect(); // connecting to the url
	               
	               responseCode = huc.getResponseCode(); // reading the response code on firing the url
	               
	               if(responseCode >= 400){
	                   System.out.println(url+" is a broken link");
	               }
	               else{
	                   System.out.println(url+" is a valid link");
	               }
	                   
	           } catch (MalformedURLException e) {
	               e.printStackTrace();
	           } catch (IOException e) {
	               e.printStackTrace();
	           }
	       
	       }
		
	
	       driver.quit();
		
	   }
	}




