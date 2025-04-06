package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaypalRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("PAYPAL")
public class PaypalPaymentStrategy implements PaymentStrategy<PaypalRequestDto> {
    @Override
    public void pay(PaypalRequestDto paymentRequestDto) {
        log.info("{} paid with paypal payment by {}", paymentRequestDto.getAmount(), paymentRequestDto.getEmail());
    }
}
