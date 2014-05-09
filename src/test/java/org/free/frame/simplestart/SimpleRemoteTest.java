/**
 * 
 */
package org.free.frame.simplestart;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author lizejun
 *
 */
public class SimpleRemoteTest {
	
	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		URL url = new URL("http://172:4444/wd/hub");

		// Get a handle to the driver. This will throw an exception
		// if a matching driver cannot be located
		WebDriver driver = new RemoteWebDriver(url,capabilities);
		
		String path = "http://www.baidu.com/";
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
