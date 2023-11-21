package cs.vsu.ru.KristinaPetrova.repository;

import cs.vsu.ru.KristinaPetrova.models.Identifiable;

import java.util.List;

public interface Repository<T extends Identifiable> {
    void add(T item);
    T getById(int id);
    List<T> getAll();
    void update(int id, T newItem) throws IllegalArgumentException;
    void delete(int id) throws IllegalArgumentException;

    void deleteAll();
}