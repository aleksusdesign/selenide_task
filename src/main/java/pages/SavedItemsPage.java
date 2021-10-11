package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class SavedItemsPage extends BasePage {

    public final SelenideElement countOfSavedItems = $(By.xpath("//div[contains(@class, 'itemCount')]"));

    public WebElement getCountTitleOfSavedItems(){return countOfSavedItems;}

    public String getCountOfSavedItems(){return countOfSavedItems.getText().split(" ")[0];}
}
