package org.fasttrackit.serenity.features;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.CartSteps;
import org.fasttrackit.serenity.steps.CheckoutSteps;
import org.fasttrackit.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
    @Steps
    private CartSteps cartSteps;
    @Steps
    private CheckoutSteps checkoutSteps;

    private String keyword="hoodie";

    @Test
    public void placeAnOrderTest(){
        cartSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.checkProductinCart();
        checkoutSteps.placeOrderProduct(Constants.FIRST_NAME, Constants.LAST_NAME,Constants.COUNTRY,
                Constants.STREET_ADDRESS, Constants.TOWN, Constants.COUNTY, Constants.POSTCODE,
                Constants.PHONE, Constants.USER_EMAIL);

        checkoutSteps.verifyProductInOrder();
    }

}
