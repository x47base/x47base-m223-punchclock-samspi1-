package ch.zli.m223.controller;

import ch.zli.m223.service.EntryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
public class StatisticsController {
    @Inject
    EntryService entryService;

    @GET
    @Path("/time-summaries")
    public Map<String, String> getTimeSummaries() {
        return entryService.getTimeSummaries();
    }
}
