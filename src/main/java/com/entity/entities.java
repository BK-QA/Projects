package com.entity;
public class entities {
    private int id;
    private String name ;
    private String todo;
    private String status ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "entities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", todo='" + todo + '\'' +
                ", status='" + status + '\'' +
                '}'+ "\n++++++++++++++++++++++++++++++\n";
    }
}