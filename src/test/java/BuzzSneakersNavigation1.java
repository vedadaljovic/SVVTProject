import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzSneakersNavigation1 {

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
    public void testNavigation() throws InterruptedException {
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

        Thread.sleep(3000);

        WebElement zeneButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='ŽENE']")));
        zeneButton.click();

        Thread.sleep(3000);

        WebElement djecaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='DJECA']")));
        djecaButton.click();

        Thread.sleep(3000);

        WebElement jordanButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.jordan-main-menu a[href='https://www.buzzsneakers.ba/proizvodi/jordan']")));
        jordanButton.click();

        Thread.sleep(3000);

        WebElement brendoviButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='BRENDOVI']")));
        brendoviButton.click();

        Thread.sleep(3000);

        WebElement buzzCrewButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[title='BUZZ CREW']")));
        buzzCrewButton.click();

        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}