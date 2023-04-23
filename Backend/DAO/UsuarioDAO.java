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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class UsuarioDAO extends TablaDAO<UsuarioDTO> {

    public UsuarioDAO() {
        this.tabla = "usuario";
    }

    @Override
    public int actualizar(UsuarioDTO u) {
        // NO SE UTILIZA EN NUESTRO PROYECTO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int anyadir(UsuarioDTO u) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?,?,?)";
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
        prepared.setInt(9, u.getDireccion().getCodigo());
        prepared.setString(9, u.getTipo());
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
            int codigo = resultSet.getInt("codigo");
            String email = resultSet.getString("email");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String contrasenya = resultSet.getString("contrasenya");
            Timestamp ultimaConexionTS = resultSet.getTimestamp("ultima_conexion");
            String telefono = resultSet.getString("telefono");
            LocalDate fechaNacimiento = resultSet.getDate("fnacimiento").toLocalDate();
            String foto = resultSet.getString("foto");
            String tipoUsuario = resultSet.getString("tipo");
            int idDireccion = resultSet.getInt("id_direccion");
            DireccionDTO direccion = new DireccionDAO().getByCodigo(idDireccion);
            String tipo = resultSet.getString("tipo");
            LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
            lista.add(new UsuarioDTO(codigo, nombre, apellido, contrasenya, ultimaConexion, telefono, email, tipo, direccion));
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
            String email = resultSet.getString("email");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String contrasenya = resultSet.getString("contrasenya");
            Timestamp ultimaConexionTS = resultSet.getTimestamp("ultima_conexion");
            String telefono = resultSet.getString("telefono");
            LocalDate fechaNacimiento = resultSet.getDate("fnacimiento").toLocalDate();
            String foto = resultSet.getString("foto");
            String tipoUsuario = resultSet.getString("tipo");
            int idDireccion = resultSet.getInt("id_direccion");
            DireccionDTO direccion = new DireccionDAO().getByCodigo(idDireccion);
            String tipo = resultSet.getString("tipo");
            LocalDateTime ultimaConexion = ultimaConexionTS == null ? null : ultimaConexionTS.toLocalDateTime();
            return new UsuarioDTO(codigo, nombre, apellido, contrasenya, ultimaConexion, telefono, email, tipo, direccion);
        }

        return null;
    }

}
