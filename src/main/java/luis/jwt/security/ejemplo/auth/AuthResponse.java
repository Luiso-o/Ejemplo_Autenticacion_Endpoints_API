package luis.jwt.security.ejemplo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    //token de acceso en respuesta de la autenticación correcta
    private String token;
}
