import order.Product;
import order.dao.ProductDao;
import org.junit.jupiter.api.*;

import java.util.List;

public class ProductTest {
    @DisplayName("파일에서 데이터 읽기")
    @Test
    void testLoadData() {
        final ProductDao productDao = new ProductDao();

        final List<Product> productList = productDao.getProductList();

        Assertions.assertNotNull(productList);
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }
}
