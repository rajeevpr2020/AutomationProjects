package testNGpackage;

import org.testng.annotations.Test;

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

public class ClientTestCase {
	static WebDriver driver;
	UtilityLibraries obj=new UtilityLibraries();
	Readexcel ob12=new Readexcel();
	
@BeforeTest
	  public void beforeTest() throws IOException {
		  String urldata=ob12.readExcel(1, 4);
		  driver=obj.browserlaunch("Chrome",urldata);
	  }
 @Test(priority=1)
  public void clientCreationTc01() throws IOException   {

		String usrnm=ob12.readExcel(1, 6);
		String pswd=ob12.readExcel(1, 7);
		
		By usernameid=By.id("loginform-username");
		By loginpaswd=By.id("loginform-password");
		By submt=By.xpath("//*[@id=\"login-form\"]/div[5]/button");	
		By clientbutton=By.xpath("//*[@id=\"w1\"]/li[3]/a");
		By createclient=By.xpath("/html/body/section/div/div/div[1]/ul/li[2]/a");
		
		obj.sendkeys(usernameid, usrnm);
		obj.sendkeys(loginpaswd, pswd);
		
		obj.click(submt, 2);
		obj.click(clientbutton, 2);
		obj.click(createclient, 2);
		WebElement validatinh=driver.findElement(By.xpath("//*[@id=\"client-branch_id\"]"));
		if (validatinh.isDisplayed()) {
			System.out.println("Test Pass");
		}
 }
@Test(priority=2)
public void clientCreationTc02() throws IOException	{
	WebElement branch= driver.findElement(By.xpath("//*[@id=\"client-branch_id\"]"));
	Select dropselection= new Select(branch);
	dropselection.selectByVisibleText("4234");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-branch_id\"]")));
	WebElement branchoptn=select.getFirstSelectedOption();
	String text01=branchoptn.getText();
	String optn="4234";
	if(text01.equals(optn)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
}
@Test(priority=3)
public void clientCreationTc03() throws IOException{
	WebElement division= driver.findElement(By.xpath("//*[@id=\"client-division_id\"]"));
	Select dropselection= new Select(division);
	dropselection.selectByVisibleText("weq");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-division_id\"]")));
	WebElement divisionoptn=select.getFirstSelectedOption();
	String text02=divisionoptn.getText();
	String divoptn="weq";
	if(text02.equals(divoptn)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
	
}
	
@Test(priority=4)
public void clientCreationTc04() throws IOException{
	By clientname=By.xpath("//*[@id=\"client-client_name\"]");
	obj.sendkeys(clientname, "rajeev");
	By clientAdres=By.xpath("//*[@id=\"client-client_address\"]");
	obj.sendkeys(clientAdres, "ragalayam, kaipuzha, kulanada ");
	By postCode=By.xpath("//*[@id=\"client-postcode\"]");
	obj.sendkeys(postCode, "689503");
	driver.findElement(By.xpath("//*[@id=\"client-country\"]")).clear();
	By country=By.xpath("//*[@id=\"client-country\"]");
	obj.sendkeys(country, "india");
	By refernc=By.xpath("//*[@id=\"client-your_ref\"]");
	obj.sendkeys(refernc, "sarath");
	By invoic=By.xpath("//*[@id=\"client-invoice_contact\"]");
	obj.sendkeys(invoic, "sarath123");
	By phone=By.xpath("//*[@id=\"client-phone\"]");
	obj.sendkeys(phone, "9496262274");
	By email=By.xpath("//*[@id=\"client-email\"]");
	obj.sendkeys(email, "rajeeevvvv@gmail.com");
	By compnyReg=By.xpath("//*[@id=\"client-company_reg\"]");
	obj.sendkeys(compnyReg, "808563");
	
}
@Test(priority=5)
public void clientCreationTc05() throws IOException{
	WebElement invoice= driver.findElement(By.xpath("//*[@id=\"client-invoice_order\"]"));
	Select dropselection= new Select(invoice);
	dropselection.selectByVisibleText("Invoice per week");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-invoice_order\"]")));
	WebElement invoiceOptn=select.getFirstSelectedOption();
	String text03=invoiceOptn.getText();
	String invoicOrdr="Invoice per week";
	if(text03.equals(invoicOrdr)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
	
} 
@Test(priority=6)
public void clientCreationTc06() throws IOException{
	WebElement invoiceDelivr= driver.findElement(By.xpath("//*[@id=\"client-invoice_delivery_method\"]"));
	Select dropselection= new Select(invoiceDelivr);
	dropselection.selectByVisibleText("Paper");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-invoice_delivery_method\"]")));
	WebElement invoiceDelvrOptn=select.getFirstSelectedOption();
	String text04=invoiceDelvrOptn.getText();
	String invoicDelvrtext="Paper";
	if(text04.equals(invoicDelvrtext)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
	
} 
@Test(priority=7)
public void clientCreationTc07() throws IOException{
	WebElement mastrDoc= driver.findElement(By.xpath("//*[@id=\"client-master_document\"]"));
	Select dropselection= new Select(mastrDoc);
	dropselection.selectByVisibleText("PDF");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-master_document\"]")));
	WebElement mastrDocOpt=select.getFirstSelectedOption();
	String text05=mastrDocOpt.getText();
	String mastrDelvrtext="PDF";
	if(text05.equals(mastrDelvrtext)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
	
}
@Test(priority=8)
public void clientCreationTc08() throws IOException{
	By settlmnt=By.xpath("//*[@id=\"client-settilement_days\"]");
	obj.sendkeys(settlmnt, "20");
}
@Test(priority=9)
public void clientCreationTc09() throws IOException{
	WebElement vate= driver.findElement(By.xpath("//*[@id=\"client-vat_rate\"]"));
	Select dropselection= new Select(vate);
	dropselection.selectByVisibleText("VAT 5.00%");
	Select select=new Select(driver.findElement(By.xpath("//*[@id=\"client-vat_rate\"]")));
	WebElement vateRate=select.getFirstSelectedOption();
	String text06=vateRate.getText();
	String vateRatetext="VAT 5.00%";
	if(text06.equals(vateRatetext)) {
		System.out.println("test pass");
	}
	else {
		System.out.println("test fail");
	}
	obj.screenShot();
	
	
}
@Test(priority=10)
public void clientCreationTc10() throws IOException{
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.scrollBy(0,600)");
	By save=By.xpath("//*[@id=\"w0\"]/div[4]/div/button");
	obj.click(save, 2);
	obj.screenShot();
}
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
