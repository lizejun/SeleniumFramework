package org.free.frame.demopage;

import org.free.frame.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduMainPage extends Page{

	public BaiduMainPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 输入文本input
	 */
	@FindBy(id="kw1")
	WebElement inputbox;
	
	/**
	 * 查询按钮
	 */
	@FindBy(id="su1")
	WebElement submitbox;
	
	/**
	 * 新闻链接
	 */
	@FindBy(name="tj_news")
	WebElement newsIndex;
	
	/**
	 * 输入待搜素文本
	 * @param text
	 */
	public void SearchText(String text) {
		inputbox.sendKeys(text);
		submitbox.click();
	}
	
	public void clickNewsIndex() {
		newsIndex.click();
	}
}
