package com.redhat.microsaga.resource;

import java.util.UUID;


import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.microsaga.model.Payment;
import com.redhat.microsaga.model.PaymentInfo;

import javax.ws.rs.PathParam;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import io.smallrye.reactive.messaging.ce.CloudEventMetadata;
import io.vertx.kafka.client.serialization.JsonObjectSerializer;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.reactive.messaging.Message;


import io.smallrye.reactive.messaging.ce.CloudEventMetadata;

import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;

import io.smallrye.mutiny.Multi;

@Path("/")
public class PaymentResource {
    private static final Logger LOGGER = Logger.getLogger(PaymentResource.class);

    @Channel("orderpaymentsuccess")
    Emitter<String> paymentRequestEmitter;

   
    @PUT
    @Path("/{id}/payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String payment(@PathParam("id") String id, String paymentCardId){
        // IncomingCloudEventMetadata<io.vertx.core.json.JsonObject> cloudEventMetadata = productItems.getMetadata(IncomingCloudEventMetadata.class).orElseThrow(() -> new IllegalArgumentException("Expected a Cloud Event"));
        // LOGGER.infof("Received Cloud Events (spec-version: %s): source:  '%s', type: '%s', subject: '%s' ",
        //             cloudEventMetadata.getSpecVersion(),
        //             cloudEventMetadata.getSource(),
        //             cloudEventMetadata.getType(),
        //             cloudEventMetadata.getSubject().orElse("no subject"),
        //             cloudEventMetadata.getExtension​("kogitoReferenceId")); 
        // for(ProductItem pi : productItems )
        //     LOGGER.infof("Product Item %s ",pi);
        // kogitoprocrefid and kogitoprocid are mandatory to find the existing process
        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "orderpaymentsuccess")
        .put("id", id)
        .put("source", "/payment")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  "OrderPaymentSuccess")
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","orders")
        .put("kogitoprocinstanceid",id);
        
        paymentRequestEmitter.send(json.encode());
        LOGGER.infof("event %s produced into the topic paymentsuccess",json.encode());
        return paymentCardId;
    }
}
