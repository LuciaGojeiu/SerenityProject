package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/cart/")
public class CartPage extends PageObject {
    @FindBy(css="td.product-name")
    private WebElementFacade beanieProductName;

    public void verifyBeanieProductInCart(){
      beanieProductName.shouldContainText("Beanie with Logo");
    }
}
