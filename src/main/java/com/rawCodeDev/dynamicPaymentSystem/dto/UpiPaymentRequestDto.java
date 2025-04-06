package com.rawCodeDev.dynamicPaymentSystem.dto;

import lombok.Data;

@Data
public class UpiPaymentRequestDto extends PaymentRequestDto {
    private String upiId;
}
