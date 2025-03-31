package com.example.week11solution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends SoccerEntity> {
    protected List<T> items;

    // ✅ This is the constructor TeamRepository is calling
    public Repository(List<T> items) {
        this.items = items;
    }

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }

    public List<T> filter(Predicate<T> predicate) {
        return items.stream().filter(predicate).collect(Collectors.toList());
    }
}
