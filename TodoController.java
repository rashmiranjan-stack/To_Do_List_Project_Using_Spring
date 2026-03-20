package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {

    List<Todo> list = new ArrayList<>();

    public TodoController() {
        list.add(new Todo(1, "Learn Spring Boot", "Pending"));
        list.add(new Todo(2, "Do Assignment", "Completed"));
        list.add(new Todo(3, "Practice Java", "Pending"));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return list;
    }

    @PostMapping("/todos")
    public String addTodo(@RequestBody Todo todo) {
        list.add(todo);
        return "Todo Added Successfully";
    }

    @GetMapping("/status/pending")
    public List<Todo> getPendingTasks() {
        List<Todo> pendingList = new ArrayList<>();

        for (Todo t : list) {
            if (t.getStatus().equalsIgnoreCase("Pending")) {
                pendingList.add(t);
            }
        }

        return pendingList;
    }
    
    @GetMapping("/status/completed")
    public List<Todo> getCompletedTasks() {
        List<Todo> completedList = new ArrayList<>();

        for (Todo t : list) {
            if (t.getStatus().equalsIgnoreCase("Completed")) {
                completedList.add(t);
            }
        }

        return completedList;
    }
}