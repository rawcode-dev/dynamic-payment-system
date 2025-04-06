package com.rawCodeDev.dynamicPaymentSystem.service.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.service.PaymentService;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.config.PaymentStrategyRegistry;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategyRegistry paymentStrategyRegistry;

    public PaymentServiceImpl(PaymentStrategyRegistry paymentStrategyRegistry) {
        this.paymentStrategyRegistry = paymentStrategyRegistry;
    }

    @Override
    public void processPayment(PaymentRequestDto paymentRequestDto) {
        Class<? extends PaymentRequestDto> dtoType = paymentRequestDto.getClass();
        PaymentStrategy<? extends PaymentRequestDto> strategy = paymentStrategyRegistry.getStrategy(dtoType);
        invokePaymentProcess(strategy, paymentRequestDto);
    }

    private <T extends PaymentRequestDto> void invokePaymentProcess(PaymentStrategy<T> strategy, PaymentRequestDto paymentRequestDto) {
        @SuppressWarnings("unchecked")
        T requestDto = (T) paymentRequestDto;
        strategy.pay(requestDto);
    }
}
