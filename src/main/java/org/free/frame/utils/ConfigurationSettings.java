/**
 * 
 */
package org.free.frame.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author lizejun
 *
 */
public class ConfigurationSettings {
	
		private static Properties props = null;
		
		private final static String SELENIUM_CONFIG="selenium-vars.properties";
		
		static{
			try {
				props = new Properties();
				InputStream in = ConfigurationSettings.class.getClassLoader().getResourceAsStream(SELENIUM_CONFIG);
				props.load(in);
			} catch (Exception e) {
				throw new RuntimeException("ConfigurationSettings initialize failed.", e);
			}
		}
		
		public static String getProperty(String propertyName){
			return props.getProperty(propertyName);
		}
		
		/**
		 * WebDriver类型
		 */
		public static final String WEBDRIVER_TYPE = getProperty("webdriver.type").trim();

		/**
		 * IEdriver的路径
		 */
		public static final String WEBDRIVER_IE_DRIVER_PATH = getProperty("webdriver.ie.driver.path").trim();
		
		/**
		 * Chromedriver的路径
		 */
		public static final String WEBDRIVER_CHROME_DRIVER_PATH  = getProperty("webdriver.chrome.driver.path").trim();

}
