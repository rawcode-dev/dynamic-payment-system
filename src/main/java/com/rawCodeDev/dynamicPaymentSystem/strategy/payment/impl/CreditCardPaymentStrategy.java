package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl;

import com.rawCodeDev.dynamicPaymentSystem.dto.CreditCardRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("CREDITCARD")
public class CreditCardPaymentStrategy implements PaymentStrategy<CreditCardRequestDto> {

    @Override
    public void pay(CreditCardRequestDto paymentRequestDto) {
        log.info("{} amount has been payed with credit card by {}", paymentRequestDto.getAmount(), paymentRequestDto.getCardHolderName());
    }
}
