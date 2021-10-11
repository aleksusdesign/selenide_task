import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Waiter;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ProductPage;
import pages.SavedItemsPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;

import static com.codeborne.selenide.Condition.appear;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({ScreenShooterExtension.class})
public class SmokeTests extends BaseTest {

    private static final String EXPECTED_AMOUNT_OF_PRODUCTS = "1";

    @Test
    @DisplayName("Check add product to wishlist")
    public void checkAddProductToWishList() {
        homePage.openHomePage();
        homePage.searchButton.shouldBe(appear);
        homePage.enterTextToSearchField("shorts");
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        searchResultsPage.wishListIcon.first().shouldBe(appear);
        searchResultsPage.clickWishListOnFirstProduct();
        homePage.header.scrollTo();
        SavedItemsPage savedItemsPage = homePage.clickSavedItemsButton();
        savedItemsPage.countOfSavedItems.shouldBe(appear);
        assertEquals(savedItemsPage.getCountOfSavedItems(), EXPECTED_AMOUNT_OF_PRODUCTS);
    }

    @Test
    @DisplayName("Check add product to cart")
    public void checkAddProductToCart() {
        homePage.openHomePage();
        homePage.searchButton.shouldBe(appear);
        homePage.enterTextToSearchField("Bagpack");
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        ProductPage productPage = searchResultsPage.clickOnFirstProduct();
        productPage.titleOfProduct.shouldBe(appear);
        Assertions.assertTrue(productPage.priceOfProduct.isDisplayed());
        assertTrue(productPage.addToCartButton.isDisplayed());
        productPage.clickAddToCartButton();
        productPage.cartButton.scrollTo();
        productPage.showCartButton.shouldBe(appear);

        ShoppingCartPage shoppingCartPage = productPage.clickShowCartButton();
        shoppingCartPage.shoppingCartItem.shouldBe(appear);
        assertTrue(shoppingCartPage.checkoutButton.isDisplayed());
        shoppingCartPage.clickCheckoutButton();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("signin"));
        ;
    }

}
