package com.rawCodeDev.dynamicPaymentSystem.service.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentType;
import com.rawCodeDev.dynamicPaymentSystem.service.PaymentService;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategyRegistry;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategyRegistry paymentStrategyRegistry;

    public PaymentServiceImpl(PaymentStrategyRegistry paymentStrategyRegistry) {
        this.paymentStrategyRegistry = paymentStrategyRegistry;
    }

    @Override
    public void processPayment(PaymentRequestDto paymentRequestDto) {
        PaymentStrategy paymentStrategy = paymentStrategyRegistry.getPaymentStrategy(paymentRequestDto.getPaymentType());
        paymentStrategy.pay(paymentRequestDto.getAmount());
    }
}
