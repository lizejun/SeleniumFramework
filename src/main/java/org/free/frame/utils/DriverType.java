/**
 * 
 */
package org.free.frame.utils;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author lizejun
 *
 */
public enum DriverType {
	InternetExplorer {
		/**
		 * 获取InternetExplorerDriver<br/>
		 * 在org.openqa.selenium.chrome.InternetExplorerDriverService中有一个更完整的实现。
		 */
		@Override
		public WebDriver getDriver() {
			//The path to the driver executable must be set 
			//by the webdriver.ie.driver system property
			if (!StringUtils.isEmpty(ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH)) {
				System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH);
			}
			//On IE 7 or higher on Windows Vista or Windows 7, 
			//you must set the Protected Mode settings for each zone to be the same value.
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			
			return new InternetExplorerDriver(ieCapabilities);
		}
	},
	Firefox {
		@Override
		public WebDriver getDriver() {
			return new FirefoxDriver();
		}
	},
	Chrome {
		@Override
		public WebDriver getDriver() {
			//The path to the driver executable must be set by 
			//the webdriver.chrome.driver system property
			if (!StringUtils.isEmpty(ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH)) {
				System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH);
			}
			return new ChromeDriver();
		}
	};
	public abstract WebDriver getDriver();
}
