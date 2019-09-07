package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/cart/")
public class CartPage extends PageObject {
    @FindBy(css=".checkout-button")
    private WebElementFacade proceedToCheckoutButton;
    @FindBy(css=".cart tbody tr:first-child")
    private WebElementFacade productInCart;
    @FindBy(css=".cart tbody tr:first-child .product-price>span")
    private WebElementFacade productPrice;
    @FindBy(css=".cart tbody tr:first-child .product-quantity input")
    private WebElementFacade productQuantity;
    @FindBy(css=".cart tbody tr:first-child .product-subtotal>span")
    private WebElementFacade productTotalPrice;
    private int productPriceInt;
    private int productTotalPriceInt;

    public boolean verifyProductSentToCart(){
      return proceedToCheckoutButton.isClickable();
    }
    public void clickProceedToCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }



     public int getProductPriceInt() {
         for (int i = 0; i < productPrice.getText().length(); i++) {
             if (productPrice.getText().charAt(i) == ',') {
                 productPriceInt = Integer.valueOf(productPrice.getText().substring(0, i - 1));
             }
         }
         return productPriceInt;
     }
    public int getProductTotalPriceInt() {
        for (int i = 0; i < productTotalPrice.getText().length(); i++) {
            if (productTotalPrice.getText().charAt(i) == ',') {
                productTotalPriceInt = Integer.valueOf(productTotalPrice.getText().substring(0, i - 1));
            }
        }
        return productTotalPriceInt;
    }

    public boolean verifyTotalPrice(byte quantity){
        if(productPriceInt*quantity==productTotalPriceInt) {
            return true;
        }
        else return false;
      }
}
