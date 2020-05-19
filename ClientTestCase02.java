package testNGpackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Readexcel;
import utility.UtilityLibraries;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class ClientTestCase02 {
	static WebDriver driver;
	UtilityLibraries obj=new UtilityLibraries();
	Readexcel ob12=new Readexcel();
@BeforeTest
	  public void beforeTest() throws IOException {
		  String urldata=ob12.readExcel(1, 4);
		  driver=obj.browserlaunch("Chrome",urldata);
	  }
  @Test(priority=1)
  public void clientPage01() throws IOException {
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
  @Test(priority=2)
  public void clientPage02() throws IOException{
  	By searchname=By.xpath("//*[@id=\"clientsearch-client_name\"]");
  	obj.sendkeys(searchname, "Appolo Nursing Home");
  	By searchButton=By.xpath("//*[@id=\"w0\"]/div[3]/button[1]");
  	obj.click(searchButton, 5);
  	obj.screenShot();
  	WebElement message01=driver.findElement(By.xpath("//*[@id=\"w1\"]/table/tbody/tr/td[2]"));
	String text=message01.getText();
	SoftAssert objectassert = new SoftAssert();	
	objectassert.assertEquals("Appolo Nursing Home",text,"test pass");
	objectassert.assertAll();
	
  } 
  @Test(priority = 3)
  public void view() throws IOException {
	  By view=By.xpath("//*[@id=\"w1\"]/table/tbody/tr/td[6]/a[1]/span");
	  obj.click(view, 5);
	  obj.screenShot();
  }
 
  @AfterTest 
  public void afterTest() {
	 driver.quit();
  }

}
