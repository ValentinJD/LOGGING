package ru.project.dao;

import org.apache.deltaspike.data.api.AbstractFullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.project.entity.ReportingPeriod;

@Repository
public abstract class SpikeReportingPeriodDao extends AbstractFullEntityRepository<ReportingPeriod, Long> {
}
