package qa_automation;

import base.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class UnsuccessfulLoginTest extends TestUtils {

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers() {
        return new Object[][]{
                {"standardUser5", "secret_sauce"},
                {"standard_user", "secret_sauce5"},
                {"wow", "wow"},
                {"wrong", "secret_sauce"}
        };
    }

    @Test(dataProvider = "wrongUsersList")
    public void UnsuccessfulLogin(String userName, String password) {

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordInput.click();
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
        loginBtn.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryToLogin("wrong", "wrong");


        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));

        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }
}
