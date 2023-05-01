package utils;

import DTO.UsuarioDTO;

/**
 *
 * @author Isaac
 *
 */
public class tiendaSesion {

    // Albustriick
    public static UsuarioDTO usuario(Object session) {
        UsuarioDTO usuario = session == null ? new UsuarioDTO() : (UsuarioDTO) session;

        return usuario;
    }

}
