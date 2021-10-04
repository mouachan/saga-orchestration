package com.redhat.microsaga.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class PaymentInfoDeserializer extends ObjectMapperDeserializer<PaymentInfo> {
    public PaymentInfoDeserializer() {
        super(PaymentInfo.class);
    }
}
