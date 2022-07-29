package ru.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(exclude = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class ReportingPeriodDTO {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;
}
