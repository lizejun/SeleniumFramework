/**
 * 
 */
package org.free.frame.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lizejun
 *
 */
public class DriverFactory {
	private static DriverType DEFAULT_DRIVER_TYPE = DriverType.Firefox;
	
    protected Logger logger = LoggerFactory.getLogger(getClass());

	public WebDriver getDriver() {
		DriverType type = DEFAULT_DRIVER_TYPE;
		try {
			type = Enum.valueOf(DriverType.class, ConfigurationSettings.WEBDRIVER_TYPE);
		}
		catch (Exception ex) {
			this.logger.warn("Parse WebDriver.Type failed, use default driver type: " + DEFAULT_DRIVER_TYPE.name());
			this.logger.debug(ex.getMessage(), ex);
		}
		return type.getDriver();
	}
}
