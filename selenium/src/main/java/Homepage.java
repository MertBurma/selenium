import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Homepage extends BasePage {

    SearchBox searchBox;
    MiniCart miniCart;
    By CartCountLocator = By.id("cart-items");

    public Homepage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;



    }
    public MiniCart miniCart() {
        return this.miniCart;

    }

    public boolean isCountUp() {
        return getCartCount() > 0;
    }
    private int getCartCount() {
       String count = find(CartCountLocator).getText();
       return Integer.parseInt(count);
    }

}
