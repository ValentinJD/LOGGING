package ru.project.dao;

import org.apache.deltaspike.data.api.AbstractFullEntityRepository;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.project.entity.ReportingPeriod;

import javax.transaction.Transactional;


@Repository
public interface SpikeReportingPeriodDao extends EntityRepository<ReportingPeriod, Long> {
}
