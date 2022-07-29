package ru.project.dao;


import ru.project.HibernateUtil;
import ru.project.entity.ReportingPeriod;

import javax.inject.Singleton;
//import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class ReportingPeriodDaoImpl  {

//    @PersistenceUnit(name = "item-manager-pu")
    private EntityManager em = HibernateUtil.getEm();

    public List<ReportingPeriod> findAll() {
        EntityManager em = HibernateUtil.getEm();
//        EntityManager entityManager = em.createEntityManager();
        return em.createQuery("SELECT period FROM ReportingPeriod period")
                .getResultList();
    }


    public ReportingPeriod save(ReportingPeriod entity) {
//        EntityManager entityManager = em.createEntityManager();
        if (entity.getId() != null) {
            return em.merge(entity);
        }
        em.persist(entity);
        return entity;
    }
}
