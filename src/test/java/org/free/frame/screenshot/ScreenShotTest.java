/**
 * 
 */
package org.free.frame.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 测试截屏
 *
 */
public class ScreenShotTest {
	
	public static void main(String[] args) throws IOException {
		
		String path = "http://www.baidu.com/";
		WebDriver driver = new FirefoxDriver();
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
		
		//添加截屏代码
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("test.png"));

		driver.quit();
	}
}
