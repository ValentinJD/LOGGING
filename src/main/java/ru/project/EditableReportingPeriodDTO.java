package ru.project;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * DTO отчетного периода
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EditableReportingPeriodDTO extends ReportingPeriodDTO{

    /**
     * Флаг возможности редактировать поля startDate и endDate.
     * Запрещено редактировать завершенные отчетные периоды.
     * Завершенные это те у которых endDate < текущей даты
     */
    private Boolean editable = true;

    /**
     * Флаг текущего периода.
     */
    private Boolean current;
}
