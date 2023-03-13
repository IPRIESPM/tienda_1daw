package dto;

/**
 *
 * @author Isaac Julián
 *
 */
public class Categoria {

    private String codigo;
    private String nombre;

    public Categoria(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
