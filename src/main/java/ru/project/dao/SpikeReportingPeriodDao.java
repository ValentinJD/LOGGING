package ru.project.dao;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.project.entity.ReportingPeriod;

@Repository
public interface SpikeReportingPeriodDao extends FullEntityRepository<ReportingPeriod, Long> {
}
