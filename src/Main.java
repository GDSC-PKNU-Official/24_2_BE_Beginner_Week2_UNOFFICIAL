import cart.Cart;
import customer.Customer;

import java.util.Scanner;

public class Main{
    private static final Cart cart = new Cart();
    private static final Customer customer = new Customer();
    private static final CommandHandler commandHandler = new CommandHandler(cart, customer);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        commandIOSystem:
        while(true) {
            System.out.print("명령어를 입력해주세요: ");
            String command = scanner.next();
            switch (command) {
                case "exit":
                    System.out.println("저희 서비스를 이용해주셔서 감사합니다.");
                    break commandIOSystem;
                case "help":
                    commandHandler.helpCommand();
                    break;
                case "list":
                    commandHandler.listCommand();
                    break;
                case "add":
                    commandHandler.addCommand(scanner);
                    break;
                case "discard":
                    commandHandler.discardCommand(scanner);
                    break;
                case "cart":
                    commandHandler.cartCommand();
                    break;
                case "order":
                    commandHandler.orderCommand();
                    break;
                case "orders":
                    commandHandler.ordersCommand();
                    break;
                default:
                    System.out.println("지원하지 않는 명령어입니다.");
                    break;
            }

        }
    }
}