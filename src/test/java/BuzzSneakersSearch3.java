import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BuzzSneakersSearch3 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
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
    public void testSearchAndOpenProduct() {
        try {
            driver.get("https://www.buzzsneakers.ba");
            driver.manage().window().maximize();

            Thread.sleep(1000);

            WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.cookie-agree-gdpr")));
            agreeButton.click();

            Thread.sleep(1000);

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div.autocomplete-button-simple")));
            searchButton.click();

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input.autocomplete-input")));
            searchInput.sendKeys("Ni");
            searchInput.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'product-item')]")));

            WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'product-item')]//a[contains(@title, 'adidas Patike Niteball')]")));
            productLink.click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div.product-detail-page")));

            assertTrue(driver.getTitle().contains("adidas Patike Niteball"));

            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}