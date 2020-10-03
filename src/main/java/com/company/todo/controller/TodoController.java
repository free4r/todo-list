package com.company.todo.controller;

import com.company.todo.beans.Note;
import com.company.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TodoController {

   private TodoService todoService;

    @GetMapping("/note")
    public String index(Model model) {
        model.addAttribute("name", "John Doe");
        return "welcome";
    }

    @GetMapping("/book/{id}/notes")
    public String getNotes(@PathVariable("id") long id, Model model) {
        List<Note> notes = todoService.findApp(id).getNotes();
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/app/1/note/1")
    public String getNote(@PathVariable("appId") long appId, @PathVariable("noteId") long noteId, Model model) {
        Note note = todoService.findNote(appId,noteId);
        model.addAttribute("note", note);
        return "note";
    }
    
    public TodoService getTodoService(){
        return todoService;
    }
    
    public void setTodoService(TodoService service){
        this.todoService = todoService;
    }
}
