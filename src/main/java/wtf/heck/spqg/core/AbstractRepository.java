package wtf.heck.spqg.core;

import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Transactional
public abstract class AbstractRepository<T extends Serializable> {
    @Inject
    private EntityManager em;

    private Class<T> persistentClass;


    public AbstractRepository(Class clazz) {
        this.persistentClass = clazz;
    }

    public T getById(long id) {
        return em.find(persistentClass, id);
    }

    public List<T> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(persistentClass);
        Root<T> rootEntry = cq.from(persistentClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public T save(T entity) {
        return em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(entity);
    }

}
