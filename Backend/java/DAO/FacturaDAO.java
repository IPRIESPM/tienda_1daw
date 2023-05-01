/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FacturaDTO;
import DTO.PedidoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class FacturaDAO extends TablaDAO<FacturaDTO> {

    public FacturaDAO() {
        this.tabla = "TIENDA_FACTURA";
    }

    @Override
    public int actualizar(FacturaDTO f) throws SQLException {
        //No necesario para el proyecto
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(FacturaDTO f) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, f.getCodigo());
        prepared.setInt(2, f.getPedido().getCodigo());

        prepared.setTimestamp(3, Timestamp.valueOf(f.getFecha()));
        return prepared.executeUpdate();

    }

    @Override
    public FacturaDTO eliminar(FacturaDTO f) throws SQLException {
        if (f == null) {
            return null;
        } else {
            return eliminar(f.getCodigo()) != null ? f : null;
        }
    }

    @Override
    public boolean existe(FacturaDTO f) throws SQLException {
        return existe(f.getCodigo());
    }

    @Override
    public ArrayList<FacturaDTO> getAll() throws SQLException {
        ArrayList<FacturaDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            PedidoDTO pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("codigo_pedido"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            lista.add(new FacturaDTO(codigo, pedidoAsociado, fecha));
        }

        return lista;
    }

    @Override
    public FacturaDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            PedidoDTO pedidoAsociado = new PedidoDAO().getByCodigo(resultSet.getInt("pedido"));
            LocalDateTime fecha = resultSet.getTimestamp("fecha").toLocalDateTime();
            return new FacturaDTO(codigo, pedidoAsociado, fecha);
        }

        return null;
    }

}
