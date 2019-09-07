package org.fasttrackit.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.CartSteps;
import org.fasttrackit.serenity.steps.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private ShopSteps shopSteps;
    @Steps
    private CartSteps cartSteps;


    private String keyword="beanie";
    private byte quantity=5;

    @Test
    public void addToCartProductTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.checkProductinCart();
    }
    @Test
    public void verifyTotalPriceCalculation(){
        shopSteps.navigateToShopPage();
        shopSteps.sortShopProductsByDate();
        shopSteps.addProductToCart();
        shopSteps.navigateToCartPage();
        cartSteps.checkTotalPrice(quantity);

    }
}
