package ch.zli.m223.service;

import ch.zli.m223.model.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    EntityManager entityManager;

    public List<Category> findAll() {
        return entityManager.createQuery("FROM Category", Category.class).getResultList();
    }

    @Transactional
    public Category create(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Transactional
    public Category update(Long id, Category category) {
        if (!id.equals(category.getId())) {
            throw new IllegalArgumentException("Ids do not match");
        }
        return entityManager.merge(category);
    }

    @Transactional
    public void delete(Long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}
