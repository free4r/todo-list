package com.company.todo.service;

import com.company.todo.beans.App;
import com.company.todo.beans.Note;
import com.company.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public App findApp(long id) {
        return todoRepository.findApp(id);
    }

    public void addNote(Note note, App app) {
        todoRepository.addNote(note, app);
    }

    public Note updateNote(Note note) {
        return todoRepository.updateNote(note);
    }

    public void removeNote(Note note) {
        todoRepository.removeNote(note);
    }

    public Note findNote(Note note) {
        return todoRepository.findNote(note);
    }

    public Note findNote(long appId, long noteId) {
        return todoRepository.findNote(appId, noteId);
    }
}
