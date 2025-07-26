package com.todo.todo.modelos;

//para modelar entidades:
import jakarta.persistence.*;
//para las validaciones:
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//entity le dice a java que esta clase es una entidad para mapearla a BBDD; table es para indicar el nombre en la BD:
@Entity
@Table(name = "todos")

public class Todo {

    //atributos
    //con @id indicamos que es una clave primaria, con @GeneratedValue(strategy... etc) hacemos el id autoincremental:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //validaciones para el title del todo; no puede estar vacío y el tamaño max. es de 200 chars (tanto en el programa con en la BD):
    @NotBlank (message="El título no puede estar vacío.")
    @Size(max = 200, message = "El título no puede tener más de 200 caracteres.")
    @Column(length = 200) 
    private String title;
    private boolean completed;

    //cone sto le indicamos a java que cada user puede tener muchos 'todo', pero que cada 'todo' pertenece a 1 user:
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //getters y setters:

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed= completed;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}
