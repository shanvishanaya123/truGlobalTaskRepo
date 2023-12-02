package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductListPage {

	
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]") private WebElement firstIphoneofList;
	
	public AmazonProductListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getFirstIphoneofList() {
		return firstIphoneofList;
	}
	
	public void selectTheIphone()
	{
		firstIphoneofList.click();
	}
}
