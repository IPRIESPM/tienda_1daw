/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DireccionDTO;
import DTO.UsuarioDTO;
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
public class UsuarioDAO extends TablaDAO<UsuarioDTO> {

    private static String tablaCodigo = "codigo";
    private static String tablaEmail = "email";
    private static String tablaNombre = "nombre";
    private static String tablaApellido = "apellido";
    private static String tablaContrasenya = "contrasenya";
    private static String tablaUltimaConexion = "ultima_conexion";
    private static String tablaTelefono = "telefono";
    private static String tablaFechaNacimiento = "fecha_nacimiento";
    private static String tablaDireccion = "direccion";

    public UsuarioDAO() {
        this.tabla = "TIENDA_USUARIO";
    }

    private UsuarioDTO resulsetGetUser(ResultSet resultSet) throws SQLException {
        int codigo = resultSet.getInt(tablaCodigo);
        String email = resultSet.getString(tablaEmail);
        String nombre = resultSet.getString(tablaNombre);
        String apellido = resultSet.getString(tablaApellido);
        String contrasenya = resultSet.getString(tablaContrasenya);
        Timestamp ultimaConexionTS = resultSet.getTimestamp(tablaUltimaConexion);
        String telefono = resultSet.getString(tablaTelefono);
        Timestamp fechaNacimientoTS = resultSet.getTimestamp(tablaFechaNacimiento);
        String foto = resultSet.getString("foto");
        int idDireccion = resultSet.getInt("direccion");
        DireccionDTO direccion = new DireccionDAO().getByCodigo(idDireccion);
        String tipo = resultSet.getString("tipo");
        LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
        LocalDateTime fechaNacimiento = fechaNacimientoTS == null ? null : fechaNacimientoTS.toLocalDateTime();
        return new UsuarioDTO(codigo, email, nombre, apellido, contrasenya, ultimaConexion, telefono, fechaNacimiento, foto, direccion, tipo);
    }

    public UsuarioDTO comprobarContrasenya(String email, String password) throws SQLException {
        String sentenciaSQL = "select * from TIENDA_USUARIO WHERE EMAIL like ? and CONTRASENYA like ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setString(1, email);
        prepared.setString(2, password);
        ResultSet resultSet = prepared.executeQuery();

        return !resultSet.next() ? new UsuarioDTO() : resulsetGetUser(resultSet);

    }

    @Override
    public int actualizar(UsuarioDTO u) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET ultima_conexion=? WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setTimestamp(1, Timestamp.valueOf(u.getUltimaConexion()));
        prepared.setInt(2, u.getCodigo());
        int resultado = prepared.executeUpdate();
        return resultado;
    }

    @Override
    public int anyadir(UsuarioDTO u) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?.?.?.?,?,?,?,?,?,?)";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, u.getCodigo());
        prepared.setString(2, u.getEmail());
        prepared.setString(3, u.getNombre());
        prepared.setString(4, u.getApellido());
        prepared.setString(5, u.getContrasenya());

        LocalDateTime ultimaConexion = u.getUltimaConexion();
        if (ultimaConexion == null) {
            prepared.setNull(6, java.sql.Types.TIMESTAMP);
        } else {
            prepared.setTimestamp(6, Timestamp.valueOf(ultimaConexion));
        }

        prepared.setString(7, u.getTelefono());
        LocalDateTime fechaNacimiento = u.getFechaNacimiento();
        if (fechaNacimiento == null) {
            prepared.setNull(8, java.sql.Types.TIMESTAMP);
        } else {
            prepared.setTimestamp(8, Timestamp.valueOf(fechaNacimiento));
        }
        prepared.setString(9, u.getFoto());
        prepared.setInt(10, u.getDireccion().getCodigo());
        prepared.setString(11, u.getTipo());
        return prepared.executeUpdate();

    }

    @Override
    public UsuarioDTO eliminar(UsuarioDTO u) throws SQLException {
        if (u == null) {
            return null;
        } else {
            return eliminar(u.getCodigo()) != null ? u : null;
        }
    }

    @Override
    public boolean existe(UsuarioDTO u) throws SQLException {
        return existe(u.getCodigo());
    }

    @Override
    public ArrayList<UsuarioDTO> getAll() throws SQLException {
        ArrayList<UsuarioDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {

            lista.add(resulsetGetUser(resultSet));
        }

        return lista;
    }

    @Override
    public UsuarioDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            return resulsetGetUser(resultSet);
        }

        return null;
    }

}
