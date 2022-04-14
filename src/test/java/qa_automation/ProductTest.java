package qa_automation;

import base.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends TestUtils {
    private WebDriver driver;
    private WebDriver driver1;

    @BeforeTest
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver1 = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        driver1.quit();
    }

    @DataProvider(name = "Correct-login")
    public Object[][] loginData() {
        return new Object[][]{
                {"problem_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "Correct-login")
    public void loginSuccess(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement login_button = driver.findElement(By.className("btn_action"));
        login_button.click();

        WebElement add_item_button = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        add_item_button.click();

        WebElement add_second_Item = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        add_second_Item.click();


        WebElement showButton = driver.findElement(By.className("shopping_cart_badge"));

        Assert.assertTrue(showButton.isDisplayed());
    }
}

