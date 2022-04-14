package pages;

import base.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulLoginTest extends TestUtils {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    public SuccessfulLoginTest(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public SuccessfulLoginTest login(String username, String password){

        return new SuccessfulLoginTest(driver);
    }
}
