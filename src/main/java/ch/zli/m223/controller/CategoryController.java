package ch.zli.m223.controller;

import ch.zli.m223.model.Category;
import ch.zli.m223.service.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {
    @Inject
    CategoryService categoryService;

    @GET
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @POST
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @PUT
    @Path("/{id}")
    public Category update(@PathParam("id") Long id, Category category) {
        return categoryService.update(id, category);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        categoryService.delete(id);
    }
}
