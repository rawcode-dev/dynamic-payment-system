package com.rawCodeDev.dynamicPaymentSystem.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private Double amount;
    private PaymentType paymentType;
}
