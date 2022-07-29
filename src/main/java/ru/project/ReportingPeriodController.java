package ru.project;

import javax.ejb.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;


@Path("/reporting-period-list")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@TransactionManagement(TransactionManagementType.BEAN)
public class ReportingPeriodController {

    @Inject
    ReportingPeriodDao reportingPeriodDao;

    @GET
    public List<ReportingPeriod> getAll() {
        List<ReportingPeriod> periods = reportingPeriodDao.getPeriods();
        return periods;
    }

    @PUT
    public ReportingPeriod updateReportingPeriod(ReportingPeriod period) {
        return reportingPeriodDao.save(period);
    }
}
