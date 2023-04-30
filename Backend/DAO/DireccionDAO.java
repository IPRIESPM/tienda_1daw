/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DireccionDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class DireccionDAO extends TablaDAO<DireccionDTO> {

    private static String tablaCodigo = "codigo";
    private static String tablaDireccion = "direccion";
    private static String tablaPostal = "codigo_postal";
    private static String tablaProvincia = "provincia";
    private static String tablaCiudad = "ciudad";

    public DireccionDAO() {
        this.tabla = "TIENDA_DIRECCION";
    }

    @Override
    public int actualizar(DireccionDTO d) throws SQLException {
        // NO SE UTILIZA EN NUESTRO PROYECTO
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int anyadir(DireccionDTO d) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, d.getCodigo());
        prepared.setString(2, d.getDireccion());
        prepared.setString(3, d.getCiudad());
        prepared.setString(4, d.getProvincia());
        prepared.setInt(5, d.getCodigoPostal());
        return prepared.executeUpdate();
    }

    @Override
    public DireccionDTO eliminar(DireccionDTO d) throws SQLException {
        if (d == null) {
            return null;
        } else {
            return eliminar(d.getCodigo()) != null ? d : null;
        }
    }

    @Override
    public boolean existe(DireccionDTO d) throws SQLException {
        return existe(d.getCodigo());
    }

    @Override
    public ArrayList<DireccionDTO> getAll() throws SQLException {

        ArrayList<DireccionDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt(tablaCodigo);
            String direccion = resultSet.getString(tablaDireccion);
            int codigoPostal = resultSet.getInt(tablaPostal);
            String ciudad = resultSet.getString(tablaCiudad);
            String provincia = resultSet.getString(tablaProvincia);
            lista.add(new DireccionDTO(codigo, direccion, codigoPostal, ciudad, provincia));
        }
        return lista;
    }

    @Override
    public DireccionDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";;
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String direccion = resultSet.getString("direccion");
            int codigoPostal = resultSet.getInt("codigo_postal");
            String ciudad = resultSet.getString("ciudad");
            String provincia = resultSet.getString("provincia");

            return new DireccionDTO(codigo, direccion, codigoPostal, ciudad, provincia);
        }
        return null;
    }

}
