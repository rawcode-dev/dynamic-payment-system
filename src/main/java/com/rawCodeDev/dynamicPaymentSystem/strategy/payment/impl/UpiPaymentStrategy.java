package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.UpiPaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("UPI")
public class UpiPaymentStrategy implements PaymentStrategy<UpiPaymentRequestDto> {
    @Override
    public void pay(UpiPaymentRequestDto paymentRequestDto) {
        log.info("{} paid with UPI by {}", paymentRequestDto.getAmount(), paymentRequestDto.getUpiId());
    }
}
