package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.config;

import com.rawCodeDev.dynamicPaymentSystem.dto.CreditCardRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentType;
import com.rawCodeDev.dynamicPaymentSystem.dto.PaypalRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.dto.UpiPaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.CreditCardPaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.PaypalPaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.UpiPaymentStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentStrategyConfig {


    public PaymentStrategyConfig(PaymentStrategyRegistry paymentStrategyRegistry,
                                 UpiPaymentStrategy upiPaymentStrategy,
                                 CreditCardPaymentStrategy creditCardPaymentStrategy,
                                 PaypalPaymentStrategy paypalPaymentStrategy) {
        paymentStrategyRegistry.register(UpiPaymentRequestDto.class, upiPaymentStrategy);
        paymentStrategyRegistry.register(CreditCardRequestDto.class, creditCardPaymentStrategy);
        paymentStrategyRegistry.register(PaypalRequestDto.class, paypalPaymentStrategy);
    }
}
