/**
 * 
 */
package org.free.frame.testng;

import org.free.frame.TestBase;
import org.free.frame.demopage.BaiduMainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author lizejun
 *
 */
@Listeners({ScreenShotListener.class})
public class BaseTestWithListener extends TestBase {

	BaiduMainPage page = null;

	@BeforeMethod
	public void initPage() {
		String path = "http://www.baidu.com/";
		page = new BaiduMainPage(driver);
		page.openAndWait(path);
		PageFactory.initElements(driver, page);
	}
	
	@Test
	public void testSearch(){
		String text="apple";
		page.SearchText(text);
		sleep(1);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(text));
		System.out.println(page.getCurrentUrl());
	}
	
	@Test
	public void testnews(){
		System.out.println(page.getCurrentUrl());

		page.clickNewsIndex();
		page.sleep(1);
		System.out.println(page.getCurrentUrl());
		Assert.assertTrue(page.getCurrentUrl().contains("news1.baidu.com"));
	}

}
