package org.free.frame.simplestart;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleSafari {

	private static boolean isSupportedPlatform() {
	    Platform current = Platform.getCurrent();
	    return Platform.MAC.is(current) || Platform.WINDOWS.is(current);
	}
	
	public static void main(String[] args) {
		String path = "http://www.baidu.com/";
		
		if(!isSupportedPlatform()) 
			return;
		
		WebDriver driver = new SafariDriver();
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
