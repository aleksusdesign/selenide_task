package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductPage extends BasePage {

    public final SelenideElement addToCartButton = $(By.xpath("//button[@data-test-id='add-button']"));

    private final SelenideElement addToCartPopupHeader = $(By.xpath("//div[@class='_2XTT510 jVCq0Wv liqWkbK']"));

    private final SelenideElement continueShoppingButton = $(By.xpath("//a[contains(text(),'Continue shopping')]"));

    private final SelenideElement continueToCartButton = $(By.xpath("//a[contains(text(),'Continue to cart')]"));

    public final SelenideElement titleOfProduct = $(By.xpath("//div[@class='product-hero']//h1"));

    public final SelenideElement priceOfProduct = $(By.xpath("//span[@data-id='current-price']"));

    public final SelenideElement starRatingButton = $(By.xpath("//button[@class='star-rating-button']"));

    public final SelenideElement cartButton = $(By.xpath("//button[@data-testid='miniBagIcon']"));

    public final SelenideElement showCartButton = $(By.xpath("//a[@data-test-id='bag-link']"));

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public ShoppingCartPage clickShowCartButton() {
        showCartButton.click();
        return page(ShoppingCartPage.class);
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isDisplayed();
    }

    public boolean isStarRatingButtonVisible() {
        return starRatingButton.isDisplayed();
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopupHeader.isDisplayed();
    }

    public boolean isTitleOfProductVisible() {
        return titleOfProduct.isDisplayed();
    }

    public void isContinueShoppingButtonVisible() {
        continueShoppingButton.isDisplayed();
    }

    public boolean isPriceOfProductVisible() {
       return priceOfProduct.isDisplayed();
    }

    public String getAddToCartPopupHeaderText() {
        return addToCartPopupHeader.getText();
    }

    public void isContinueToCartButtonVisible() {
        continueToCartButton.isDisplayed();
    }

    public void clickContinueToCartButton() {
        continueToCartButton.click();
    }

    public WebElement getAddToCartPopupHeader() {
        return addToCartPopupHeader;
    }
}
