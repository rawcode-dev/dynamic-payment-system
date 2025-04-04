package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl;

import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("CREDITCARD")
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Double amount) {
        log.info("{} paid with credit card", amount);
    }
}
