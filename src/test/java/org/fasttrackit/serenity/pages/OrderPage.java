package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/checkout/order-received/")
public class OrderPage extends PageObject {
    @FindBy(css = ".entry-title")
    private WebElementFacade orderReceivedMessage;

    public void checkOrderReceived(){
        waitABit(5000);
        orderReceivedMessage.shouldContainOnlyText("Order received");
    }


}


