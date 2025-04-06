package com.rawCodeDev.dynamicPaymentSystem.strategy.payment;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;

public interface PaymentStrategy<T extends PaymentRequestDto> {
    void pay(T paymentRequestDto);
}
