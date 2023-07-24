package com.selenium.lcw;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.object.models.*;

import java.util.concurrent.TimeUnit;

public class ProductToChartTest {

    private HomePageObject homePage;
    private CategoryPageObject categoryPage;
    private ProductPageObject productPage;
    private ProductDetailPageObject productDetailPage;
    private ChartObjectPage chartPage;

    private WebDriver chromeDriver;
    private SoftAssert softAssert;

    @BeforeTest
    public void startUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        softAssert = new SoftAssert();

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1600, 900));
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homePage = new HomePageObject(chromeDriver);

    }

    @Test
    public void productToChartTest(){

        homePage.openHomePage();
        softAssert.assertEquals(chromeDriver.getCurrentUrl(), homePage.getHomePageUrl());

        categoryPage = homePage.goToCategoryPage();
        softAssert.assertEquals(chromeDriver.getCurrentUrl(), categoryPage.getCategoryUrl());

        productPage = categoryPage.goToProductPage();
        softAssert.assertEquals(chromeDriver.getCurrentUrl(), productPage.getProductPageURL());

        productDetailPage = productPage.goToProductDetail();
        softAssert.assertTrue(productDetailPage.isDisplayed(productDetailPage.getAddToCartButtonLocator()));

        productDetailPage.addToChart();
        softAssert.assertEquals(productDetailPage.getText(productDetailPage.getAddToCartButtonLocator(), "SEPETE EKLENDİ", 30), "SEPETE EKLENDİ");

        chartPage = productDetailPage.goToChart();
        softAssert.assertEquals(productDetailPage.getText(chartPage.getPriceLocator(), "143,99 TL", 30), "143,99 TL");

        homePage.openHomePage();
        softAssert.assertEquals(chromeDriver.getCurrentUrl(), homePage.getHomePageUrl());

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        chromeDriver.quit();
    }

}
