package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/my-account/")
public class AccountPage extends PageObject {
   @FindBy(css=".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloText;
   @FindBy(css=".woocommerce-MyAccount-navigation li a[href*='logout']")
    private WebElementFacade logoutLink;
   @FindBy(css="li a[href*='orders']")
    private WebElementFacade ordersLink;

   public void verifyLoggedIn(String username){
       helloText.shouldContainText("Hello "+ username);
   }
   public void clickLogoutLink(){
       clickOn(logoutLink);
   }
   public void clickOrdersLink(){
       clickOn(ordersLink);
    }

}
