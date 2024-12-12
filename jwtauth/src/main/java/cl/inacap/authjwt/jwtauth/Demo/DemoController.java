package cl.inacap.authjwt.jwtauth.Demo; // Declaración del paquete

import cl.inacap.authjwt.jwtauth.User.User; // Importando la clase User
import cl.inacap.authjwt.jwtauth.User.UserRepository; // Importando la interfaz UserRepository
import org.springframework.beans.factory.annotation.Autowired; // Importando Autowired para la inyección de dependencias
import org.springframework.security.core.Authentication; // Importando Authentication para la autenticación
import org.springframework.security.core.context.SecurityContextHolder; // Importando SecurityContextHolder para obtener el contexto de seguridad
import org.springframework.web.bind.annotation.*; // Importando anotaciones de Spring para controladores web

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/user") // Mapea las solicitudes HTTP a /user a este controlador
public class DemoController {
    @Autowired // Inyección de dependencia de UserRepository
    private UserRepository userRepository;

    @GetMapping(value="demo") // Mapea las solicitudes HTTP GET a /user/demo a este método
    public String welcome(){
        return "Bienvenido al endpoint de usuario"; // Devuelve un mensaje de bienvenida
    }

    @GetMapping("/perfil") // Mapea las solicitudes HTTP GET a /user/perfil a este método
    public User getUserProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // Obtiene la autenticación actual
        String username = auth.getName(); // Obtiene el nombre de usuario del contexto de seguridad
        return userRepository.findByUsername(username) // Busca el usuario por nombre de usuario
                .orElseThrow(() -> new RuntimeException("User not found")); // Lanza una excepción si el usuario no se encuentra
    }

    @PutMapping("/perfil") // Mapea las solicitudes HTTP PUT a /user/perfil a este método
    public String updateUserProfile(@RequestBody User updatedUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // Obtiene la autenticación actual
        String username = auth.getName(); // Obtiene el nombre de usuario del contexto de seguridad

        User existingUser = userRepository.findByUsername(username) // Busca el usuario por nombre de usuario
                .orElseThrow(() -> new RuntimeException("User not found")); // Lanza una excepción si el usuario no se encuentra

        existingUser.setPassword(updatedUser.getPassword()); // Actualiza la contraseña del usuario
        userRepository.save(existingUser); // Guarda el usuario actualizado en el repositorio
        return "Profile updated successfully!"; // Devuelve un mensaje de éxito
    }
}