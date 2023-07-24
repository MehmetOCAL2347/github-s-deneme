package page.object.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageObject extends BasePageObject{

    //data-optionid="3003296"
    //"//div[@class='product-card product-card--one-of-4']"
    private String productPageURL = "https://www.lcwaikiki.com/tr-TR/TR/kategori/erkek-cocuk/takim";
    private By detailOfProductLocator = By.xpath("//a[@title='Bisiklet Yaka Baskılı Kısa Kollu Erkek Çocuk Tişört ve Şort']");

    public ProductPageObject(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPageObject goToProductDetail(){
        find(detailOfProductLocator).click();
        return new ProductDetailPageObject(driver);
    }

    public String getProductPageURL() {
        return productPageURL;
    }
}
