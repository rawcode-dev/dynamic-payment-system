package com.rawCodeDev.dynamicPaymentSystem.dto;

import lombok.Data;

@Data
public abstract class PaymentRequestDto {
    private Double amount;
    private PaymentType paymentType;
}
