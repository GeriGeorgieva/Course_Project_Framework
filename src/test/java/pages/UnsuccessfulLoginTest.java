package pages;

import base.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnsuccessfulLoginTest extends TestUtils {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    public UnsuccessfulLoginTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public UnsuccessfulLoginTest login(String username, String password){

        return new UnsuccessfulLoginTest(driver);
    }
}
