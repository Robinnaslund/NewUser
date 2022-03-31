import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");


    }

    @Given("I write an email address {string}")
    public void iWriteAnEmailAddress(String text) throws InterruptedException {
        driver.manage().window().setSize(new Dimension(783, 708));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(text);


    }

    @Given("I write a username {string}")
    public void iWriteAUsername(String text) {
        driver.manage().window().setSize(new Dimension(783, 708));
        driver.findElement(By.id("new_username")).click();
        driver.findElement(By.id("new_username")).sendKeys(text);
    }

    @Given("I write password {string}")
    public void iWritePassword(String text) {
        driver.manage().window().setSize(new Dimension(783, 708));
        driver.findElement(By.id("new_password")).click();
        driver.findElement(By.id("new_password")).sendKeys(text);

    }

    @When("I click on Sign up")
    public void iClickOnSignMeUp() {
        driver.manage().window().setSize(new Dimension(783, 708));
        scroll(driver);

        WebElement button = driver.findElement(By.id("create-account"));

        button.click();
    }

    @Then("Error message is displayed {string}")
    public void errorMessageIsDisplayed(String text) {
        WebElement message = driver.findElement(By.className("invalid-error"));

        message.getText();

        assertEquals(text, message.getText());
    }

    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

        element.sendKeys(text);
    }

    private static void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

}
