package ru.project.dao;


import ru.project.HibernateUtil;
import ru.project.entity.ReportingPeriod;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
//@Transactional
public class ReportingPeriodDaoImpl {

    @Inject
    private EntityManager em;

    public List<ReportingPeriod> findAll() {
        return em.createQuery("SELECT period FROM ReportingPeriod period")
                .getResultList();
    }

    public ReportingPeriod save(ReportingPeriod entity) {
        if (entity.getId() != null) {
            return em.merge(entity);
        }
        em.persist(entity);
        return entity;
    }
}
