package ru.project;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ReportingPeriodDao extends FullEntityRepository<ReportingPeriod, Long> {
}
