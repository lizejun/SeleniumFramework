package org.free.frame.simplestart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleIe {

	
	public static void main(String[] args) {
		
		//java.lang.IllegalStateException: 
		//The path to the driver executable must be set 
		//by the webdriver.ie.driver system property
		System.setProperty("webdriver.ie.driver","lib\\IEDriverServer.exe");
		
		//On IE 7 or higher on Windows Vista or Windows 7, 
		//you must set the Protected Mode settings for each zone to be the same value.
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		
		String path = "http://www.baidu.com/";
		WebDriver driver = new InternetExplorerDriver(ieCapabilities);

		driver.get(path);
		
		WebElement inputbox = driver.findElement(By.id("kw1"));
		WebElement submitbox = driver.findElement(By.id("su1"));
		
		inputbox.sendKeys("selenium");
		submitbox.click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().contains("selenium");
            }
        });
		
		driver.quit();

	}

}
