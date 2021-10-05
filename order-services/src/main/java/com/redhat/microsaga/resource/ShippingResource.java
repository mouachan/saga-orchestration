package com.redhat.microsaga.resource;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.microsaga.model.Order;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.ce.CloudEventMetadata;
import io.vertx.core.json.JsonObject;



@Path("/shipping")
public class ShippingResource {
    private static final Logger LOGGER = Logger.getLogger(ShippingResource.class);
    @Channel("shippingsuccess")
    Emitter<String> shippingRequestEmitter;

    @POST
    @Path("/{id}/schedule")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String scheduleShipping(@PathParam("id") String id, String schippingId){
        JsonObject json = new JsonObject()
        .put("specversion", CloudEventMetadata.CE_VERSION_1_0)
        .put("type", "shippingsuccess")
        .put("id", id)
        .put("source", "/shipping/schedule")
        .put("datacontenttype", "application/json")
        .put("time", "2020-07-23T09:12:34Z")
        .put("data",  schippingId)
        .put("kogitoprocrefid", id)
        .put("kogitoprocid","orders")
        .put("kogitoprocinstanceid",id);
        
        shippingRequestEmitter.send(json.encode());
        LOGGER.infof("event %s produced into the topic shippingsuccess",json.encode());
        LOGGER.infof("Shipping ID %s Start",schippingId);

        return "ShippingSuccess";
    }

    @DELETE
    @Path("/{id}/cancel")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String cancelShipping(@PathParam("id") String id, String schippingId){
        LOGGER.infof("Shipping ID %s canceled",schippingId);
        return "ShippingCanceled";
    }
}
