package ch.zli.m223.service;

import ch.zli.m223.model.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TagService {
    @Inject
    EntityManager entityManager;

    public List<Tag> findAll() {
        return entityManager.createQuery("FROM Tag", Tag.class).getResultList();
    }

    @Transactional
    public Tag create(Tag tag) {
        entityManager.persist(tag);
        return tag;
    }

    @Transactional
    public Tag update(Long id, Tag tag) {
        if (!id.equals(tag.getId())) {
            throw new IllegalArgumentException("Ids do not match");
        }
        return entityManager.merge(tag);
    }

    @Transactional
    public void delete(Long id) {
        Tag tag = entityManager.find(Tag.class, id);
        if (tag != null) {
            entityManager.remove(tag);
        }
    }
}
