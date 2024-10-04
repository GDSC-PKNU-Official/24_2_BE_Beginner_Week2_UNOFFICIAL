import cart.Cart;
import cart.OrderSheet;
import cart.exception.CartLimitExcessException;
import customer.Customer;
import product.Product;
import product.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 입출력을 제어하고 사용자로부터 입력받은 명령을 처리하는 클래스
 */
public class CommandHandler {
    private static final List<Product> productList = new ArrayList<Product>();

    private final Cart cart;
    private final Customer customer;

    // Constructor DI
    public CommandHandler(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
        // 파일 데이터로부터 상품 목록을 초기화합니다.
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
        System.out.println("cart: 현재 장바구니에 담긴 모든 물품을 출력합니다.");
        System.out.println("order: 장바구니에 있는 상품을 주문합니다.");
        System.out.println("orders: 주문한 주문서를 전부 보여줍니다.");
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

    public void addCommand(Scanner scanner){
        System.out.println("장바구니에는 최대 50개의 상품을 담을 수 있습니다.");
        System.out.print("상품 id와 수량을 입력해주세요: ");
        long productId = scanner.nextLong();
        int orderQuantity = scanner.nextInt();
        try{
            cart.addProduct(productId, orderQuantity);
        } catch (CartLimitExcessException e){
            throw new RuntimeException(e);
        }
    }

    public void discardCommand(Scanner scanner){
        System.out.print("장바구니에 뺄 상품 id와 수량을 입력해주세요: ");
        long productId = scanner.nextLong();
        int orderQuantity = scanner.nextInt();
        cart.deleteProduct(productId, orderQuantity);
    }

    public void cartCommand(){
        System.out.println("현재 장바구니 품목: ");
        cart.showInCart();
    }
    
    public void orderCommand(){
        OrderSheet resultSheet = cart.makeOrder();
        if(resultSheet != null){
            customer.addMyOrder(resultSheet);
            System.out.println("주문이 완료되었습니다. 주문내역: ");
            resultSheet.showSheet();
        } else {
            // 추후 Exception 처리할 예정
            System.out.println("주문이 유효하지 않습니다."); 
        }
    }

    public void ordersCommand(){
        System.out.println("현재 고개님의 주문내역입니다: ");
        customer.showMyOrders();
    }

}
