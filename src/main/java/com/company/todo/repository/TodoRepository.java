package com.company.todo.repository;

import com.company.todo.beans.App;
import com.company.todo.beans.Note;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository {
    App findApp(long id);

    void addNote(Note note, App app);

    Note updateNote(Note note);

    void removeNote(Note note);

    Note findNote(Note note);

    Note findNote(long appId, long noteId);
}
