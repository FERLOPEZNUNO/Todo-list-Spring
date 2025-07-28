package com.todo.todo.dto;

import com.todo.todo.modelos.Address;


//DTO para MOSTRAR datos a usuarios. no incluye la contraseña como campo, ésta solo sale en el createDTO: el cliente envía la pw al crear un user nuevo,
//pero no se muestra cuando se hace un get de usuarios.

public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private Address address;

    public UserDTO() {}

    public UserDTO(Long id, String name, String username, Address address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
    }

    //getters y setters:

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
    this.address = address;

    }

    //para convertir 1 entidad a DTO:
    public static UserDTO fromEntity(com.todo.todo.modelos.User user) {
        return new UserDTO(user.getId(), user.getName(), user.getUsername(), user.getAddress());
    }
}
