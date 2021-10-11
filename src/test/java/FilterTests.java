import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BootsPage;
import pages.SearchResultsPage;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ScreenShooterExtension.class})
public class FilterTests extends BaseTest {

    private int minPrice;
    private int maxPrice;

    @Test
    @DisplayName("Check list with price filter")
    public void checkListWithPriceFilter(){
        homePage.openHomePage();
        homePage.clickOnMenFloorButton();
        homePage.clickShoesButton();
        homePage.getBootsButton().scrollTo();
        BootsPage bootsPage = homePage.clickBootsButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.productsList.first().scrollTo();
        bootsPage.clickRangeOfPriceButton();
        bootsPage.userDragsMinPriceTo(170);
        minPrice = bootsPage.getMinPrice();
        maxPrice = bootsPage.getMaxPrice();
        bootsPage.pricesList.shouldHave(CollectionCondition.allMatch("",
                webElement -> (Float.parseFloat(webElement.getText().substring(1))>=minPrice) &&
                        Float.parseFloat(webElement.getText().substring(1))<=maxPrice));
    }

    @Test
    @DisplayName("Check sort by price low to high")
    public void checkSortByPriceLowToHight(){
        homePage.openHomePage();
        homePage.clickOnMenFloorButton();
        homePage.clickShoesButton();
        homePage.getBootsButton().scrollTo();
        BootsPage bootsPage = homePage.clickBootsButton();
        bootsPage.sortButton.shouldBe(appear);
        bootsPage.clickSortButton();
        bootsPage.lowToHighButton.shouldBe(visible);
        bootsPage.clickLowToHighButton();
        WebDriverRunner.getWebDriver().navigate().refresh();
        new SearchResultsPage().productsList.first().shouldBe(appear);
        List<Float> expected = bootsPage.getPricesList();
        Collections.sort(expected);
        assertEquals(expected, bootsPage.getPricesList());
    }


}
