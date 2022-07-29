package ru.project;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "REPORTING_PERIOD")
public class ReportingPeriod {

    public interface Columns {
        String START_DATE = "START_DATE";
        String END_DATE = "END_DATE";
    }

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = Columns.START_DATE)
    private LocalDate startDate;

    @Column(name = Columns.END_DATE)
    private LocalDate endDate;

    public boolean isOldPeriod() {
        return this.id != null;
    }
}
