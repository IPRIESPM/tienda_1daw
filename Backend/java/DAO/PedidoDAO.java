/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PedidoDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Isaac
 */
public class PedidoDAO extends TablaDAO<PedidoDTO> implements Serializable {

    public PedidoDAO() {
        this.tabla = "TIENDA_PEDIDO";
    }

    public ArrayList<PedidoDTO> getByUser(UsuarioDTO user) throws SQLException {
        int userCode = user.getCodigo();
        ArrayList<PedidoDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo_usuario=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, userCode);
        ResultSet resultSet = prepared.executeQuery();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            String estado = resultSet.getString("estado");
            LinkedHashMap<ProductoDTO, Integer> productos = new PedidoDAO().getLineas(codigo);
            lista.add(new PedidoDTO(codigo, user, fecha, estado, productos));
        }

        return lista;
    }

    public int actualizar(PedidoDAO p) throws SQLException {
        //No necesario para el proyecto
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int anyadir(PedidoDTO p) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?)";

        // añadir una nueva función que nos de la ultima id
        // SELECT * from TIENDA_PEDIDO order by codigo DESC
        p.setCodigo(this.siguienteCodigo());
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo()); //funct() ultima id +1
        prepared.setInt(2, p.getUsuario().getCodigo());
        prepared.setTimestamp(3, Timestamp.valueOf(p.getFecha()));
        prepared.setString(4, p.getEstado());
        int resultado = prepared.executeUpdate();

        anyadirLineas(p);
        return resultado;
    }

    public PedidoDTO eliminar(PedidoDTO p) throws SQLException {
        if (p == null) {
            return null;
        } else {
            return eliminar(p.getCodigo()) != null ? p : null;
        }
    }

    public boolean existe(PedidoDTO p) throws SQLException {
        return existe(p.getCodigo());
    }

    public ArrayList<PedidoDTO> getAll() throws SQLException {
        ArrayList<PedidoDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            UsuarioDTO usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            String estado = resultSet.getString("estado");
            LinkedHashMap<ProductoDTO, Integer> productos = getLineas(codigo);
            lista.add(new PedidoDTO(codigo, usuario, fecha, estado, productos));
        }

        return lista;
    }

    public PedidoDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            UsuarioDTO usuario = new UsuarioDAO().getByCodigo(resultSet.getInt("codigo_usuario"));
            String estado = resultSet.getString("estado");
            LinkedHashMap<ProductoDTO, Integer> productos = getLineas(codigo);
            return new PedidoDTO(codigo, usuario, fecha, estado, productos);
        }

        return null;
    }

    public LinkedHashMap<ProductoDTO, Integer> getLineas(int codPedido) throws SQLException {

        LinkedHashMap<ProductoDTO, Integer> lineas = new LinkedHashMap<>();
        String sentenciaSQL = "SELECT * FROM PEDIDO_PRODUCTO WHERE codigo_pedido = ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codPedido);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            ProductoDTO producto = new ProductoDAO().getByCodigo(resultSet.getInt("codigo_producto"));
            int cantidad = resultSet.getInt("cantidad");
            lineas.put(producto, cantidad);
        }

        return lineas;

    }

    private void anyadirLineas(PedidoDTO p) throws SQLException {
        for (Map.Entry<ProductoDTO, Integer> entry : p.getProductos().entrySet()) {
            String sentenciaSQL = "INSERT INTO PEDIDO_PRODUCTO VALUES(?, ?, ?)";
            PreparedStatement prepared = getPrepared(sentenciaSQL);
            prepared.setInt(1, p.getCodigo());
            prepared.setInt(2, entry.getKey().getCodigo());
            prepared.setInt(3, entry.getValue());
            prepared.executeUpdate();
        }
    }

    private void eliminarLineas(PedidoDTO p) throws SQLException {
        String sentenciaSQL = "DELETE FROM PEDIDO_PRODUCTO WHERE codigo_pedido=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo());
        prepared.executeUpdate();

    }

    @Override
    public int actualizar(PedidoDTO objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
