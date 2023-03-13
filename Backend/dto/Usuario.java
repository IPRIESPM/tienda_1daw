package dto;

import java.time.LocalDate;

/**
 *
 * @author Isaac Julián
 *
 */
public class Usuario {

    private int codigo;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String fotoPath;
    private String password;

    private TipoUsuario tipo;
    private LocalDate ultimaConexion;

    public Usuario(int codigo, String nombre, String apellidos, String email, LocalDate fechaNacimiento, String password, TipoUsuario tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.tipo = tipo;
        this.ultimaConexion = LocalDate.now();
    }

    public Usuario(int codigo, String nombre, String apellidos, String email, String telefono, LocalDate fechaNacimiento, String fotoPath, String password, TipoUsuario tipo) {
        this(codigo, nombre, apellidos, email, fechaNacimiento, password, tipo);
        this.telefono = telefono;
        this.fotoPath = fotoPath;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", fotoPath=" + fotoPath + ", tipo=" + tipo + ", ultimaConexion=" + ultimaConexion + '}';
    }

}
