/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CategoriaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.OptionalInt;

/**
 *
 * @author Isaac
 */
public class CategoriaDAO extends TablaDAO<CategoriaDTO> {

    public CategoriaDAO() {
        this.tabla = "TIENDA_CATEGORIA";
    }

    @Override
    public int actualizar(CategoriaDTO c) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET nombre=? WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, c.getNombre());
        prepared.setInt(2, c.getCodigo());
        return prepared.executeUpdate();

    }

    @Override
    public int anyadir(CategoriaDTO c) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, c.getCodigo());
        prepared.setString(2, c.getNombre());
        return prepared.executeUpdate();

    }

    @Override
    public CategoriaDTO eliminar(CategoriaDTO c) throws SQLException {
        if (c == null) {
            return null;
        } else {
            return eliminar(c.getCodigo()) != null ? c : null;
        }
    }

    @Override
    public boolean existe(CategoriaDTO c) throws SQLException {
        return existe(c.getCodigo());
    }

    public boolean existe(String nombre) throws SQLException {
        return this.getCodigoDe(nombre).isPresent();
    }

    @Override
    public ArrayList<CategoriaDTO> getAll() throws SQLException {
        ArrayList<CategoriaDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            lista.add(new CategoriaDTO(codigo, nombre));
        }

        return lista;
    }

    @Override
    public CategoriaDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            return new CategoriaDTO(codigo, nombre);
        }

        return null;

    }

    public OptionalInt getCodigoDe(String nombre) throws SQLException {
        String sentenciaSQL = "SELECT codigo FROM " + tabla + " WHERE nombre=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, nombre);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            return OptionalInt.of(resultSet.getInt("codigo"));
        }

        return OptionalInt.empty();
    }

}
