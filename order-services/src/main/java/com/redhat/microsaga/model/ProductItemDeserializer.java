package com.redhat.microsaga.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class ProductItemDeserializer extends ObjectMapperDeserializer<ProductItem> {
    public ProductItemDeserializer() {
        super(ProductItem.class);
    }
}
