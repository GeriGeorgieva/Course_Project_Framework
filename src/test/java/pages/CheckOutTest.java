package pages;

import base.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutTest extends TestUtils {
    protected WebDriver driver;
    private static final String ADD_TO_CARD_LOCATOR = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy(id = "shopping_cart_container")
    private WebElement addToCartSauceLabsBikeLight;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;






}
