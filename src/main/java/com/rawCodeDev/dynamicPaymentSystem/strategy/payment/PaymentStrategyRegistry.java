package com.rawCodeDev.dynamicPaymentSystem.strategy.payment;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentType;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.CreditCardPaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.PaypalPaymentStrategy;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.impl.UpiPaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class PaymentStrategyRegistry {

    private final Map<PaymentType, PaymentStrategy> paymentStrategyMap;

    public PaymentStrategyRegistry(){
        paymentStrategyMap = new HashMap<>();
        paymentStrategyMap.put(PaymentType.UPI, new UpiPaymentStrategy());
        paymentStrategyMap.put(PaymentType.CREDIT_CARD, new CreditCardPaymentStrategy());
        paymentStrategyMap.put(PaymentType.PAYPAL, new PaypalPaymentStrategy());
    }

    public PaymentStrategy getPaymentStrategy(PaymentType paymentType){
        PaymentStrategy paymentStrategy = paymentStrategyMap.get(paymentType);
        if(Objects.isNull(paymentStrategy)){
            throw new IllegalArgumentException(paymentType + "is not supported");
        }
        return paymentStrategy;
    }
}
