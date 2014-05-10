/**
 * 
 */
package org.free.frame;

import java.util.concurrent.TimeUnit;

import org.free.frame.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * 测试的基类
 *
 */
public abstract class TestBase {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected WebDriver driver = null;
		
	/**
	 * 用于硬性的等待
	 * @param seconds
	 */
	public void sleep(int seconds) {
	    try {
	        TimeUnit.SECONDS.sleep(seconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}


	@BeforeClass(alwaysRun = true)
	public void setUpTestBase(ITestContext testContext) {
		try{
			driver = DriverFactory.getInstance().getDriver();
		 } catch(Exception e ) {
			 quitDriver();
			 Assert.fail("SetUp failed.", e);
		 }
	}
	

	@AfterClass
	public void quitDriver() {
		try{
			if(driver != null)
				driver.quit();
		}	finally {
			driver = null;
		}
	}
	
}
