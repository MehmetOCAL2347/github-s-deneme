package page.object.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageObject extends BasePageObject{

    private By sizeButtonLocator = By.xpath("//a[@size='8-9 Yaş']");
    private By addToCartButtonLocator = By.xpath("//a[@id='pd_add_to_cart']");
    private By chartButtonLocator = By.xpath("//span[contains(text(), 'Sepetim')]");

    public ProductDetailPageObject(WebDriver driver) {
        super(driver);
    }

    public void addToChart(){
        find(sizeButtonLocator).click();
        find(addToCartButtonLocator).click();
    }

    public ChartObjectPage goToChart(){
        find(chartButtonLocator).click();
        return new ChartObjectPage(driver);
    }

    public By getAddToCartButtonLocator() {
        return addToCartButtonLocator;
    }
}

