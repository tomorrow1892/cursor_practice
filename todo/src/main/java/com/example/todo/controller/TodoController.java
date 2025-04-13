package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todo/list";
    }

    @GetMapping("/new")
    public String newTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo/form";
    }

    @PostMapping
    public String createTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/complete")
    public String completeTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(true);
        todo.setCompletedAt(java.time.LocalDateTime.now());
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }
} 