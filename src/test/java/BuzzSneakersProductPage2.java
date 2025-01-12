import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzSneakersProductPage2 {

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
    public void testProductPageFlow() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'autocomplete-button-simple')]//span[contains(text(), 'Pretraži sajt')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);

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

        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[.//span[@class='eur-size' and text()='44']]")));
        sizeButton.click();

        Thread.sleep(1000);

        WebElement sizeButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[.//span[@class='eur-size' and text()='41']]")));
        sizeButton2.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3850);");

        Thread.sleep(2000);

        WebElement specButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@data-toggle='collapse' and contains(@title, 'Specifikacija')]")));
        specButton.click();

        Thread.sleep(1000);

        WebElement checkAvailabilityButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@data-toggle='collapse' and contains(@title, 'Provjeri dostupnost u radnjama')]")));
        checkAvailabilityButton.click();

        Thread.sleep(1000);

        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}