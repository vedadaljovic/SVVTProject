import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuzzSneakersSearch2 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/vedadaljovic/Downloads/chromedriver-mac-arm64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void searchProductTest() {
        try {
            driver.get("https://www.buzzsneakers.ba");
            driver.manage().window().maximize();

            WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.cookie-agree-gdpr")));
            agreeButton.click();

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div.autocomplete-button-simple")));
            searchButton.click();

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input.autocomplete-input")));
            searchInput.sendKeys("adfnasnmdsmad");
            searchInput.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'product-item')]")));

            assertTrue(driver.getPageSource().contains("No results found"), "No results found message is not displayed");

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}