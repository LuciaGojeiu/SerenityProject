package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/product/")
public class ProductPage extends PageObject {
    @FindBy(css=".product_title.entry-title")
    private WebElementFacade beanieProductTitle;
    @FindBy(css=".single_add_to_cart_button.button.alt")
    private WebElementFacade addToCartButton;
    @FindBy(css=".button.wc-forward")
    private WebElementFacade viewCartButton;

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }
    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }



}
