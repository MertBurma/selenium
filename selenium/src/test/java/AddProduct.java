import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddProduct extends BaseTest {
    Homepage homepage;
    ProductsPage productsPage;
    ProductDetailedPage productDetailedPage;
    CartPage cartPage;


    @Test
    @Order(1)
    public void search_product() {
        homepage = new Homepage(driver);
        productsPage = new ProductsPage(driver);
        //homepage geldikten sonra searchnoxa gitmek istiyorum sonrada search yapmak istiyorum.
        homepage.searchBox().search("Roman");
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on product page");


    }
    @Test
    @Order(2)
    public void select_product() {
        productDetailedPage = new ProductDetailedPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailedPage.isOnProductDetailedPage(),
        "Not on product detailed page");

    }
    @Test
    @Order(3)
    public void add_product_to_cart() {
      productDetailedPage.addToCart();
      Assertions.assertTrue(homepage.isCountUp(),
              "Product Count did not increase");

    }
    @Test
    @Order(4)
    public void clickGoMınıCart() {
        cartPage = new CartPage(driver);
        //
        homepage.miniCart().enter();
        Assertions.assertTrue(homepage.miniCart().checkMiniCart(),
                "MiniCart did not publish");
        homepage.miniCart().clickGoCart();

        Assertions.assertTrue(cartPage.isOnCartPage(),
                "Not on Cart Page");

    }
    @Test
    @Order(5)
    public void goCart() {
       cartPage.refresh();
        Assertions.assertTrue(cartPage.isLoadingScreen(),
                "LoadingScreen did not publish");
        cartPage.delete();
        Assertions.assertTrue(cartPage.isCartEmpty(),
                "Cart is not empty");
    }



}
