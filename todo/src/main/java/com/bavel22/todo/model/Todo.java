package com.bavel22.todo.model;

import java.util.Objects;

public class Todo {

    private Long id = 0L;
    private String name = "";
    private String description = "";

    private boolean complete = false;

    private State state;

    public Todo() {

    }

    public Todo(String name, String description, Long id, boolean complete) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.state = State.NEW;
        this.complete = complete;
    }




    public Todo(String name, String description) {

        this.name = name;
        this.description = description;
        this.state = State.NEW;
        this.complete = false;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean getComplete() {
        return complete;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name1='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
