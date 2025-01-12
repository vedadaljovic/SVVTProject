import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BuzzSneakersRegistration4 {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

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
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testRegistration() {
        try {
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
            firstName.sendKeys("Vedad");

            Thread.sleep(2000);

            WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@placeholder='Unesi svoje prezime *']")));
            lastName.sendKeys("Aljovic");

            Thread.sleep(2000);

            WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@placeholder='Unesi svoju e-mail adresu *']")));
            emailInput.sendKeys("vedqd.1@gmail.com");

            Thread.sleep(2000);

            WebElement dateInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//input[@placeholder='dd/mm/yyyy *']")));
            js.executeScript("arguments[0].value = '15/08/2011';", dateInput);

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

            Thread.sleep(4000);

            assertTrue(driver.getCurrentUrl().contains("confirmation"));

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}