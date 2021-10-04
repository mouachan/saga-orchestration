package com.redhat.microsaga.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.microsaga.model.Payment;
import com.redhat.microsaga.model.PaymentInfo;
import com.redhat.microsaga.rest.PaymentRemoteServices;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PaymentService {
    @Inject
    @RestClient
    PaymentRemoteServices paymentRemoteServices;

    //@Fallback(fallbackMethod = "")
    public Payment payment(String id,String paymentCardId) {
        return paymentRemoteServices.payment(id, paymentCardId);
    }

    public Payment cancelPayment(String id, String paymentCardId) {
        return paymentRemoteServices.cancelPayment(id, paymentCardId);
    }
}
