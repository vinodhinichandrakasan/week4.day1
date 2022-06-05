package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
	    //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 //maximize the window
		 driver.manage().window().maximize();
		 //implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
		 WebElement ele=driver.findElement(By.id("frame1"));
		 driver.switchTo().frame(ele);
		 Thread.sleep(30);
		 WebElement ele1 = driver.findElement(By.xpath("//body//input"));
		 ele1.click();
		 ele1.sendKeys("test data entered");
		 System.out.println("test");
		 WebElement el2=driver.findElement(By.id("frame3"));
		 driver.switchTo().frame(el2);
		 Thread.sleep(30);
		 WebElement ele3 = driver.findElement(By.id("a"));
		 ele3.click();
		 //ele1.sendKeys("test data entered");
		 System.out.println("test 2");
		 Thread.sleep(30);
		 driver.switchTo().defaultContent();
		 WebElement el4=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		 driver.switchTo().frame(el4);
		 
		 WebElement ele5 = driver.findElement(By.xpath("//select[@id='animals']"));
		 Select opt=new Select(ele5);
		 opt.selectByValue("avatar");
		 System.out.println("avatar is selected");
		 
		 
		 driver.close();
		
		

	}

}
