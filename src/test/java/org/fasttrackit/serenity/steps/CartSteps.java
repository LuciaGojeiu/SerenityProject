package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.*;
import org.junit.Assert;

public class CartSteps {
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

  @Step
  public void searchForKeyword(String keyword) {
      shopPage.setSearchField(keyword);
  }
  @Step
   public void chooseFirstProduct(){
      searchPage.clickFirstProductLink();
  }
  @Step
    public void addToCartProduct(){
      productPage.clickAddToCartButton();
  }
  @Step
    public void checkProductinCart(){
      productPage.clickViewCartButton();
      Assert.assertTrue(cartPage.verifyProductSentToCart());
  }
  @Step
    public void checkTotalPrice(byte quantity){
      Assert.assertTrue(cartPage.verifyTotalPrice(quantity));
  }

}
