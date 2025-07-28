package com.todo.todo.repositorios;

//importamos el model del "todo":
import com.todo.todo.modelos.Todo;
//importamos la interfaz JPARepository de Spring al proyecto:
import org.springframework.data.jpa.repository.JpaRepository;
//paginación:
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//JPArepository ya trae los métodos crud estándar; esto es para añadir consultas personalizadas:
public interface TodoRepository extends JpaRepository<Todo, Long> {

    //este método busca todos los 'todos' cuyo título contenga 'title' y cuyo usuario tenga username que contenga 'username'. "Page" es una "sub-lista" de una lista,
    //sirve para paginar. "Pageable" contiene los datos de la paginación: qué pagina quieres ver, cuántos elementos por pag, orden, etc.
    Page<Todo> findByTitleContainingAndUser_UsernameContaining(String title, String username, Pageable pageable);


}
