package ru.project;


import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class ReportingPeriodDaoImpl implements ReportingPeriodDao {

//    @PersistenceUnit(name = "item-manager-pu")
    private EntityManager em = HibernateUtil.getEm();

    public List<ReportingPeriod> getPeriods() {
        EntityManager em = HibernateUtil.getEm();
//        EntityManager entityManager = em.createEntityManager();
        return em.createQuery("SELECT period FROM ReportingPeriod period")
                .getResultList();
    }

    @Override
    public ReportingPeriod save(ReportingPeriod entity) {
//        EntityManager entityManager = em.createEntityManager();
        if (entity.getId() != null) {
            return em.merge(entity);
        }
        em.persist(entity);
        return entity;
    }
}
