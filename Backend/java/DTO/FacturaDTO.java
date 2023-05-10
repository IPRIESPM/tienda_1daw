/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author isaac
 */
public class FacturaDTO implements Serializable {

    int codigo;
    PedidoDTO pedido;
    LocalDateTime fecha;

    public FacturaDTO() {
        this.pedido = new PedidoDTO();

    }

    public FacturaDTO(int codigo, PedidoDTO pedido, LocalDateTime fecha) {
        this.codigo = codigo;
        this.pedido = pedido;
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.codigo;
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
        final FacturaDTO other = (FacturaDTO) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "FacturaDTO{" + "codigo=" + codigo + ", pedido=" + pedido + ", fecha=" + fecha + '}';
    }

}
