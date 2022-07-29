package ru.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * User: KuznetsovD
 * Date: 08.04.2009
 * Time: 13:09:11
 */
@MappedSuperclass
@RootEntity
public abstract class AbstractGenericEntity implements GenericEntity {

    public interface Columns {
        String ID = "ID";
    }

    @Id
    @GeneratedValue(generator = "triggerAssigned")
    @Access(AccessType.PROPERTY)
    @GenericGenerator(name = "triggerAssigned", strategy = "ru.project.config.TriggerAssignedIdentityGenerator")
    @Column(name = Columns.ID)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}