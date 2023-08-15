package luis.jwt.security.ejemplo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    /**
     * Nombre de usuario proporcionado en la solicitud de registro.
     */
    private String username;
    /**
     * Contraseña proporcionada en la solicitud de registro.
     */
    private String password;
    /**
     * Nombre propio del usuario proporcionado en la solicitud de registro.
     */
    private String firstname;
    /**
     * Apellido del usuario proporcionado en la solicitud de registro.
     */
    private String lastname;
    /**
     * País del usuario proporcionado en la solicitud de registro.
     */
    private String country;
}
