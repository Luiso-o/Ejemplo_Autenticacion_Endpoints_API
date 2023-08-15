package luis.jwt.security.ejemplo.auth;

import lombok.RequiredArgsConstructor;
import luis.jwt.security.ejemplo.User.Role;
import luis.jwt.security.ejemplo.User.User;
import luis.jwt.security.ejemplo.User.UserRepository;
import luis.jwt.security.ejemplo.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Realiza el proceso de autenticación de un usuario y genera un token de acceso si las credenciales son válidas.
     *
     * @param request Objeto que contiene el nombre de usuario y la contraseña ingresados por el usuario.
     * @return Un objeto {@link AuthResponse} que contiene el token de acceso generado.
     * @throws AuthenticationException Si las credenciales no son válidas o la autenticación falla.
     */
    public AuthResponse login(loginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * Registra un nuevo usuario en la aplicación.
     *
     * @param request Objeto que contiene los detalles del usuario a registrar.
     * @return Un objeto {@link AuthResponse} que contiene el token de acceso generado para el nuevo usuario.
     */
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
