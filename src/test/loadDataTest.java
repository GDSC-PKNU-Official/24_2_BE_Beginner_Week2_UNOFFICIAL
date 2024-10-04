import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductDao;

import java.util.List;

public class loadDataTest {
    @DisplayName("파일 읽기 테스트입니다.")
    @Test
    void loadDataTest(){
        ProductDao productDao = new ProductDao();

        List<Product> productList = productDao.getProductList();

        Assertions.assertNotNull(productList);
        for(Product product : productList){
            System.out.println(product.toString());
        }

    }

}
