package com.company.todo.repository;

import com.company.todo.beans.App;
import com.company.todo.beans.Note;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class TodoTestRepository implements TodoRepository {

    private List<App> appList;

//    @PostConstruct
    public void init() {
        appList = new ArrayList<>();
        App app1 = new App();
        app1.setId(1);
        app1.getNotes().add(new Note(1,app1, "title11", "Text..."));
        app1.getNotes().add(new Note(2,app1, "title12", "Text..."));
        app1.getNotes().add(new Note(3,app1, "title13", "Text..."));

        App app2 = new App();
        app2.setId(2);
        app2.getNotes().add(new Note(1,app2, "title21", "Text..."));
        app2.getNotes().add(new Note(2,app2, "title22", "Text..."));
        app2.getNotes().add(new Note(3,app2, "title23", "Text..."));

        App app3 = new App();
        app3.setId(3);
        app3.getNotes().add(new Note(1 ,app3, "title31", "Text..."));
        app3.getNotes().add(new Note(2 ,app3, "title32", "Text..."));
        app3.getNotes().add(new Note(3 ,app3, "title33", "Text..."));

        appList.add(app1);
        appList.add(app2);
        appList.add(app3);
    }


    @Override
    public App findApp(long id) {
        return appList.stream().
                filter(current -> {
                    return current.getId() == id;
                }).
                findFirst().get();
    }

    @Override
    public void addNote(Note note, App app) {
        appList.forEach(current -> {
            if (current.getId() == app.getId()) {
                current.getNotes().add(note);
            }
        });
    }

    @Override
    public Note updateNote(Note note) {
        Note result = findNote(note);
        Objects.requireNonNull(result);
        result.setId(note.getId());
        return result;
    }

    @Override
    public void removeNote(Note note) {
        findApp(note.getApp().getId()).getNotes().remove(note);

    }

    @Override
    public Note findNote(Note note) {
        return findApp(note.getApp().getId()).getNotes().stream()
                .filter(current -> current.getId() == note.getId()).findFirst().get();

    }

    @Override
    public Note findNote(long appId, long noteId) {
        return findApp(appId).getNotes().stream().
                filter(current -> {
                    return current.getId() == noteId;
                }).
                findFirst().get();
    }
}
