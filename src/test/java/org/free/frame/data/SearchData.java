/**
 * 
 */
package org.free.frame.data;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

/**
 * @author lizejun
 *
 */
public class SearchData {

	@DataProvider(name = "searchKey1")	
	public static Object[][] searchKeys() {
		return new Object[][]{		
				{"apple"},	
				{"苹果"}
			};
	}
	
	@DataProvider(name = "searchKey2")
    public Object[][] providerMethod(Method method){
        Object[][] result = null;
        if(method.getName().equals("testSearch1")){
            result = new Object[][]{new Object[]{"apple"}};
        }else if(method.getName().equals("testSearch2")){
            result = new Object[][]{new Object[]{"苹果"}};
        }
        return result;
    }
	
}
