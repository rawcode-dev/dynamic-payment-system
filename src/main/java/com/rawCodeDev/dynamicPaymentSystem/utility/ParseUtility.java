package com.rawCodeDev.dynamicPaymentSystem.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rawCodeDev.dynamicPaymentSystem.dto.*;

public class ParseUtility {
    public static PaymentRequestDto parsePaymentRequestDto(PaymentType paymentType, Object requestDto) {
        ObjectMapper mapper = new ObjectMapper();
        return switch (paymentType) {
            case CREDIT_CARD -> mapper.convertValue(requestDto, CreditCardRequestDto.class);
            case UPI -> mapper.convertValue(requestDto, UpiPaymentRequestDto.class);
            case PAYPAL -> mapper.convertValue(requestDto, PaypalRequestDto.class);
            default -> throw new IllegalArgumentException(paymentType + "is not supported");
        };
    }
}
