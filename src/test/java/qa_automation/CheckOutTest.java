package qa_automation;

import base.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.cms.RecipientId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.bouncycastle.cms.RecipientId.password;

public class CheckOutTest {
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

    @DataProvider(name = "userData")
    public Object[][] UserData() {
        return new Object[][]{
                {"Gergana", "Georgieva", "1000"}
        };
    }

    @Test(dataProvider = "Correct-login")
    public void loginSuccess(String userName, String password) {
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();


        WebElement addItemButton = driver.findElement(By.id("shopping_cart_container"));
        addItemButton.click();


        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        WebElement checkout_button = driver.findElement(By.id("checkout"));
        checkout_button.click();


        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys("Gergana");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.click();
        lastName.sendKeys("Georgieva");

        WebElement postCode = driver.findElement(By.id("postal-code"));
        postCode.click();
        postCode.sendKeys("1000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement FinishButton = driver.findElement(By.id("finish"));
        FinishButton.click();

        WebElement showButton = driver.findElement(By.className("pony-express"));

        Assert.assertTrue(showButton.isDisplayed());
    }
}
