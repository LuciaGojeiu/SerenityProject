package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.HomePage;
import org.fasttrackit.serenity.pages.SearchPage;
import org.fasttrackit.serenity.pages.ShopPage;
import org.junit.Assert;

public class SearchSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private SearchPage searchPage;

    @Step
    public void navigateToShopPage(){
        homePage.open();
        homePage.clickShopLink();
    }
    @Step
    public void searchForKeyword(String keyword){
        shopPage.setSearchField(keyword);
    }
    @Step
    public void checkSearchResultMessage(String keyword){
        searchPage.verifySearchResultsMessage(keyword);
    }
    @Step
    public void checkNothingFoundSearchResultMessage(){
        Assert.assertTrue(searchPage.verifyNothingFoundSearchResultMessage());
    }
}