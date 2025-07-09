package ch.zli.m223.service;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Inject
    TimeSummaryService timeSummaryService;

    public Map<String, String> getTimeSummaries() {
        List<Entry> entries = findAll();
        return timeSummaryService.calculateSummaryPerDay(entries);
    }

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public Entry findEntry(Long id) {
        return entityManager.find(Entry.class, id);
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    public void deleteEntry(Long id) {
        var entity = findEntry(id);
        entityManager.remove(entity);
    }

    @Transactional
    public Entry editEntry(Long id, Entry entry) {
        if (entry.getId() != id) {
            throw new IllegalArgumentException("Ids do not match");
        }
        return entityManager.merge(entry);
    }
}
