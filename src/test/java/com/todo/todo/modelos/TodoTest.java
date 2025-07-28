package com.todo.todo.modelos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    //los tests siguen un patrón llamado "arrange-act-assert";este crea un user y un todo, le asigna el segundo
    //al primero y comprueba que todo se haya relacionado correctamente:
    @Test
    public void testTodoConUsuario() {
        
        User user = new User();
        user.setUsername("testuser");
        user.setName("Usuario de prueba");

        Todo todo = new Todo();

        todo.setTitle("TODO con usuario");
        todo.setCompleted(true);
        todo.setUser(user);

        assertEquals("TODO con usuario", todo.getTitle());
        assertTrue(todo.getCompleted());
        assertEquals("testuser", todo.getUser().getUsername());
        assertEquals("Usuario de prueba", todo.getUser().getName());

        System.out.println("Test exitoso");

    }
    

}