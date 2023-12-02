package pagePackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPacakge.WorkLib;

public class AmazonProductPage {
	
	@FindBy(xpath = "//span[@id='productTitle']/ancestor::div[@id='centerCol']/descendant::span[@class='a-price-whole']")
    private WebElement priceOfProduct;
	
	@FindBy(id="add-to-cart-button") private WebElement addToCartButton;

	public AmazonProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPriceOfProduct() {
		return priceOfProduct;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public String getPriceofProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		String price = priceOfProduct.getText();
		return price;
	}
	
	public void clickonAddtoCartButton() throws InterruptedException
	{
        Point loc = addToCartButton.getLocation();
		
		int xaxis = loc.getX();
		int yaxis = loc.getY();
		
		WorkLib wb = new WorkLib();
		wb.scrollTillParticulrWebElement(xaxis, yaxis);
		
		Thread.sleep(2000);
		
		addToCartButton.click();
	}
}
