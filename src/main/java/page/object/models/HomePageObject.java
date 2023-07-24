package page.object.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePageObject{

    private String homePageUrl = "https://www.lcwaikiki.com/tr-TR/TR";
    private By categoryLocator = By.xpath("//a[contains(text(), 'Çocuk')]");

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(){
        openUrl(homePageUrl);
    }

    public CategoryPageObject goToCategoryPage(){
        find(categoryLocator).click();
        return new CategoryPageObject(driver);
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }
}
