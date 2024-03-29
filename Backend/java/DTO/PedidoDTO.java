package DTO;

import DAO.PedidoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import utils.utils;

/**
 *
 * @author isaac
 */
public class PedidoDTO implements Serializable {

    int codigo;
    UsuarioDTO usuario;
    LocalDateTime fecha;
    String estado;
    LinkedHashMap<ProductoDTO, Integer> productos;

    public PedidoDTO() {
        productos = new LinkedHashMap<ProductoDTO, Integer>();
    }

    public PedidoDTO(int codigo, UsuarioDTO usuario, LocalDateTime fecha, String estado, LinkedHashMap<ProductoDTO, Integer> productos) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.fecha = fecha;
        this.estado = estado;
        this.productos = productos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LinkedHashMap<ProductoDTO, Integer> getProductos() {
        return productos;
    }

    public LinkedHashMap<ProductoDTO, Integer> addLines(ProductoDTO product) {
        if (this.productos.containsKey(product)) {

            int quantity = this.productos.get(product) + 1;
            this.productos.replace(product, quantity);
        } else {
            this.productos.put(product, 1);
        }

        return this.productos;
    }

    public void setProductos(LinkedHashMap<ProductoDTO, Integer> productos) {
        this.productos = productos;
    }

    public double getPrecioTotal() {
        double total = 0;
        for (Map.Entry<ProductoDTO, Integer> producto : productos.entrySet()) {

            ProductoDTO key = producto.getKey();
            int cantidad = producto.getValue();

            total += key.getPrecio() * cantidad;
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double getTotalPriceTax() {
        //return Math.round(getPrecioTotal() * 1.15 * 100.0) / 100.0;
        return utils.round(getPrecioTotal() * 1.5);
    }

    public boolean revisarStock() throws SQLException {
        for (Map.Entry<ProductoDTO, Integer> linea : productos.entrySet()) {

            if (!new PedidoDAO().checkStock(linea.getKey(), linea.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigo;
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
        final PedidoDTO other = (PedidoDTO) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "codigo=" + codigo + ", usuario=" + usuario + ", fecha=" + fecha + ", estado=" + estado + ", productos=" + productos + '}';
    }

}
