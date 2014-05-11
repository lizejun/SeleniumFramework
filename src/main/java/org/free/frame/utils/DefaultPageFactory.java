/**
 * 
 */
package org.free.frame.utils;

import java.lang.reflect.InvocationTargetException;

import org.free.frame.Page;
import org.openqa.selenium.WebDriver;

/**
 * @author lizejun
 *
 */
public class DefaultPageFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends Page> T createPage(Class<T> clazz,WebDriver driver) {
		Object obj = null;
		try {
			obj = clazz.getConstructor(clazz).newInstance(driver);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
	
}
