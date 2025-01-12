import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BuzzSneakersFieldInput2 {

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
    public void testShoppingFlow() throws InterruptedException {
        driver.get("https://www.buzzsneakers.ba/patike/312738-nike-patike-nike-air-dunk-jumbo");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.cookie-agree-gdpr")));
        agreeButton.click();

        Thread.sleep(2000);

        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[.//span[@class='eur-size' and text()='44']]")));
        sizeButton.click();

        Thread.sleep(1000);

        WebElement korpaButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@id='nb_addToCartButton' and contains(text(), 'Dodaj u korpu')]")));
        korpaButton.click();

        Thread.sleep(1500);

        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='icon-wrapper' and .//span[text()='Korpa']]")));
        cartButton.click();

        Thread.sleep(3000);

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity_1")));
        dropdown.click();

        Thread.sleep(1000);

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='quantity_1']/option[@value='3']")));
        option.click();

        Thread.sleep(3000);

        WebElement nextStepButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Sljedeći korak') and contains(@class, 'btn-info')]")));
        nextStepButton.click();

        Thread.sleep(2000);

        WebElement deliveryOptionButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@href='#carrer_collapse_9']")));
        deliveryOptionButton.click();

        Thread.sleep(2000);

        WebElement paymentButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@href='#payment_collapse_3']")));
        paymentButton.click();

        Thread.sleep(1000);

        WebElement paymentOptionButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='delivery-option-name']//strong[text()='PLATNA KARTICA']")));
        paymentOptionButton.click();

        Thread.sleep(1000);

        WebElement nextStepButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='btn btn-info' and @onclick='nextStep()']")));
        nextStepButton2.click();

        Thread.sleep(2000);

        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_firstname")));
        firstNameInput.sendKeys(" ");

        Thread.sleep(1000);

        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_lastname")));
        lastNameInput.sendKeys(" ");

        Thread.sleep(1000);

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_email")));
        emailInput.sendKeys("vedad.aljovic");

        Thread.sleep(1000);

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_phone")));
        phoneInput.sendKeys("phoneNum");

        Thread.sleep(1000);

        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_city")));
        cityInput.sendKeys("Sarajevo");

        Thread.sleep(3000);

        WebElement streetInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_street")));
        streetInput.sendKeys(" ");

        Thread.sleep(1000);

        WebElement streetNumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cart_onepage_street_no")));
        streetNumInput.sendKeys("StreetNum");

        Thread.sleep(1000);

        WebElement nextStepButton3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='btn btn-info' and @onclick='nextStep()']"))
        );
        nextStepButton3.click();

        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}