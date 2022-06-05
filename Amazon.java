package week4.day1;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//webdriver setup		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//opening  amazon
		driver.get("https://www.amazon.in/");
		//serach for oneplus 9 pro
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		Thread.sleep(3000);
		//selecting first displaying option
		driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div")).click();
		//Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-list-item']/a/div)[3]")).click();
		//getting parent window handle
		String parent=driver.getWindowHandle();
		//switching window handle to child window
		driver.findElement(By.xpath("//h2/a/span")).click();
		Set<String> child1=driver.getWindowHandles();
		List<String>li=new ArrayList<String>(child1);
		System.out.println(li.size());
		driver.switchTo().window(li.get(1));
		Thread.sleep(4000);
		//Get the price of the first product
		String price = driver.findElement(By.xpath("//*[@class='a-lineitem a-align-top']/tbody/tr[2]/td[2]/span/span[2]")).getText();
		System.out.println("deal price is "+price);
		//Print the number of customer ratings for the first displayed product
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
		System.out.println("no of people rating for this product : "+text);
		//taking screenshot of the child window
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:/Users/HP/Pictures/Saved Pictures/vino.jpg");
		FileUtils.copyFile(source, destination);
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//8 Get the cart subtotal and verify if it is correct.
		Thread.sleep(4000);
		String subtotal=driver.findElement(By.xpath("//*[@class='a-column a-span11 a-text-left a-spacing-top-large']/span[2]/span")).getText();
		System.out.println("subtotal is"+subtotal);
			if(price.equals(subtotal))
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("fail");
			}
		driver.quit();
		
		

	}

}
