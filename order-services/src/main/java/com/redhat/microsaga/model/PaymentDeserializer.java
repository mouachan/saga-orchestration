package com.redhat.microsaga.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class PaymentDeserializer extends ObjectMapperDeserializer<Payment> {
    public PaymentDeserializer() {
        super(Payment.class);
    }
}
