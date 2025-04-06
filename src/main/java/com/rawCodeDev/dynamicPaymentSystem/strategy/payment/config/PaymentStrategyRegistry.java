package com.rawCodeDev.dynamicPaymentSystem.strategy.payment.config;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.strategy.payment.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentStrategyRegistry {

    private final Map<Class<? extends PaymentRequestDto>, PaymentStrategy<? extends PaymentRequestDto>> strategyMap = new HashMap<>();

    public <T extends PaymentRequestDto> void register(Class<T> dtoType, PaymentStrategy<T> paymentStrategy){
        strategyMap.put(dtoType, paymentStrategy);
    }

    public PaymentStrategy<? extends PaymentRequestDto> getStrategy(Class<? extends PaymentRequestDto> dtoType){
        PaymentStrategy<? extends PaymentRequestDto> strategy = strategyMap.get(dtoType);
        if(strategy == null){
            throw new IllegalArgumentException(dtoType.getName() + " is not registered.");
        }
        return strategy;
    }
}
