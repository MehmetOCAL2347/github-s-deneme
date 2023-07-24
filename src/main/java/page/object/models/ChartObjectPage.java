package page.object.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChartObjectPage extends BasePageObject{

    private By priceLocator = By.xpath("//span[@class='rd-cart-item-price mb-15']");

    public ChartObjectPage(WebDriver driver) {
        super(driver);
    }

    public By getPriceLocator() {
        return priceLocator;
    }
}
