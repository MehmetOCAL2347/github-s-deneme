package page.object.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPageObject extends BasePageObject{

    private String categoryUrl = "https://www.lcwaikiki.com/tr-TR/TR/lp/32-33-cocuk";
    private By productLocator = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/kategori/erkek-cocuk/takim']");

    public CategoryPageObject(WebDriver driver) {
        super(driver);
    }

    public ProductPageObject goToProductPage(){
        find(productLocator).click();
        return new ProductPageObject(driver);
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }
}
