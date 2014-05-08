package org.free.frame.simplestart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleChrome {

	public static void main(String[] args) {
		//The path to the driver executable must be set by 
		//the webdriver.chrome.driver system property
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");

		String path = "http://www.baidu.com/";
		WebDriver driver = new ChromeDriver();
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
