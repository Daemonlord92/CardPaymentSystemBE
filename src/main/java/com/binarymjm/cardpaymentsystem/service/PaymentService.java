package com.binarymjm.cardpaymentsystem.service;

import com.binarymjm.cardpaymentsystem.dto.PostNewPayment;
import com.stripe.exception.StripeException;

public interface PaymentService {
    public String postPayment(PostNewPayment postNewPayment) throws StripeException;
}
