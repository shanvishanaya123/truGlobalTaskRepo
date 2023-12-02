package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
	
	@FindBy(id="twotabsearchtextbox") private WebElement searchBox;
	@FindBy(id="nav-search-submit-button") private WebElement searchIcon;
	
	
	public AmazonHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSearchBox() {
		return searchBox;
	}


	public WebElement getSearchIcon() {
		return searchIcon;
	}

	
	
	public void searchForProduct(String productName)
	{
		searchBox.sendKeys(productName);
		searchIcon.click();
	}
	
}
