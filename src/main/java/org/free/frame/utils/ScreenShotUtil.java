package org.free.frame.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	public static void ScreenShoter(WebDriver driver,String filePathName) {
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filePathName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
