package com.bavel22.todo.controller;

import com.bavel22.todo.model.Todo;
import com.bavel22.todo.service.TodoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<Long> create(@RequestBody Todo todo) {

        Todo newTodo = todoService.create(todo);



        return new ResponseEntity<>(newTodo.getId(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<List> getTodos() {

        HttpHeaders headers = new HttpHeaders();

        headers.add("Access-Control-Allow-Origin", "*");


        List<Todo> beans =
                new ArrayList<Todo>(todoService.getTodos().values());

        return new ResponseEntity<>(beans, headers ,HttpStatus.OK);

           // return ResponseEntity.ok(beans);

      //  String name = "hello";

      // return ResponseEntity.ok(todoService.getTodos());



    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {

        Todo todo = todoService.get(id);

        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(todo);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Todo> putTodo(@PathVariable Long id, @RequestBody Todo todo) {


        Todo updatedTodo = todoService.get(id);

        updatedTodo.setName(todo.getName());
        updatedTodo.setDescription(todo.getDescription());





        if (updatedTodo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updatedTodo);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
        public Todo deleteTodo(@PathVariable Long id) {

        Todo todo = todoService.delete(id);



        return todo;
    }

}