package testNGpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Readexcel;
import utility.UtilityLibraries;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class clientPage {
	static WebDriver driver;
	UtilityLibraries obj=new UtilityLibraries();
	Readexcel ob12=new Readexcel();
@BeforeTest
public void beforeTest() throws IOException {
		  String urldata=ob12.readExcel(1, 4);
		  driver=obj.browserlaunch("Chrome",urldata);
	  }
  @Test (priority = 1)
  public void enterValue() throws IOException {
	  String usrnm=ob12.readExcel(1, 6);
		String pswd=ob12.readExcel(1, 7);
		
		By usernameid=By.id("loginform-username");
		By loginpaswd=By.id("loginform-password");
		By submt=By.xpath("//*[@id=\"login-form\"]/div[5]/button");	
		By clientbutton=By.xpath("//*[@id=\"w1\"]/li[3]/a");
		obj.sendkeys(usernameid, usrnm);
		obj.sendkeys(loginpaswd, pswd);
		
		obj.click(submt, 2);
		obj.click(clientbutton, 2);
		By clientpage=By.xpath("/html/body/section/div/div/div[1]/ul/li[1]/a");
		obj.click(clientpage, 2);
  }
@Test (priority = 2)
public void update() {
	By update=By.xpath("//*[@id=\"w1\"]/table/tbody/tr[1]/td[6]/a[2]/span");
  	obj.click(update, 5);
  	WebElement branch= driver.findElement(By.xpath("//*[@id=\"client-branch_id\"]"));
	Select dropselection= new Select(branch);
	dropselection.selectByVisibleText("4234");
	WebElement division= driver.findElement(By.xpath("//*[@id=\"client-division_id\"]"));
	Select dropselection1= new Select(division);
	dropselection1.selectByVisibleText("weq");
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.scrollBy(0,600)");
  	By save=By.xpath("//*[@id=\"w0\"]/div[4]/div/button");//*[@id="w0"]/div[4]/div/button
  	obj.click(save, 5);
  	
	
}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
