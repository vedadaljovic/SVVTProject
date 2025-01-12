import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzSneakersNavAndFilter2 {

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
    public void testNavigationAndFilter() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();
        Thread.sleep(1000);

        WebElement muskarciButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='MUŠKARCI']")));
        muskarciButton.click();
        Thread.sleep(1000);

        WebElement allShoesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.btn.btn-success[title='SEE ALL SHOES']")));
        allShoesButton.click();
        Thread.sleep(1000);

        WebElement cijenaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Cijena']")));
        cijenaDropdownButton.click();
        Thread.sleep(1000);

        WebElement priceButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='f_pricelist_200' and contains(text(), '101 - 200 KM')]")));
        priceButton.click();
        Thread.sleep(3000);

        WebElement velicinaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Veličina']")));
        velicinaDropdownButton.click();
        Thread.sleep(1000);

        WebElement velicinaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='f_eusize_38']")));
        velicinaButton.click();
        Thread.sleep(2000);

        WebElement bojaDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Boja']")));
        bojaDropdownButton.click();
        Thread.sleep(1000);

        WebElement bojaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='94_crna']")));
        bojaButton.click();
        Thread.sleep(2000);

        WebElement brendDropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'headline-wrapper')]//div[contains(@class, 'title') and text()='Brendovi']")));
        brendDropdownButton.click();
        Thread.sleep(1000);

        WebElement brendButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for='6_adidas' and contains(text(), 'adidas')]")));
        brendButton.click();
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}