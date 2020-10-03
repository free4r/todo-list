package com.company.todo.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class App {
    private long id;
    private List<Note> notes = new ArrayList<>();

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", notes=" + notes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        App app = (App) o;
        return id == app.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
