package com.rawCodeDev.dynamicPaymentSystem.dto;

import lombok.Data;

@Data
public class PaypalRequestDto extends PaymentRequestDto{
    private String email;
    private String password;
}
