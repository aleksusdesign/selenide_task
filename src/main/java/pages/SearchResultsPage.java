package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage extends BasePage {

    public final ElementsCollection wishListIcon = $$(By.xpath("//button[@data-auto-id='saveForLater']"));

    public final ElementsCollection articleWithZeroResultSearchList = $$(By.xpath("//article[@class = 'feature']"));

    public final ElementsCollection descriptionsList = $$(By.xpath("//div[@data-auto-id='productTileDescription']//p"));

    public final ElementsCollection productsList = $$(By.xpath("//a[@class='_3TqU78D']"));

    public final SelenideElement searchWithZeroResultTitle = $(By.xpath("//section[contains(@class, 'backgroundWrapper')]//h2[@class='grid-text__title ']"));;

    public final SelenideElement loadMoreButton = $(By.xpath("//a[@data-auto-id='loadMoreProducts']"));

    public final SelenideElement loadPreviousButton = $(By.xpath("//a[@data-auto-id='loadPreviousProducts']"));

    public final SelenideElement filtersRegion = $(By.xpath("//div[@aria-label = 'Filters']"));

    public final SelenideElement shopNewInSection = $(By.xpath("//section[contains(@class, 'mu-section')]"));

    public final SelenideElement stylesCountLabel = $(By.xpath("//p[@data-auto-id='styleCount']"));;

    public void clickWishListOnFirstProduct() {
        wishListIcon.first().click();
    }

    public ProductPage clickOnFirstProduct() {
        productsList.first().click();
        return page(ProductPage.class);
    }

    public String getSearchWithZeroResultTitle() {
        return searchWithZeroResultTitle.getText();
    }

    public boolean isFiltersRegionVisible() {
        try {
            return filtersRegion.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public boolean isShopNewInSectionVisible() {
        return shopNewInSection.isDisplayed();
    }

    public int getSizeOfArticleWithZeroResultSearchList() {
        return articleWithZeroResultSearchList.size();
    }

    public int getSizeOfProductsList() {
        return productsList.size();
    }

    public void clickLoadMoreButton() {
        loadMoreButton.click();
    }

    public boolean isLoadMoreButtonVisible() {
        return loadMoreButton.isDisplayed();
    }
    public void clickLoadPreviousButton() {
        loadPreviousButton.click();
    }

    public boolean isLoadPreviousButtonVisible() {
        return loadPreviousButton.isDisplayed();
    }

    public WebElement getLoadMoreButton() {
        return loadMoreButton;
    }

    public WebElement getStylesCountLabel() {
        return stylesCountLabel;
    }

    public List<String> getDescriptionsList() {
        List<String> list = new ArrayList<>();
        for(WebElement webElement : descriptionsList)
        {
            list.add(webElement.getText());
        }
        return list;
    }
}
