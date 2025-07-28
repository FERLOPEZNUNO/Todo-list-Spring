package com.todo.todo.controladores;

//importamos modelo user y el dto correspondiente:
import com.todo.todo.modelos.User;
import com.todo.todo.modelos.Todo;
import com.todo.todo.dto.UserDTO;
import com.todo.todo.dto.UserCreateDTO;
import com.todo.todo.repositorios.UserRepository;

//imports para que Spring inyecte automáticamente un objeto necesario, en este caso los repositorios; el segundo es para importar las anotaciones:
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//más imports: para poder hacer listas (colección):
import java.util.List;
import java.util.stream.Collectors;

//indicamos a spring que esta clase es un controlador rest, y la ruta base para las peticiones que ésta maneja (/api/... por convención):
@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get
    @GetMapping
    public List<UserDTO> getAllUsers(){
        //se convierte la lista de todos los users a una lista de DTOs para devolver sólo los datos que queremos (en este caso, sin pw; ver userDTO):
        return userRepository.findAll().stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }

    //get x id
    @GetMapping("/{id}")
    //@PathVariable es una anotación que se usa para capturar el valor que viene de la url (el id, en este caso):
    public UserDTO getUserById(@PathVariable Long id){
        //se busca el usuario en concreto por id y se guarda en la var "user":
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no encontrado con el id indicado."));
        //se devuelve el user en forma de dto (excluyendo campos no deseados, como pw):
        return UserDTO.fromEntity(user);
    }

    //post
    @PostMapping
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO){
        
        //creamos el nuevo objeto user y le asignamos la info proporcionada:
        User user= userCreateDTO.toEntity();

        User savedUser=userRepository.save(user);
        return UserDTO.fromEntity(savedUser);

    }

    //put - el RequestBody es la nueva info introducida por el usuario:
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO nuevosDatos) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario no encontrado con el ID indicado."));

        user.setName(nuevosDatos.getName());
        user.setUsername(nuevosDatos.getUsername());
        user.setAddress(nuevosDatos.getAddress());

        //igual q ue en el post, se guarda en la BD y en la var savedUser para luego returnearlo:
        User savedUser =userRepository.save(user);
        return UserDTO.fromEntity(savedUser);
    }

    //delete
    @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        //si el user no existe tira error:
        if (user == null){
            return ResponseEntity.notFound().build();
        }

        //si el user tiene todos asignados devuelve alerta
        if (!user.getTodos().isEmpty()) {
            return ResponseEntity.status(409).body("El usuario tiene TODOs asociados. Bórralos primero.");
        }
        
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
}


    
}
