import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class BuzzSneakersSearch1 {

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
    public void testSearchNikeProduct() {
        try {
            driver.get("https://www.buzzsneakers.ba");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.cookie-agree-gdpr")));
            agreeButton.click();

            Thread.sleep(1500);

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'autocomplete-button-simple')]//span[contains(text(), 'Pretraži sajt')]")));
            searchButton.click();

            Thread.sleep(2000);

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input.autocomplete-input")));
            searchInput.sendKeys("Nike");
            searchInput.sendKeys(Keys.ENTER);

            Thread.sleep(1500);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'product-item')]")));

            Thread.sleep(1000);

            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'product-item')]//a[contains(@title, 'Nike Air Dunk Jumbo')]")));
            productLink.click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div.product-detail-page")));

            assertTrue(driver.getCurrentUrl().contains("nike-air-dunk-jumbo"));

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}