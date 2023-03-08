package com.example.productorderservice.payment;

public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void execute(Payment payment) {
        System.out.println("결제완료");
    }

    @Override
    public void execute(int price, String cardNumber) {
        System.out.println("결제완료");
    }
}
