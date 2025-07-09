package ch.zli.m223.controller;

import ch.zli.m223.model.Tag;
import ch.zli.m223.service.TagService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tags")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TagController {
    @Inject
    TagService tagService;

    @GET
    public List<Tag> getAll() {
        return tagService.findAll();
    }

    @POST
    public Tag create(Tag tag) {
        return tagService.create(tag);
    }

    @PUT
    @Path("/{id}")
    public Tag update(@PathParam("id") Long id, Tag tag) {
        return tagService.update(id, tag);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        tagService.delete(id);
    }
}
