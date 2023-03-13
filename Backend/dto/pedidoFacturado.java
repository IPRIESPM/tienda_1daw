package dto;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Isaac Julián
 *
 */
public class pedidoFacturado {

    private int codigo;
    private LocalDate facturado;
    private Direccion direccionEnvio;
    private Direccion direcionFacturacion;
    private LocalDate fechaFacturacion;
    private ArrayList<Producto> productos;

    public pedidoFacturado(int codigo, LocalDate facturado, Direccion direccionEnvio, Direccion direcionFacturacion, LocalDate fechaFacturacion, ArrayList<Producto> productos) {
        this.codigo = codigo;
        this.facturado = facturado;
        this.direccionEnvio = direccionEnvio;
        this.direcionFacturacion = direcionFacturacion;
        this.fechaFacturacion = fechaFacturacion;
        this.productos = productos;
    }

    public LocalDate getFacturado() {
        return facturado;
    }

    public void setFacturado(LocalDate facturado) {
        this.facturado = facturado;
    }

    public Direccion getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Direccion getDirecionFacturacion() {
        return direcionFacturacion;
    }

    public void setDirecionFacturacion(Direccion direcionFacturacion) {
        this.direcionFacturacion = direcionFacturacion;
    }

    public LocalDate getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(LocalDate fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

}
