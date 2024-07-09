package herokuapplogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login<ExtentHTMLReporter> {

	//parallel testing chromedriver and edgedriver
	ExtentHtmlReporter htmlrptr;
	ExtentReports extnt;
	ExtentTest test;

	
	
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new  ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//asseration
		 String TIL = driver.getTitle();
		 SoftAssert sa = new SoftAssert();
		 sa.assertEquals("The Internet", TIL);
		 System.out.println("Asseration is  passed chromebrowser");
		 sa.assertAll();
		 //report
		//Extent Html Reporter means we are creating a rich html report
		  htmlrptr= new ExtentHtmlReporter("extent.html");
		 //Extends reports will start building the reports with the help of extent instance
		 extnt= new ExtentReports();
		 //here i am creating the reports and i need the reports in html formate , so i am attaching my reports with html reporters
		 extnt.attachReporter(htmlrptr);

		
		 
		 
		 
		 
	
		
	}
	@Test
	public void test2() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new  EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//asseration
		 String TIL = driver.getTitle();
		 SoftAssert sa = new SoftAssert();
		 sa.assertEquals("The Internet", TIL);
		 System.out.println("Asseration is passed  edagedriver");
		 sa.assertAll();
		//report
			//Extent Html Reporter means we are creating a rich html report
			  htmlrptr= new ExtentHtmlReporter("extent.html");
			 //Extends reports will start building the reports with the help of extent instance
			 extnt= new ExtentReports();
			 //here i am creating the reports and i need the reports in html formate , so i am attaching my reports with html reporters
			 extnt.attachReporter(htmlrptr);

			
	}
}
