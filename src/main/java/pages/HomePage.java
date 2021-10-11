package pages;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private final String homePageURL = "https://www.asos.com";

    public final SelenideElement header = $(By.xpath("//div[@id='chrome-header']"));

    private final SelenideElement footer = $(By.xpath("//div[@id='chrome-footer']"));

    private final SelenideElement cartIcon = $(By.xpath("//span[@type='bagUnfilled']"));

    private final SelenideElement myAccountButton = $(By.xpath("//span[@type='accountUnfilled']"));

    private final SelenideElement signInButton = $(By.xpath("//a[@data-testid='signin-link']"));

    private final SelenideElement signUpButton = $(By.xpath("//a[@data-testid='signup-link']"));

    private final SelenideElement myAccountPopup = $(By.xpath("//div[@data-testid='myaccount-dropdown']"));

    private final SelenideElement menFloorButton = $(By.xpath("//a[@data-testid='men-floor']"));

    private final SelenideElement womenFloorButton = $(By.xpath("//a[@data-testid='women-floor']"));

    private final SelenideElement shoesButton = $(By.xpath("//button[contains(@data-id, '87a')]"));

    private final List<SelenideElement> bootsButton = $$(By.xpath("//a[text() = 'Boots']"));

    private final SelenideElement preferencesPopup = $(By.xpath("//div[@class='_1FSGXKY _2FR6csi']"));

    private final SelenideElement countrySelector = $(By.xpath("//select[@id='country']"));

    private final SelenideElement currencySelector = $(By.xpath("//select[@id='currency']"));

    private final SelenideElement savePreferencesButton = $(By.xpath("//button[@data-testid='save-country-button']"));

    private final SelenideElement searchField = $(By.xpath("//input[@data-testid='search-input']"));

    public final SelenideElement searchButton = $(By.xpath("//button[@data-testid='search-button-inline']"));

    private final SelenideElement wishListProductsCount = $(By.xpath("//div[contains(@class,'wishlist-button')]//div[contains(@class,'items-count')]"));

    private final SelenideElement savedItemsButton = $(By.xpath("//span[@type='heartUnfilled']"));

    private final SelenideElement countrySelectorButton = $(By.xpath("//div[@id='chrome-header']//button[@data-testid='country-selector-btn']"));

    public void openHomePage() {
        open(homePageURL);
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public boolean isMenFloorButtonVisible() {
        return menFloorButton.isDisplayed();
    }

    public void clickOnMenFloorButton() {
        menFloorButton.click();
    }

    public void clickShoesButton() {
        shoesButton.click();
    }

    public BootsPage clickBootsButton() {
        bootsButton.get(1).click();
        return page(BootsPage.class);
    }

    public SelenideElement getBootsButton() {
        return bootsButton.get(1);
    }

    public boolean isWomenFloorButtonVisible() {
        return womenFloorButton.isDisplayed();
    }

    public boolean isCountrySelectorVisible() {
        return countrySelector.isDisplayed();
    }

    public boolean isCurrencySelectorVisible() {
        return currencySelector.isDisplayed();
    }

    public boolean isSavePreferencesButtonVisible() {
        return savePreferencesButton.isDisplayed();
    }

    public void selectCountry(String country) {
        countrySelector.selectOptionByValue(country);
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }
    public void clickSignInButton() {
        signInButton.click();
    }

    public String getCountrySelectorButtonText() {
        return countrySelectorButton.getAttribute("aria-label");
    }

    public void isMyAccountButtonVisible() {
        myAccountButton.isDisplayed();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickSavePreferencesButton() {
        savePreferencesButton.click();
    }

    public SelenideElement getSavePreferencesButton() {
        return savePreferencesButton;
    }

    public SavedItemsPage clickSavedItemsButton() {
        savedItemsButton.click();
        return page(SavedItemsPage.class);
    }

    public boolean isSignUpButtonVisible() {
        return signUpButton.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isCountrySelectorButtonVisible() {
        return countrySelectorButton.isDisplayed();
    }

    public boolean isMyAccountPopupVisible() {
        return myAccountPopup.isDisplayed();
    }

    public SelenideElement getMyAccountPopup() {
        return myAccountPopup;
    }

    public SelenideElement getPreferencesPopup() {
        return preferencesPopup;
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickCountrySelectorButton() {
        countrySelectorButton.click();
    }


    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return page(SearchResultsPage.class);
    }

}
