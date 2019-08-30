package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.*;

public class CartSteps {
    private HomePage homePage;
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

  @Step
  public void navigateToShopPage(){
      homePage.open();
      homePage.clickShopLink();
  }
  @Step
  public void searchForKeyword(String keyword) {
      shopPage.setSearchField(keyword);
  }
  @Step
   public void chooseFirstBeanieProduct(){
      searchPage.clickFirstBeanieProductLink();
  }
  @Step
    public void addToCartBeanieProduct(){
      productPage.clickAddToCartButton();
  }
  @Step
    public void checkBeanieProductinCart(){
      productPage.clickViewCartButton();
      cartPage.verifyBeanieProductInCart();
  }
}
