package cart;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private long productId;
    private String productName;
    private long productStock;
    private long productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductStock() {
        return productStock;
    }

    public void setProductStock(long productStock) {
        this.productStock = productStock;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    // cart의 productName으로 해당 상품의 가격 반환
    public Long getPriceByName(HashMap<String, CartDTO> cart, String productName) {
        for(Map.Entry<String, CartDTO> product : cart.entrySet()) {
            if(product.getKey().equals(productName))
                return product.getValue().getProductPrice();
        }
        return 0L;  // 없으면, 0 반환
    }

    // cart의 productName으로 해당 상품의 재고 반환
    public Long getStockByName(HashMap<String, CartDTO> cart, String productName) {
        for(Map.Entry<String, CartDTO> product : cart.entrySet()) {
            if(product.getKey().equals(productName))
                return product.getValue().getProductStock();
        }
        return 0L;  // 없으면 0 반환
    }
}
