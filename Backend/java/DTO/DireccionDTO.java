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
public class DireccionDTO implements Serializable {

    int codigo;
    String direccion;
    int codigoPostal;
    String ciudad;
    String provincia;

    public DireccionDTO() {
    }

    public DireccionDTO(int codigo, String direccion, int codigoPostal, String ciudad, String provincia) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.direccion);
        hash = 67 * hash + this.codigoPostal;
        hash = 67 * hash + Objects.hashCode(this.ciudad);
        hash = 67 * hash + Objects.hashCode(this.provincia);
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
        final DireccionDTO other = (DireccionDTO) obj;
        if (this.codigoPostal != other.codigoPostal) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        return Objects.equals(this.provincia, other.provincia);
    }

    @Override
    public String toString() {
        return "Direccion{" + "codigo=" + codigo + ", direccion=" + direccion + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", provincia=" + provincia + '}';
    }

}
