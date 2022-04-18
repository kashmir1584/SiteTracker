package com.sitetracker;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTest extends TestBase{
	
	AutomationTest() throws IOException{
		super();
	}
	
	@BeforeTest
	public void initiateBrowser() {
		launchBrowser();
	}
	
	@Test
	public void tableUpdateTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Component Reference']")).click();
		driver.findElement(By.id("input-64")).sendKeys("datatable");
		driver.findElement(By.xpath("//div[@class='slds-tree_container']//div[2]//componentreference-tree-item//div//span//span")).click();
		driver.findElement(By.id("combobox-button-386")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(), 'Data Table with Inline Edit')]")).click();
		driver.findElement(By.xpath("//lightning-button-group[@class='slds-button-group']//button")).click();
		Thread.sleep(40000);

		driver.switchTo().frame("preview");
		driver.switchTo().frame("preview");
		driver.findElement(By.xpath("//table//tbody//tr[3]//th//button//lightning-primitive-icon")).click();
		
		driver.findElement(By.id("input-1934")).clear();
		driver.findElement(By.id("input-1934")).sendKeys("Larry Page");
		
		driver.findElement(By.xpath("//table//tbody//tr[3]//td[3]//lightning-primitive-icon")).click();
		driver.findElement(By.id("input-1936")).clear();
		driver.findElement(By.id("input-1936")).sendKeys("https://google.com");
		
		driver.findElement(By.xpath("//table//tbody//tr[3]//td[4]//lightning-primitive-icon")).click();
		driver.findElement(By.id("input-1938")).clear();
		driver.findElement(By.id("input-1938")).sendKeys("(555)-755-6575");
				
		driver.findElement(By.xpath("//table//tbody//tr[3]//td[5]//lightning-primitive-icon")).click();
		driver.findElement(By.id("input-1942")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Today')]")).click();
		driver.findElement(By.xpath("//lightning-timepicker//div//div//div")).click();
		driver.findElement(By.xpath("//lightning-timepicker[@class='slds-form-element']//div//lightning-base-combobox//div//div//input")).clear();
		driver.findElement(By.xpath("//lightning-timepicker[@class='slds-form-element']//div//lightning-base-combobox//div//div//input")).sendKeys("12:57 PM");
		
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//table//tbody//tr[3]//td[6]//lightning-primitive-icon")).click();
		driver.findElement(By.xpath("//section[@class='slds-popover slds-popover_edit']//div//form//lightning-primitive-datatable-iedit-input-wrapper//slot//lightning-primitive-datatable-iedit-type-factory//lightning-input//div//input")).clear();
		driver.findElement(By.xpath("//section[@class='slds-popover slds-popover_edit']//div//form//lightning-primitive-datatable-iedit-input-wrapper//slot//lightning-primitive-datatable-iedit-type-factory//lightning-input//div//input")).sendKeys("770.54");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table//tbody//tr[4]//th//button//lightning-primitive-icon")).click();
		
		String name = driver.findElement(By.xpath("//table//tbody//tr[3]//th//lightning-primitive-cell-factory//span//div//lightning-base-formatted-text")).getText();
		System.out.println("name : "+name);
		Assert.assertEquals(name, "Larry Page");
		
		String url = driver.findElement(By.xpath("//table//tbody//tr[3]//td[3]//lightning-primitive-cell-factory//span//div//lightning-formatted-url//a")).getText();
		System.out.println("url : "+url);
		Assert.assertEquals(url, "https://google.com");
		
		String phoneNumber = driver.findElement(By.xpath("//table//tbody//tr[3]//td[4]//lightning-primitive-cell-factory//span//div//lightning-formatted-phone//a")).getText();
		System.out.println("phoneNumber : "+phoneNumber);
		Assert.assertEquals(phoneNumber, "(555)-755-6575");
		
		String balance = driver.findElement(By.xpath("//table//tbody//tr[3]//td[6]//lightning-primitive-cell-factory//span//div//lightning-formatted-number")).getText();
		System.out.println("balance : "+balance);
		Assert.assertEquals(balance, "$770.54");	
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
