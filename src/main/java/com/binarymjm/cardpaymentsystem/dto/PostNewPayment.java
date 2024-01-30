package com.binarymjm.cardpaymentsystem.dto;

public record PostNewPayment(
        String currency,
        Long amount
) {
}
