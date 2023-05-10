package utils;

import DTO.PedidoDTO;
import DTO.UsuarioDTO;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author Isaac
 *
 */
public class tiendaSesion {

    // Albustriick
    // Usuario
    public static UsuarioDTO checkUsuario(Object session) {

        Supplier<UsuarioDTO> generarUsuario = UsuarioDTO::new;
        Function<UsuarioDTO, UsuarioDTO> generarUsuario2 = UsuarioDTO::new;
        UsuarioDTO usuario = session == null ? generarUsuario.get() : generarUsuario2.apply((UsuarioDTO) session);
        return usuario;
    }

    // Carrito
    public static PedidoDTO checkCarrito(Object session) {
        PedidoDTO pedido = session == null ? new PedidoDTO() : (PedidoDTO) session;
        return pedido;
    }

}
