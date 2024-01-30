package com.binarymjm.cardpaymentsystem.service;

import com.binarymjm.cardpaymentsystem.dto.PostNewPayment;
import com.google.gson.Gson;
import com.stripe.exception.StripeException;
import org.bson.json.JsonObject;
import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static Gson gson = new Gson();

    static class CreatePaymentResponse {
        private String clientSecret;
        public CreatePaymentResponse(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }
    @Override
    public String postPayment(PostNewPayment postNewPayment) throws StripeException {
        Stripe.apiKey = "sk_test_51OdwfXLd5JZyVKqk8nqXJlPhKdeExeSpO9rivisqKrslTrChSMTpLazEWgtvGNxEjJ1uMHSq9bM5hSHvIitjRmdo00z1yj1rn4";
        PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
                .setAmount(postNewPayment.amount())
                .setCurrency(postNewPayment.currency())
                .build();

        PaymentIntent paymentIntent =  PaymentIntent.create(params);
        CreatePaymentResponse response = new CreatePaymentResponse(paymentIntent.getClientSecret());
        return gson.toJson(response);
    }
}
