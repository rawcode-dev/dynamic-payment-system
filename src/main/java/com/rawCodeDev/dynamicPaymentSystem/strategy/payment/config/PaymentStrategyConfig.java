package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.config;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentType;
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

    @Bean
    public Map<PaymentType, PaymentStrategy> paymentStrategy(UpiPaymentStrategy upiPaymentStrategy,
                                                             CreditCardPaymentStrategy creditCardPaymentStrategy,
                                                             PaypalPaymentStrategy paymentStrategy){
        Map<PaymentType, PaymentStrategy> paymentStrategyMap = new HashMap<>();
        paymentStrategyMap.put(PaymentType.UPI, upiPaymentStrategy);
        paymentStrategyMap.put(PaymentType.CREDIT_CARD, creditCardPaymentStrategy);
        paymentStrategyMap.put(PaymentType.PAYPAL, paymentStrategy);
        return paymentStrategyMap;
    }
}
