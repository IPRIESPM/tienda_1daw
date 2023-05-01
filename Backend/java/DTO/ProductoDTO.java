/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author isaac
 */
public class ProductoDTO implements Serializable {

    int codigo;
    CategoriaDTO categoria;
    String nombre;
    String descripccion;
    double precio;
    int stock;
    String imagen;

    public ProductoDTO(int codigo, CategoriaDTO categoria, String nombre, String descripccion, double precio, int stock, String imagen) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final ProductoDTO other = (ProductoDTO) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "codigo=" + codigo + ", categoria=" + categoria + ", nombre=" + nombre + ", descripccion=" + descripccion + ", precio=" + precio + ", stock=" + stock + ", imagen=" + imagen + '}';
    }

}
