package com.binarymjm.cardpaymentsystem.controller;

import com.binarymjm.cardpaymentsystem.dto.PostNewPayment;
import com.binarymjm.cardpaymentsystem.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiv1/payment")
public class PaymentController {
    protected final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> makePayment(@RequestBody PostNewPayment postNewPayment) throws StripeException {
        return new ResponseEntity<>(paymentService.postPayment(postNewPayment), HttpStatus.ACCEPTED);
    }
}
