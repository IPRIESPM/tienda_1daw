package DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author isaac
 */
public class UsuarioDTO implements Serializable {

    int codigo;
    String nombre;
    String apellido;
    String contrasenya;
    LocalDateTime ultimaConexion;
    String telefono;
    LocalDateTime fechaNacimiento;
    String email;
    String foto;
    String tipo;
    DireccionDTO direccion;

    public UsuarioDTO() {
        this.tipo = "GUEST";
        this.direccion = new DireccionDTO();
    }

    public UsuarioDTO(UsuarioDTO usuario) {
        this.codigo = usuario.getCodigo();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.apellido;
        this.contrasenya = usuario.contrasenya;
        this.ultimaConexion = usuario.ultimaConexion;
        this.telefono = usuario.telefono;
        this.fechaNacimiento = usuario.fechaNacimiento;
        this.email = usuario.email;
        this.foto = usuario.foto;
        this.tipo = usuario.tipo;
        this.direccion = usuario.direccion;

    }

    public UsuarioDTO(int codigo, String email, String nombre, String apellido, String contrasenya, LocalDateTime ultimaConexion, String telefono, LocalDateTime fechaNacimiento, String foto, DireccionDTO direccion, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenya = contrasenya;
        this.ultimaConexion = ultimaConexion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.foto = foto;
        this.tipo = tipo;
        this.direccion = direccion;
    }

    public String getFullName() {
        return this.nombre + " " + this.apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public LocalDateTime getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(LocalDateTime ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public boolean isAdmin() {
        return this.tipo.trim().equals("ADMIN");
    }

    public boolean isCliente() {
        return this.tipo.trim().equals("CLIENTE");
    }

    public boolean isGuest() {
        return this.tipo.trim().equals("GUEST");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.apellido);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + Objects.hashCode(this.email);
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", contrase\u00f1a=" + contrasenya + ", ultimaConexion=" + ultimaConexion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", foto=" + foto + ", tipo=" + tipo + ", direccion=" + direccion + '}';
    }

}
