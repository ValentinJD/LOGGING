package ru.project;

public interface BaseEntity<K> {
    K getId();
    void setId(K id);
}
