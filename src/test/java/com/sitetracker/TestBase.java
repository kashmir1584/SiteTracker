package com.sitetracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public WebDriver driver;
    public Properties prop;

    public TestBase() throws IOException{
        prop = new Properties();
        File file = new File("src//main//resources//config.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
    }
    
    public void launchBrowser() {
    	String browserName = prop.getProperty("browser");
    	if(browserName.equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", "src//main//resources//geckodriver.exe");
   //         System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
    		driver = new FirefoxDriver();
    //        driver = new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		driver.get(prop.getProperty("url"));
    	}
    }
}
