package PROJECT_2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WebTest {
	ChromeDriver driver;
	ExtentReports report;
	 @BeforeSuite
	 public void term1() {
		 System.out.println(" session started ");
	 }
	 @BeforeTest
	 public void start() {
		 System.out.println("Test has been started");
	 }
	 @BeforeMethod
		public void begin() {

			driver=new ChromeDriver();
			driver.manage().window().maximize();
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setReportName("shopping website report");
			reporter.config().setDocumentTitle("tutorialsninja");
			report = new ExtentReports();
			report.attachReporter(reporter);
			report.setSystemInfo("created by", "SAHANA");
			report.setSystemInfo("operating system", "windows");
}
	 @Test
		public void DemoTest() throws InterruptedException {
	ExtentTest etest =report.createTest("test_1");
			driver.get("https://www.demoblaze.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	etest.info("website opened");
	        driver.findElement(By.linkText("Sign up")).click();
	        Thread.sleep(3000);
	        etest.info("sign up started");
	        driver.findElement(By.xpath("//input[@id=\"sign-username\"]")).sendKeys("mouna12");
       driver.findElement(By.xpath("//input[@id=\"sign-password\"]")).sendKeys("mouna12@123");
       driver.findElement(By.xpath("//button[text()=\"Sign up\"]")).click();
       etest.info("sign up completed");
//       driver.findElement(By.id("alert")).click(); 
       Thread.sleep(3000);
       
		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
	 Thread.sleep(3000);
		alert.accept();
	
		 driver.findElement(By.xpath("(//button[text()=\"Close\"])[2]")).click();
		 etest.info("Login started");
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"loginusername\"]")).sendKeys("mouna12");
	       driver.findElement(By.xpath("//input[@id=\"loginpassword\"]")).sendKeys("mouna12@123");
	       driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
	       Thread.sleep(3000);
	       etest.info("Login completed");
	       etest.info("placing order to cart");
	       driver.findElement(By.linkText("Laptops")).click();
	       Thread.sleep(3000);
       driver.findElement(By.xpath("(//img[@class=\"card-img-top img-fluid\"])[1]")).click();
       Thread.sleep(3000);
     driver.findElement(By.linkText("Add to cart")).click();
   Thread.sleep(3000); 
    Alert alert1 = driver.switchTo().alert();
     alert1.accept();
     etest.info("Adding customer details");
  driver.findElement(By.linkText("Cart")).click();
  driver.findElement(By.xpath("//button[text()=\"Place Order\"]")).click();
  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[5]")).sendKeys("Mouna");
  driver.findElement(By.xpath("//input[@id=\"country\"]")).sendKeys("India");
  driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Banglore");
  driver.findElement(By.xpath("//input[@id=\"card\"]")).sendKeys("5437809432");
  driver.findElement(By.xpath("//input[@id=\"month\"]")).sendKeys("jan");
  driver.findElement(By.xpath("//input[@id=\"year\"]")).sendKeys("2024");
  driver.findElement(By.xpath("//button[text()=\"Purchase\"]")).click();
  String name = driver.findElement(By.xpath("//h2[text()=\"Thank you for your purchase!\"]")).getText();
  System.out.println(name);
  Assert.assertEquals(name, "Thank you for your purchase!");   
  etest.info("Successfully placed an order");
driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();      
		etest.info("TEST RUNNED SUCCESSFULLY");
		System.out.println("Test executed successfully");
		System.out.println("program executed successfully");
	 }
		@AfterMethod
		public void end()
		{
			driver.quit();
			report.flush();
				}		
}

