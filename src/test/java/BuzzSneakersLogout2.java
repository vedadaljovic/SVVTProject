import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BuzzSneakersLogout2 {

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
        options.setExperimentalOption("w3c", true);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testBuzzSneakersLogout() {
        try {
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

            WebElement nameSpan = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Vedo Aljovic']")));
            nameSpan.click();

            Thread.sleep(4000);

            WebElement personalDataLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.linkText("Lični podaci")));
            personalDataLink.click();

            Thread.sleep(4000);

            WebElement odjavaSpan = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Odjava']")));
            odjavaSpan.click();

            Thread.sleep(4000);

            WebElement favoriteIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#miniFavContent a[title='Prijavi se'] .icon-wrapper i.fa-heart-o")));
            favoriteIcon.click();

            Thread.sleep(4000);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}