package ru.project.entity;

public interface BaseEntity<K> {
    K getId();
    void setId(K id);
}
