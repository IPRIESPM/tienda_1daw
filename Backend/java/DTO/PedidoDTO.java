/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public void setProductos(LinkedHashMap<ProductoDTO, Integer> productos) {
        this.productos = productos;
    }

    public double getPrecioTotal() {
        double total = 0;
        for (Map.Entry<ProductoDTO, Integer> producto : productos.entrySet()) {

            ProductoDTO key = producto.getKey();
            int value = producto.getValue();

            total += key.getPrecio() * value;
        }
        return total;
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
