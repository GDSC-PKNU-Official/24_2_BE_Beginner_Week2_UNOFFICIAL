import cart.Cart;
import customer.Customer;
import product.Product;
import product.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    private static final List<Product> productList = new ArrayList<Product>();

    private final Cart cart;
    private final Customer customer;

    public CommandHandler(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
        ProductDao productDao = new ProductDao();
        productList.addAll(productDao.getProductList());
        System.out.println("저희 서비스에 오신걸 환영합니다.");
        helpCommand();
    }

    public void helpCommand(){
        System.out.println("우리 서비스는 다음 명령을 제공하고 있습니다.");
        System.out.println("help: 우리 서비스가 제공하고 있는 명령어 목록을 출력합니다.");
        System.out.println("list: 현재 상품 목록을 출력합니다.");
        System.out.println("add {상품id} {상품 수량}: 해당 상품을 장바구니에 수량만큼 추가합니다.");
        System.out.println("discard {상품id} {상품 수량}: 해당 상품을 장바구니에 수량만큼 빼거나 제거합니다.");
        System.out.println("show cart: 현재 장바구니에 담긴 모든 물품을 출력합니다.");
        System.out.println("order: 장바구니에 있는 상품을 주문합니다.");
        System.out.println("show order: 주문한 주문서를 전부 보여줍니다.");
        System.out.println("exit: 서비스를 종료합니다.");
    }

    public void listCommand(){
        System.out.println("상품 id(숫자), 상품명, 상품종류, 브랜드명, 가격(원), 현재 재고(개) 순입니다.");
        if(!productList.isEmpty()){
            for (Product product : productList) {
                System.out.println(product.toString());
            }
        }
        else {
            System.out.println("죄송합니다. 현재 상품이 없습니다.");
        }
    }


}
