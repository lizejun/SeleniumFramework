/**
 * 
 */
package org.free.frame.demotest;

import org.free.frame.TestBase;
import org.free.frame.data.SearchData;
import org.free.frame.demopage.BaiduMainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author lizejun
 *
 */
public class BaiduMainTestUsingDataProvider extends TestBase {

	BaiduMainPage page = null;

	@BeforeMethod
	public void initPage() {
		String path = "http://www.baidu.com/";
		page = new BaiduMainPage(driver);
		page.openAndWait(path);
		PageFactory.initElements(driver, page);
	}
	
	@Test(dataProvider = "searchKey1", dataProviderClass = SearchData.class)
	public void testSearch(String text){
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
		Assert.assertTrue(page.getCurrentUrl().contains("news.baidu.com"));
	}

}
