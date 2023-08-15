package luis.jwt.security.ejemplo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario a buscar.
     * @return Un Optional que puede contener al usuario si se encuentra, o estar vacío si no se encuentra.
     */
    Optional<User> findByUsername(String username);
}
