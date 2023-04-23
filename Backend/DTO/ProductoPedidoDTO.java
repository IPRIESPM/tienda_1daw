package DTO;

import java.util.Objects;

/**
 *
 * @author Isaac
 *
 */
public class ProductoPedidoDTO {

    PedidoDTO pedido;
    ProductoDTO producto;
    int canitdad;

    public ProductoPedidoDTO(PedidoDTO pedido, ProductoDTO producto, int canitdad) {
        this.pedido = pedido;
        this.producto = producto;
        this.canitdad = canitdad;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public int getCanitdad() {
        return canitdad;
    }

    public void setCanitdad(int canitdad) {
        this.canitdad = canitdad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.pedido);
        hash = 59 * hash + Objects.hashCode(this.producto);
        hash = 59 * hash + this.canitdad;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoPedidoDTO other = (ProductoPedidoDTO) obj;
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

}
