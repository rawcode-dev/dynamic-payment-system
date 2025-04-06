package com.rawCodeDev.dynamicPaymentSystem.controller;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentType;
import com.rawCodeDev.dynamicPaymentSystem.service.PaymentService;
import com.rawCodeDev.dynamicPaymentSystem.utility.ParseUtility;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public ResponseEntity<String> processPayment(@RequestBody Map<String, Object> requestDto){
        PaymentType paymentTypeRequested = PaymentType.valueOf(requestDto.get("paymentType").toString());
        PaymentRequestDto paymentRequest = ParseUtility.parsePaymentRequestDto(paymentTypeRequested, requestDto);
        paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok("success");
    }
}
