package org.free.frame.demotest;

import java.util.concurrent.TimeUnit;

import org.free.frame.demopage.BaiduMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaiduMainPageTest{

	protected WebDriver driver = null;
	
	protected BaiduMainPage page = null;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
	}
	
	@BeforeMethod
	public void initPage() {
		String path = "http://www.baidu.com/";
		driver.get(path);
		sleep(1);
		page = new BaiduMainPage(driver);
		sleep(1);
		PageFactory.initElements(driver, page);
	}
	
	@Test(invocationCount=10)
	public void testSearch(){
		String text="apple";
		page.SearchText(text);
		sleep(2);
		System.out.println(driver.getTitle());

//		Assert.assertTrue(driver.getTitle().contains(text));
		System.out.println(page.getCurrentUrl());
	}
	
	@Test
	public void testnews(){
		System.out.println(page.getCurrentUrl());

		page.clickNewsIndex();
		System.out.println(page.getCurrentUrl());
		Assert.assertTrue(page.getCurrentUrl().contains("news.baidu.com"));
	}


	@AfterClass
	public void quit() {
		driver.quit();
	}
	
	public void sleep(int seconds) {
	    try {
	        TimeUnit.SECONDS.sleep(seconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}