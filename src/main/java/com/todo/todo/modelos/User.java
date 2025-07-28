package com.todo.todo.modelos;

import java.util.ArrayList;
import java.util.List;

import com.todo.todo.dto.UserDTO;

//para modelar entidades:
import jakarta.persistence.*;

//como en la clase "todo"
@Entity
@Table(name = "users")
public class User {

    //idem "todo"; atribs. e ID autoincremental:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    //lista de 'todos' de ésta instancia de user. 1 user puede tener muchos todos. el cascade y el orphan removal hacen que, si borras 1 user, tb se borren sus
    //respectivos todos:
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos = new ArrayList<>();

    //le indicamos al programa que el campo address es un objeto dentro de otro (la instancia actual de user):
    @Embedded
    private Address address;

    //getters&setters:

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;

    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

}
