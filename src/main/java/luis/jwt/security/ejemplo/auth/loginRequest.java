package luis.jwt.security.ejemplo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class loginRequest {
    /**
     * Nombre de usuario proporcionado en la solicitud de inicio de sesión.
     */
    private String username;
    /**
     * Contraseña proporcionada en la solicitud de inicio de sesión.
     */
    private String password;
}
