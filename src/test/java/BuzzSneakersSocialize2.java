import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BuzzSneakersSocialize2 {

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
        options.setExperimentalOption("w3c", true);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testLoginAndPersonalData() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba/");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        Thread.sleep(2000);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.login-btn")));
        loginButton.click();

        Thread.sleep(2000);

        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi svoj email *']")));
        emailInput.sendKeys("vedad.aljovic10@gmail.com");

        Thread.sleep(2000);

        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi svoju lozinku *']")));
        passwordInput.sendKeys("LozinkaTesting23!");

        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.sendKeys(passwordInput, Keys.RETURN).perform();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3850);");

        Thread.sleep(2000);

        WebElement facebookLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@title='Instagram']")));
        facebookLink.click();

        Thread.sleep(4000);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}