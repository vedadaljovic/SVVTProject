import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

import java.time.Duration;

public class BuzzSneakersNavAndFilter3 {

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
    public void testFilterAndReset() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        WebElement muskarciButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='MUŠKARCI']")));
        muskarciButton.click();

        WebElement allShoesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.btn.btn-success[title='SEE ALL SHOES']")));
        allShoesButton.click();

        WebElement cijenaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Cijena']")));
        cijenaDropdownButton.click();

        WebElement priceButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='f_pricelist_200' and contains(text(), '101 - 200 KM')]")));
        priceButton.click();

        WebElement velicinaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Veličina']")));
        velicinaDropdownButton.click();

        WebElement velicinaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='f_eusize_38']")));
        velicinaButton.click();

        WebElement bojaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Boja']")));
        bojaDropdownButton.click();

        WebElement bojaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='94_crna']")));
        bojaButton.click();

        WebElement brendDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Brendovi']")));
        brendDropdownButton.click();

        WebElement brendButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='6_adidas' and contains(text(), 'adidas')]")));
        brendButton.click();

        WebElement restartFilters = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'reset-text')]")));
        restartFilters.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}