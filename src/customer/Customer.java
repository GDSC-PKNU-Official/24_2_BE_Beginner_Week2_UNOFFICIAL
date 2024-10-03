package customer;

import cart.OrderSheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static String userId;
    private String userAddress;
    private String userPhoneNumber;
    private long account;  // 잔액
    private int payDate;  // 신용카드 결제일
    private long money;  // 금액
    private List<OrderSheet> orderSheetList = new ArrayList<OrderSheet>();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Customer(String userId, String userAddress, String userPhoneNumber, long account, int payDate) {
        this.userId = userId;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.account = account;
        this.payDate = payDate;
    }

    // 주소 수정 메소드
    public void modifyAddress() throws IOException{
        System.out.print("주소를 입력해주세요: ");
        String newAddress = reader.readLine();
        this.userAddress = newAddress;
        System.out.println("주소가 수정되었습니다.");
    }

    // 전화번호 수정 메소드
    public void modifyPhoneNumber() throws IOException{
        System.out.print("전화번호를 입력해주세요: ");
        String newPhoneNumber = reader.readLine();
        this.userPhoneNumber = newPhoneNumber;
        System.out.println("전화번호가 수정되었습니다.");
    }

    // 잔액 확인 메소드
    public long accountCheck(long account) {
        return this.account;
    }

    // 잔액 인춞 메소드
    private void withdrawAccount(long account) throws IOException{
        // 인출금액이 잔액보다 적은 경우
        System.out.print("인출할 금액을 입력하시오: ");

        money = Long.parseLong(reader.readLine());

        if(account >= money) {
            account -= money;
            System.out.println(money + "원이 인출되었습니다. 잔액은 " + account + "원입니다.");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 잔액 입금 메소드
    private void depositAccount(long account) throws IOException{
        System.out.print("입금할 금액을 입력하시오: ");

        money = Long.parseLong(reader.readLine());

        account += money;
        System.out.println(money + "원이 입금되었습니다. 잔액은 " + account + "원입니다.");
    }
}