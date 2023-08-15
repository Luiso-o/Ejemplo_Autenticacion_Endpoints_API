package luis.jwt.security.ejemplo.User;

/**
 * Enumeración que define los roles posibles para los usuarios en la aplicación.
 * Los roles son utilizados para gestionar los niveles de acceso y permisos.
 */
public enum Role {
    /**
     * Rol de administrador con privilegios completos en la aplicación.
     */
    ADMIN,

    /**
     * Rol de usuario normal con acceso básico a la aplicación.
     */
    USER
}
