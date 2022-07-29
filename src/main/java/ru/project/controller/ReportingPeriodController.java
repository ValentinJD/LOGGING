package ru.project.controller;

import ru.project.dao.ReportingPeriodDaoImpl;
import ru.project.dao.SpikeReportingPeriodDao;
import ru.project.entity.ReportingPeriod;

//import javax.ejb.*;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/reporting-period-list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionManagement(TransactionManagementType.BEAN)
public class ReportingPeriodController {

    @Inject
    ReportingPeriodDaoImpl reportingPeriodDao;

    @GET
    public List<ReportingPeriod> getAll() {
        List<ReportingPeriod> periods = reportingPeriodDao.findAll();
        return periods;
    }

    @PUT
    public ReportingPeriod updateReportingPeriod(ReportingPeriod period) {
        return reportingPeriodDao.save(period);
    }
}
