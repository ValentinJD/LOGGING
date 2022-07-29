package ru.project;

import java.util.List;

public interface ReportingPeriodDao {
    List<ReportingPeriod> getPeriods();

    ReportingPeriod save(ReportingPeriod reportingPeriod);
}
