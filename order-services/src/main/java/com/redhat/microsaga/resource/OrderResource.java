package com.redhat.microsaga.resource;

import java.util.UUID;


import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import com.redhat.microsaga.model.Order;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import io.vertx.kafka.client.serialization.JsonObjectSerializer;
import io.vertx.core.json.JsonObject;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.ce.CloudEventMetadata;

import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import org.jboss.logging.Logger;

import org.eclipse.microprofile.reactive.messaging.Message;

@Path("/")
public class OrderResource {
    private static final Logger LOGGER = Logger.getLogger(OrderResource.class);

    @Channel("order")
    Emitter<String> orderRequestEmitter;

   
    @POST
    @Path("/order")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrder(Order order) {
        
        
        JsonObject json = new JsonObject()
                                    .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
                                    .put("type", "order")
                                    .put("id", "12345")
                                    .put("source", "/order")
                                    .put("subject", "generated order")
                                    .put("datacontenttype", "application/json")
                                    .put("time", "2020-07-23T09:12:34Z")
                                    .put("data", order);

        orderRequestEmitter.send(json.encode());
        LOGGER.infof("Order %s produced into the topic order",json.encode());
        return "OK";
    }
}
