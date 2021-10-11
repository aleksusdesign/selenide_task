package pages;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BootsPage extends BasePage {

    public final SelenideElement rangeOfPriceButton = $(By.xpath("//li[@data-dropdown-id='currentprice']//button[@class = '_1om7l06']"));

    public final SelenideElement rangeOfPricePopup = $(By.xpath("//div[@class='_2EAcS_V _2H7teJE']"));

    public final SelenideElement minIndicator = $(By.xpath("//div[@data-testid='minIndicator']"));

    private final SelenideElement minValueLabel = $(By.xpath("//span[@data-testid='minValueLabel']"));

    private final SelenideElement maxValueLabel = $(By.xpath("//span[@data-testid='maxValueLabel']"));

    public final SelenideElement sortButton = $(By.xpath("//button[@aria-haspopup='listbox']"));

    public final SelenideElement lowToHighButton = $(By.xpath("//li[@id='plp_web_sort_price_low_to_high']"));

    private final SelenideElement asosLabel = $(By.xpath("//label[@for= 'brand_53']"));

    private final SelenideElement brandsSortButton = $(By.xpath("//li[@data-dropdown-id='brand']//button"));

    private final SelenideElement baseLondonLabel = $(By.xpath("//label[@for= 'brand_12311']"));

    public final ElementsCollection pricesList = $$(By.xpath("//span[@class='_16nzq18']"));

    private final ElementsCollection descriptionsList = $$(By.xpath("//div[@data-auto-id='productTileDescription']//p"));

    public int getMinPrice(){return Integer.parseInt(minValueLabel.getText().substring(1));}

    public int getMaxPrice(){return Integer.parseInt(maxValueLabel.getText().substring(1));}

    public WebElement getRangeOfPriceButton() {
        return rangeOfPriceButton;
    }

    public WebElement getPriceOfFirstElement() {
        return pricesList.get(0);
    }

    public boolean isAsosLabelVisible() {
        return asosLabel.isDisplayed();
    }

    public boolean isBrandsSortButtonVisible() {
        return brandsSortButton.isDisplayed();
    }

    public void clickBrandsSortButton() {
        brandsSortButton.click();
    }

    public boolean isBaseLondonLabelVisible() {
        return baseLondonLabel.isDisplayed();
    }

    public void clickAsosLabel() {
        asosLabel.click();
    }

    public void clickBaseLondonLabel() {
        baseLondonLabel.click();
    }

    public WebElement getLowToHighButton() {
        return lowToHighButton;
    }

    public boolean isLowToHighButtonVisible(){return lowToHighButton.isDisplayed();}

    public boolean isSortButtonVisible(){return sortButton.isDisplayed();}

    public void clickLowToHighButton() {
        lowToHighButton.click();
    }

    public WebElement getSortButton() {
        return sortButton;
    }

    public void clickSortButton() {
        sortButton.click();
    }


    public void clickRangeOfPriceButton() {
        rangeOfPriceButton.click();
    }

    public void userDragsMinPriceTo(final int offSet) {
        Actions action = new Actions(WebDriverRunner.getWebDriver());
        action.dragAndDropBy(minIndicator, offSet,0).perform();
    }

    public WebElement getRangeOfPricePopup() {
        return rangeOfPricePopup;
    }

    public WebElement getMinIndicator() {
        return minIndicator;
    }

    public List<Float> getPricesList() {
        List<Float> list = new ArrayList<>();
        for(WebElement webElement : pricesList)
        {
            list.add(Float.parseFloat(webElement.getText().substring(1)));
        }
        return list;
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
