package com.rawCodeDev.dynamicPaymentSystem.service.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.service.PaymentService;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentServiceImpl(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    @Override
    public void processPayment(PaymentRequestDto paymentRequestDto) {
        PaymentStrategy paymentStrategy = paymentStrategies.get(paymentRequestDto.getPaymentType());
        if (paymentStrategy == null) {
            throw new RuntimeException(paymentRequestDto.getPaymentType() + " is not supported yet");
        }
        paymentStrategy.pay(paymentRequestDto.getAmount());
    }
}
