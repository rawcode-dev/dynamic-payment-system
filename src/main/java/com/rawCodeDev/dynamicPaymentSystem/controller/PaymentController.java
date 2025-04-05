package com.rawCodeDev.dynamicPaymentSystem.controller;

import com.rawCodeDev.dynamicPaymentSystem.dto.PaymentRequestDto;
import com.rawCodeDev.dynamicPaymentSystem.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping()
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequestDto requestDto){
        paymentService.processPayment(requestDto);
        return ResponseEntity.ok("success");
    }
}
