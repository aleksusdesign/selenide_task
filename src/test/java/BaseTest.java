import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith({TextReportExtension.class})
public class BaseTest {

    protected final HomePage homePage = new HomePage();

    public RemoteWebDriver driver;

    @Rule
    public TextReport report = new TextReport();

    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv(""));
        sauceOptions.setCapability("access_key", System.getenv(""));
        sauceOptions.setCapability("name", testInfo.getDisplayName());
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions option = new ChromeOptions();
        option.setCapability("sauce:options", sauceOptions);

        URL url = new URL("");

        driver = new RemoteWebDriver(url, option);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriverRunner.setWebDriver(driver);
    }

    public class SauceTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(ExtensionContext context) {
            driver.executeScript("sauce:job-result=passed");
            driver.quit();
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            driver.executeScript("sauce:job-result=failed");
            driver.quit();
        }
    }
}
