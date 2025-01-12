import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BuzzSneakersRegistration1 {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

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
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testRegistrationProcess() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba/");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        Thread.sleep(2000);

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.register-btn")));
        registerButton.click();

        Thread.sleep(2000);

        WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi svoje ime *']")));
        firstName.sendKeys("Hećim");

        Thread.sleep(2000);

        WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi svoje prezime *']")));
        lastName.sendKeys("Serbezovski");

        Thread.sleep(2000);

        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi svoju e-mail adresu *']")));
        emailInput.sendKeys("fafahe9856@fenxz.com");

        Thread.sleep(2000);

        WebElement dateInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='dd/mm/yyyy *']")));
        js.executeScript("arguments[0].value = '12/09/1972'; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", dateInput);

        Thread.sleep(2000);

        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Unesi lozinku *']")));
        passwordInput.sendKeys("LozinkaTest123!");

        Thread.sleep(2000);

        WebElement passwordRepeatInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@placeholder='Ponovi lozinku *']")));
        passwordRepeatInput.sendKeys("LozinkaTest123!");

        Thread.sleep(2000);

        WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("label[for='gigya-multiChoice-1-106833322599063700']")));
        genderOption.click();

        Thread.sleep(2000);

        WebElement submitOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Registruj se']")));
        submitOption.click();

        Thread.sleep(2000);

        WebElement checkboxOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("gigya-checkbox-2273860597407830")));
        checkboxOption.click();

        Thread.sleep(1000);

        WebElement acceptOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@value='Prihvatam, registruj me']")));
        acceptOption.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}