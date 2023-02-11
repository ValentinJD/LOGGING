package ru.project.controller;

import ru.project.dao.ReportingPeriodDaoImpl;
import ru.project.dao.SpikeReportingPeriodDao;
import ru.project.entity.ReportingPeriod;
import ru.project.messaging.Producer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jms.JMSException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/reporting-period-list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class ReportingPeriodController {

//    @Inject
//    SpikeReportingPeriodDao reportingPeriodDao;

    @Inject
    ReportingPeriodDaoImpl reportingPeriodDaoN;

    @EJB
    private Producer producer;

    @GET
    public List<ReportingPeriod> getAll() throws JMSException {
        producer.produceMessage();
//        List<ReportingPeriod> periods = reportingPeriodDao.findAll();
        return new ArrayList<>();
    }

//    @Transactional
    @PUT
    public ReportingPeriod updateReportingPeriod(ReportingPeriod period) throws JMSException {
        producer.produceMessage();
//        reportingPeriodDao.save(period);
//        return reportingPeriodDao.save(period);
        return new ReportingPeriod();
    }
}
