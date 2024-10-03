package customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customer {
    private static String userId;
    private String userAddress;
    private String userPhoneNumber;
    private long account;  // 잔액
    private int payDate;  // 신용카드 결제일

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
        System.out.println("주소를 입력해주세요: ");
        String newAddress = reader.readLine();
        this.userAddress = newAddress;
        System.out.println("주소가 수정되었습니다.");
    }

    // 전화번호 수정 메소드
    public void modifyPhoneNumber() throws IOException{
        System.out.println("전화번호를 입력해주세요: ");
        String newPhoneNumber = reader.readLine();
        this.userPhoneNumber = newPhoneNumber;
        System.out.println("전화번호가 수정되었습니다.");
    }

    // 잔액 확인 메소드
    public long accountCheck(long account) {
        return this.account;
    }
}