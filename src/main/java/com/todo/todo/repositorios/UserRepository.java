package com.todo.todo.repositorios;

//importamos el model user:
import com.todo.todo.modelos.User;
//importamos la interfaz JPARepository de Spring al proyecto:
import org.springframework.data.jpa.repository.JpaRepository;

//JPArepository ya trae los métodos crud estándar; esto es para añadir consultas personalizadas:
public interface UserRepository extends JpaRepository<User, Long> {
    
}
