package ru.project.dao;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.project.entity.ReportingPeriod;


@Repository
public interface SpikeReportingPeriodDao extends EntityRepository<ReportingPeriod, Long> {
}
