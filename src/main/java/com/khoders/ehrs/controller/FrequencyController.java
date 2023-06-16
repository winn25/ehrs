package com.khoders.ehrs.controller;

import com.khoders.ehrs.ApiEndpoint;
import com.khoders.ehrs.payload.FrequencyDto;
import com.khoders.ehrs.services.FrequencyService;
import com.khoders.resource.jaxrs.JaxResponse;
import com.khoders.resource.utilities.Msg;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
 */
@Path(ApiEndpoint.FREQUENCY_ENDPOINT)
public class FrequencyController {
    private static final Logger log = LoggerFactory.getLogger(FrequencyController.class);
    @Inject private FrequencyService frequencyService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@HeaderParam("userAccountId") String userAccountId,FrequencyDto dto){
        log.debug("Frequency saving...");
        FrequencyDto frequencyDto = frequencyService.save(dto, userAccountId);
        return JaxResponse.created(Msg.CREATED, frequencyDto);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@HeaderParam("userAccountId") String userAccountId,FrequencyDto dto){
        log.debug("Frequency updating...");
        FrequencyDto frequencyDto = frequencyService.save(dto, userAccountId);
        return JaxResponse.created(Msg.UPDATED, frequencyDto);
    }
    
    @GET
    @Path("/{frequencyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("frequencyId") String frequencyId){
        log.debug("Frequency updating...");
        FrequencyDto depDto = frequencyService.findById(frequencyId);
        return JaxResponse.created(Msg.RECORD_FOUND, depDto);
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        log.debug("Frequency listing...");
        List<FrequencyDto> dtoList = frequencyService.frequencyList();
        if(dtoList.isEmpty()){
            return JaxResponse.ok(Msg.RECORD_NOT_FOUND, dtoList);
        }
        return JaxResponse.ok(Msg.RECORD_FOUND, dtoList);
    }
    
    @DELETE
    @Path("/{frequencyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("frequencyId") String frequencyId){
        log.debug("Frequency deleting...");
        if(frequencyService.delete(frequencyId))
            return JaxResponse.created(Msg.DELETED, true);
        return JaxResponse.error("Could not delete frequency", false);
    }
}
