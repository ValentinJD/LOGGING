package ru.project;


import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class ReportingPeriodDaoImpl  {

//    @PersistenceContext
//    private EntityManager em;

    public List<ReportingPeriod> getPeriods() {
        EntityManager em = HibernateUtil.getEm();
        return em.createQuery("SELECT period FROM ReportingPeriod period")
                .getResultList();
    }

}
