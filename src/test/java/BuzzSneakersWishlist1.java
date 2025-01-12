import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BuzzSneakersWishlist1 {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/vedadaljovic/Downloads/chromedriver-mac-arm64/chromedriver");
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});
        options.setExperimentalOption("w3c", true);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;

        driver.get("https://www.buzzsneakers.ba/");
        driver.manage().window().maximize();
    }

    @Test
    public void testWishlistFunctionality() throws InterruptedException {
        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        Thread.sleep(1000);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.login-btn")));
        loginButton.click();

        Thread.sleep(2000);

        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Unesi svoj email *']")));
        emailInput.sendKeys("vedad.aljovic10@gmail.com");

        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Unesi svoju lozinku *']")));
        passwordInput.sendKeys("LozinkaTesting23!");

        Actions actions = new Actions(driver);
        actions.sendKeys(passwordInput, Keys.RETURN).perform();

        Thread.sleep(5000);

        WebElement nameSpan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Vedo Aljovic']")));
        nameSpan.click();

        Thread.sleep(4000);

        WebElement personalDataLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Lični podaci")));
        personalDataLink.click();

        Thread.sleep(4000);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'autocomplete-button-simple')]//span[contains(text(), 'Pretraži sajt')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);

        Thread.sleep(2000);

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.autocomplete-input")));
        searchInput.sendKeys("Nike");
        searchInput.sendKeys(Keys.ENTER);

        Thread.sleep(1500);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'product-item')]")));

        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'product-item')]//a[contains(@title, 'Nike Air Dunk Jumbo')]")));
        productLink.click();

        Thread.sleep(3000);

        WebElement wishlistIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-favorite.favorite .icon.fa-heart-o")));
        wishlistIcon.click();

        Thread.sleep(2000);

        WebElement favoriteLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div#miniFavContent a[href='https://www.buzzsneakers.ba/omiljeno/product']")));
        favoriteLink.click();

        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("All tests completed.");
    }
}
