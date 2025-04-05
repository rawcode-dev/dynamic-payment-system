package com.rawCodeDev.dynamicPaymentSystem.service;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;

public interface PaymentService {
    void processPayment(PaymentRequestDto requestDto);
}
