import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailedPage extends BasePage{
    By ProductDescriptionLocator= By.id("description_text");
    By AddToCartLocator = By.cssSelector("button-cart");
    public ProductDetailedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailedPage() {
        return isDisplayed(ProductDescriptionLocator);
    }

    public void addToCart() {
        click(AddToCartLocator);
    }
}
