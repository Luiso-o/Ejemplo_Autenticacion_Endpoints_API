package luis.jwt.security.ejemplo.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String username;
    private String lastname;
    private String firstname;
    private String country;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Obtiene las autoridades (roles) asociadas al usuario.
     *
     * @return Una colección de objetos que representan las autoridades del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    /**
     * Indica si la cuenta del usuario no ha expirado.
     *
     * @return true si la cuenta no ha expirado, false si ha expirado.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario no está bloqueada.
     *
     * @return true si la cuenta no está bloqueada, false si está bloqueada.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario (contraseña) no han expirado.
     *
     * @return true si las credenciales no han expirado, false si han expirado.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta de usuario está habilitada.
     *
     * @return true si la cuenta está habilitada, false si está deshabilitada.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
