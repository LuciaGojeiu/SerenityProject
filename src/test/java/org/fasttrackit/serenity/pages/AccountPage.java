package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/my-account/")
public class AccountPage extends PageObject {
   @FindBy(css=".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloText;

   public void verifyLoggedIn(String username){
       helloText.shouldContainText("Hello "+ username);
   }
}
