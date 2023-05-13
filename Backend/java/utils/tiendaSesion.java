package utils;

import DTO.PedidoDTO;
import DTO.UsuarioDTO;

/**
 *
 * @author Isaac
 *
 */
public class tiendaSesion {

    // Albustriick
    // Usuario
    public static UsuarioDTO checkUsuario(Object session) {

        UsuarioDTO usuario = session == null ? new UsuarioDTO() : (UsuarioDTO) session;
        return usuario;
    }

    // Carrito
    public static PedidoDTO checkCarrito(Object session) {
        PedidoDTO pedido = session == null ? new PedidoDTO() : (PedidoDTO) session;
        return pedido;
    }

}
