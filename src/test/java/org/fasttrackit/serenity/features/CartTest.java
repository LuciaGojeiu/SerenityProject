package org.fasttrackit.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.CartSteps;
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
    private CartSteps cartSteps;

    @Test
    public void addToCartBeanieProductTest(){
        cartSteps.navigateToShopPage();
        cartSteps.searchForKeyword("beanie");
        cartSteps.chooseFirstBeanieProduct();
        cartSteps.addToCartBeanieProduct();
        cartSteps.checkBeanieProductinCart();
    }
}
