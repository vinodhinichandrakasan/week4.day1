package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class IRCTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--disable-notifications");
	     
	     WebDriver driver=new ChromeDriver(options);
	     
	     driver.get("https://www.irctc.co.in/nget/train-search");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     driver.findElement(By.xpath("//*[text()='OK']")).click();
	     driver.findElement(By.linkText("FLIGHTS")).click();
	     String parentwindow = driver.getWindowHandle();
	     Set<String> handle1 = driver.getWindowHandles();
	     List<String> list1=new ArrayList<String>(handle1);
	     driver.switchTo().window(list1.get(1));
	     //driver.switchTo().window(parentwindow);
	     
	     driver.getTitle();
	     driver.close();

	}

}
