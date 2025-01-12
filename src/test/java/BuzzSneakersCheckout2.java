import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzSneakersCheckout2 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
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
    void testBuzzSneakersCheckout() {
        try {
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

            WebElement paymentButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@href='#carrer_collapse_3']")));
            paymentButton.click();

            Thread.sleep(2000);

            WebElement clickCollectOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'delivery-option-name') and contains(text(), 'Click&Collect')]")));
            clickCollectOption.click();

            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300);");

            Thread.sleep(2000);

            WebElement storeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_storeReciveId")));
            storeDropdown.click();

            Select storeSelect = new Select(storeDropdown);
            storeSelect.selectByValue("8");

            WebElement nextStepButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@class='btn btn-info' and @onclick='nextStep()']")));
            nextStepButton2.click();

            Thread.sleep(2000);

            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_firstname")));
            firstNameInput.sendKeys("Vedad");

            Thread.sleep(1000);

            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_lastname")));
            lastNameInput.sendKeys("Aljovic");

            Thread.sleep(1000);

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_email")));
            emailInput.sendKeys("vedad.aljovic@stu.ibu.edu.ba");

            Thread.sleep(1000);

            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_phone")));
            phoneInput.sendKeys("+38762551854");

            Thread.sleep(1000);

            WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_city")));
            cityInput.sendKeys("Sarajevo");

            Thread.sleep(3000);

            cityInput.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(2000);
            cityInput.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            WebElement streetInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_street")));
            streetInput.sendKeys("Francuske Revolucije");

            Thread.sleep(1000);

            WebElement streetNumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("cart_onepage_street_no")));
            streetNumInput.sendKeys("14");

            Thread.sleep(1000);

            WebElement nextStepButton3 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@class='btn btn-info' and @onclick='nextStep()']")));
            nextStepButton3.click();

            Thread.sleep(2000);

        } catch (Exception e) {
            Assertions.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}