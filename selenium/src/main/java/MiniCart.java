import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiniCart extends BasePage{
    By CartCountLocator = By.id("cart-items");
    By MiniCartLocator = By.id("js-cart");
    public MiniCart(WebDriver driver) {
        super(driver);
    }

    public void enter() {
        click(CartCountLocator);
    }

    public boolean checkMiniCart() {
        return isDisplayed(MiniCartLocator);

    }
    public void clickGoCart() {
        click(MiniCartLocator);
    }

}
