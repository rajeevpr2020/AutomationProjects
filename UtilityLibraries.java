package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityLibraries  {
	static  WebDriver driver;
	public WebDriver browserlaunch(String browser,String url) {
		
		switch (browser) {
		case "Chrome":
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		break;
	     
		case "ie":
		System.setProperty("webdriver.ie.driver","E:\\selenium\\IEDriver\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	    driver.get(url);
		driver.manage().window().maximize();
		 break;
		  
		}
		return driver;
		}
	public void click(By property,int withtime,int polling) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(withtime,TimeUnit.SECONDS)
				.pollingEvery(polling, TimeUnit.SECONDS)
				.ignoring(Exception.class);
    			driver.findElement(property).click();
		
	//	WebElement element=driver.findElement(property);
	//	 if(element.isDisplayed()) {
	//		 element.click();
		 }
	 public void click(By property,int waittime) {
				
				WebDriverWait wait=new WebDriverWait(driver,waittime );
			    wait.until(ExpectedConditions.visibilityOfElementLocated(property));
			    driver.findElement(property).click(); 
			 //   WebElement element=driver.findElement(property);
			//	 if(element.isDisplayed()) {
			//	 element.click();
			//}
		
	}
	public void sendkeys(By inputvalue, CharSequence CharSequence) {
		driver.findElement(inputvalue).sendKeys(CharSequence);
	}
	 
	public void screenShot() throws IOException {
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		TakesScreenshot src=( (TakesScreenshot)driver);
		File files=src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(files,new File("E:\\"+fileName+".jpg"));
	}

}
