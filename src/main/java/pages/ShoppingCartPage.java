package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage extends pages.BasePage {

    public SelenideElement checkoutButton = $(By.xpath("//div[@class='bag-secondary-content-wrapper']//p[@class ='bag-total-button-holder']//a"));

    public SelenideElement shoppingCartItem = $(By.xpath("//li[@class='bag-item-holder']"));


    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public WebElement getShoppingCartItem() {
        return shoppingCartItem;
    }

}
