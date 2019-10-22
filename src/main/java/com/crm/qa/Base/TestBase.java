package com.crm.qa.Base;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.crm.qa.util.TestUtil;
import com.google.common.io.Files;

public class TestBase {

public static WebDriver driver;

public static Properties p;

static String  browserName;


public static void ScreenShots() {
	
	
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File scrfile=ts.getScreenshotAs(OutputType.FILE);
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	File destfile=new File("E:\\JAVA_WS4\\FreeCRMTest\\CrmScreenShots"+sdf.format(d)+".png");
	try{
	Files.copy(scrfile, destfile);
	}
	catch(IOException e) {
		System.out.println(e);
	}
}


public static String getvalue(String key) throws IOException {
String value= null;
	File file=new File("E:\\JAVA_WS4\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	FileInputStream fis=new FileInputStream(file);
	Properties p=new Properties();
	p.load(fis);
	value = p.getProperty(key);
	

	return value;
	
}


public static void LaunchBrowser() throws IOException {
	
	browserName=getvalue("browser");
		
	if(browserName.equals("Chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver=new ChromeDriver();
		Reporter.log("Chrome is launched", true);
	}
	
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		driver=new ChromeDriver();
		Reporter.log("FireFox is launched", true);
	}
	
	driver.manage().window().maximize();
	
	//driver.manage().deleteAllCookies();
   // driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(TestUtil.Implict_Wait, TimeUnit.SECONDS);
	
	
	System.out.println("window maximize");
	
	System.out.println(getvalue("url"));
	
	driver.get(getvalue("url"));
	
	//driver.get("https://classic.crmpro.com/index.html?e=1");
	
	System.out.println("TestBase Class executed");
	
}

}
