package qa_automation;

import base.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductTest {
    private WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
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

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        WebElement addItemButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addItemButton.click();

        WebElement addSecondItemButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        addSecondItemButton.click();


        WebElement showButton = driver.findElement(By.className("shopping_cart_badge"));

        Assert.assertTrue(showButton.isDisplayed());
    }
}

