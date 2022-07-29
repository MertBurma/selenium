import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    By CartModuleLocator = By.id("cart_module");
    By refreshLocator = By.cssSelector("fa fa-refresh green-icon");
    By LoadingLocator = By.id("swal-toast");
    By DeleteIconLocator = By.cssSelector("fa fa-times red-icon");
    By CartCountLocator = By.id("cart-items");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage() {
        return isDisplayed(CartModuleLocator);
    }


    public void refresh() {
        click(refreshLocator);

    }

    public boolean isLoadingScreen() {
       return isDisplayed(LoadingLocator);
    }
    public void delete() {
        click(DeleteIconLocator);
    }

    public boolean isCartEmpty() {
        return getCartCount() == 0;
    }
    private int getCartCount() {
        String count = find(CartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
