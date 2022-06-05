package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://www.leafground.com/pages/Window.html");
		// maximize the window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// home button click
		String Parent = driver.getWindowHandle();
		driver.findElement(By.id("home")).click();

		Set<String> win = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(win);
		driver.switchTo().window(l1.get(1));
		driver.close();
		driver.switchTo().window(Parent);
		//Open Multiple Windows
		 driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		  
		  Set<String> win1 = driver.getWindowHandles(); 
		  List<String> l2=new ArrayList<String>(win1);
		  System.out.println(l2.size());
		  for (int i = 1; i < l2.size(); i++) {
			  System.out.println(driver.switchTo().window(l2.get(i)).getTitle());
			  driver.close();
		     }
		   driver.switchTo().window(Parent); 
		 //Wait for 2 new Windows to open
			 driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
			 Set<String> win3 = driver.getWindowHandles();
			 List<String> l4=new ArrayList<String>(win3);
			 for (int i = 1; i < l4.size(); i++) {
				 Thread.sleep(5000);
				 System.out.println(driver.switchTo().window(l4.get(i)).getTitle());
				 driver.close();
			  }
			 System.out.println("Wait for 2 new Windows to open by 5 seconds");
			 driver.switchTo().window(Parent);
			//do not close 
			  driver.findElement(By.id("color")).click();
			  System.out.println("test"); Set<String> win2 = driver.getWindowHandles();
			  List<String> l3=new ArrayList<String>(win2);
			  System.out.println(l3.size());
			  for (int i = 1; i < l3.size(); i++) {
					 
					 driver.switchTo().window(l3.get(i));
					 
				  }
			  driver.switchTo().window(Parent);
			  Thread.sleep(5000);  
			  System.out.println("do not close is successfully completed");
			  driver.close();
		
		

	}

}
