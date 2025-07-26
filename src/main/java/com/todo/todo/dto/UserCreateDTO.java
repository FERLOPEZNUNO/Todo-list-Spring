package com.todo.todo.dto;

//DTO para crear un usuario: incluye la pw que el cliente introduce al crearlo

import com.todo.todo.modelos.Address;

public class UserCreateDTO {

    private String name;
    private String username;
    private String password;
    private Address address;

    public UserCreateDTO() {}

    public UserCreateDTO(String name, String username, String password, Address address) {
        this.name=name;
        this.username=username;
        this.password=password;
        this.address=address;
    }

    //getters y setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address=address;
    }

    //para convertir el DTO con los datos introducidos por el cliente a un objeto de tipo User:
    public com.todo.todo.modelos.User toEntity() {
        com.todo.todo.modelos.User user = new com.todo.todo.modelos.User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setAddress(this.address);
        return user;
    }
}
