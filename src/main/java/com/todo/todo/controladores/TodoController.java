package com.todo.todo.controladores;

//comentarios explicativos en userController

//aquí se inyectan los 2 modelos, usaremos el user aquí (cada todo pertenece a 1 user):
import com.todo.todo.dto.TodoDTO;
import com.todo.todo.modelos.Todo;
import com.todo.todo.repositorios.TodoRepository;
import com.todo.todo.modelos.User;
import com.todo.todo.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    //get
    @GetMapping
    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(TodoDTO::fromEntity).collect(Collectors.toList());
    }

    //get por id
    @GetMapping("/{id}")
    public TodoDTO getTodoById(@PathVariable Long id) {
        Todo todo=todoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("TODO no encontrado con el ID indicado."));
        return TodoDTO.fromEntity(todo);
    }

    //post
    @PostMapping
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO) {
        //validamos que el usuario asignado a este todo, al crearlo, exista. si no, da error:
        Long userId = todoDTO.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario asociado no encontrado."));
                
        Todo todo=new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setCompleted(todoDTO.getCompleted());
        todo.setUser(user);

        //guardamos y devolvemos el dto:
        Todo savedTodo=todoRepository.save(todo);
        return TodoDTO.fromEntity(savedTodo);
    }

    //put
    @PutMapping("/{id}")
    public TodoDTO updateTodo(@PathVariable Long id, @RequestBody TodoDTO nuevosDatos) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO no encontrado con el ID indicado."));

        todo.setTitle(nuevosDatos.getTitle());
        todo.setCompleted(nuevosDatos.getCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return TodoDTO.fromEntity(savedTodo);
    }

    //borrar
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO no encontrado con el ID indicado."));
        todoRepository.delete(todo);
    }
}
