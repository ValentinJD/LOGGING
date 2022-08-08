package ru.project.controller;

import ru.project.dao.ReportingPeriodDaoImpl;
import ru.project.dao.SpikeReportingPeriodDao;
import ru.project.entity.ReportingPeriod;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/reporting-period-list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ReportingPeriodController {

    @Inject
    SpikeReportingPeriodDao reportingPeriodDao;

    @Inject
    ReportingPeriodDaoImpl reportingPeriodDaoN;

    @GET
    public List<ReportingPeriod> getAll() {
        List<ReportingPeriod> periods = reportingPeriodDao.findAll();
        return periods;
    }

    @Transactional
    @PUT
    public ReportingPeriod updateReportingPeriod(ReportingPeriod period) {
        reportingPeriodDaoN.save(period);
        return reportingPeriodDao.save(period);
    }
}
