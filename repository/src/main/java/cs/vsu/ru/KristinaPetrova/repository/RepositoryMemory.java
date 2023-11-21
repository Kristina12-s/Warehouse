package cs.vsu.ru.KristinaPetrova.repository;

import cs.vsu.ru.KristinaPetrova.models.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMemory<T extends Identifiable> implements Repository<T> {
    private final List<T> items;
    private int id = 0;

    public RepositoryMemory() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        if(item.getID() == null) {
            item.setID(id);
        }
        items.add(item);
        id = Math.max(item.getID(), id) + 1;
    }

    public T getById(int id) {
        for (T item : items) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void update(int id, T newItem) {
        newItem.setID(id);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.set(i, newItem);
                return;
            }
        }
        throw new IllegalArgumentException("Object with ID " + id + " not found.");
    }

    public void delete(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == id) {
                items.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Object with ID " + id + " not found.");
    }

    @Override
    public void deleteAll() {
        items.clear();
    }
}