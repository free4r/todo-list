package com.company.todo.beans;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Note {
    private long id;
    private App app;
    private String title;
    private byte[] image;
    private String text;

    public Note() {
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Note(App app, String title, String text) {
        this.app = app;
        this.title = title;
        this.text = text;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", app=" + app.getId() +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                Objects.equals(app, note.app);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, app);
    }
}
