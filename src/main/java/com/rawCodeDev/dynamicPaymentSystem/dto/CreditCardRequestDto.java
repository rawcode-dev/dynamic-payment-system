package com.rawCodeDev.dynamicPaymentSystem.dto;

import lombok.Data;

@Data
public class CreditCardRequestDto extends PaymentRequestDto{
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String cardHolderName;
}
