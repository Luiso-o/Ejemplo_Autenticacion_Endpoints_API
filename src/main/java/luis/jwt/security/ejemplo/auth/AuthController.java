package luis.jwt.security.ejemplo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Maneja las solicitudes de autenticación de usuarios.
     *
     * @param request Objeto loginRequest que contiene las credenciales del usuario.
     * @return ResponseEntity con el resultado de la autenticación en el cuerpo de la respuesta.
     */
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody loginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Maneja las solicitudes de registro de usuarios.
     *
     * @param request Objeto RegisterRequest que contiene los detalles del nuevo usuario.
     * @return ResponseEntity con el resultado del registro en el cuerpo de la respuesta.
     */
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }


}
