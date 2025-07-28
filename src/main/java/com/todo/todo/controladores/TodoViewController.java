package com.todo.todo.controladores;

import com.todo.todo.modelos.Todo;
import com.todo.todo.modelos.User;
import com.todo.todo.repositorios.TodoRepository;
import com.todo.todo.repositorios.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controlador mvc para servir webs. es equivalente al web.php de laravel

@Controller

//esto son las rutas; es el equivalente al route::get... de php.
//esta es la que actúa cuando vas a la ruta "..../todos". returnea la página listado con los elementos de ordenación, paginación, etc:
@RequestMapping("/todos") 
public class TodoViewController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    //listado de TODOS con paginación, filtro y ordenación:
    @GetMapping
    public String listarTodos(
            @RequestParam(defaultValue = "") String tituloFiltro,
            @RequestParam(defaultValue = "") String usernameFiltro,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        //filtros:
        Page<Todo> todosPage = todoRepository.findByTitleContainingAndUser_UsernameContaining(tituloFiltro, usernameFiltro, pageable);

        model.addAttribute("todosPage", todosPage);
        model.addAttribute("tituloFiltro", tituloFiltro);
        model.addAttribute("usernameFiltro", usernameFiltro);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);

        return "todos/lista"; 
    }

    //form para crear 1 nuevo todo:
    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {

        model.addAttribute("todo", new Todo());

        //para el selector de usuarios en el formulario:
        List<User> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "todos/formulario"; 

    }

    //form para editar todo (ambos llevan a la misma vista):
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO no encontrado con el ID indicado."));
        model.addAttribute("todo", todo);

        List<User> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "todos/formulario";

    }

    //guardar tras crear o editar:
@PostMapping("/guardar")
public String guardarTodo(@ModelAttribute Todo todo, @RequestParam("userId") Long userId) {
    //se busca el user por id y se le asigna el mismo al todo editado/creado:
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
    
    todo.setUser(user);
    
    //guardamos en la BD y volvemos a la pág principal del listado:
    todoRepository.save(todo);
    return "redirect:/todos";
}


    //delete
    @GetMapping("/borrar/{id}")
    public String borrarTodo(@PathVariable Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO no encontrado con el ID indicado."));
        todoRepository.delete(todo);
        return "redirect:/todos";
    }
}
