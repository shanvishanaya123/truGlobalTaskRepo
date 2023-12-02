package testPackage;

import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericPacakge.BaseTest;
import pagePackage.AmazonHomePage;
import pagePackage.AmazonProductListPage;
import pagePackage.AmazonProductPage;

public class AmazonTestRunner extends BaseTest {
	
	@Test(description = "end to end flow of Iphone Product")
	public void endToEndFlowOfProductSearch() throws InterruptedException
	{
		
		String productName="iphone";
		AmazonHomePage ahp = new AmazonHomePage(driver);
		ahp.searchForProduct(productName);
		
		Assert.assertEquals(driver.getTitle(),"Amazon.in : iphone");
		

		// get the address of list iphone window page
		String parentHandle = driver.getWindowHandle();
		
		
		AmazonProductListPage amazonProductList = new AmazonProductListPage(driver);
		
		amazonProductList.getFirstIphoneofList();
		
		amazonProductList.selectTheIphone();
		
		//get the address of all the Windows 
		Set<String> allHandles = driver.getWindowHandles();
		
		//switch the controls from list window to product window
		for(String wh:allHandles)
		{
			if(!parentHandle.equals(wh))
			{
				driver.switchTo().window(wh);
			}
			
		}
	
		
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Reporter.log("We are on product Page : "+driver.getTitle(),true);
		
		AmazonProductPage productPage = new AmazonProductPage(driver);
		
		    
		Reporter.log("price of product: "+productPage.getPriceofProduct(),true);
		
		productPage.clickonAddtoCartButton();
		
	}

}
