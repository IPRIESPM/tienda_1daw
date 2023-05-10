package DAO;

import DTO.CategoriaDTO;
import DTO.ProductoDTO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jmas
 */
public class ProductoDAO extends TablaDAO<ProductoDTO> implements Serializable {

    private static String tablaCodigo = "codigo";
    private static String tablaCategoria = "codigo_categoria";
    private static String tablaNombre = "NOMBRE";
    private static String tablaDescripccion = "descripccion";
    private static String tablaPrecio = "precio";
    private static String tablaStock = "stock";
    private static String tablaImagen = "imagen";

    public ProductoDAO() {
        this.tabla = "TIENDA_PRODUCTO";
    }

    public ArrayList<ProductoDTO> searchProduct(String productName) throws SQLException {
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        // productName = '%' + productName + '%';

        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE " + tablaNombre + " LIKE ? ";
        PreparedStatement prepared = getPrepared(sentenciaSQL);

        prepared.setString(1, productName);

        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            CategoriaDTO categoria = new CategoriaDAO().getByCodigo(resultSet.getInt("categoria"));
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            double precio = resultSet.getDouble("precio");
            int stock = resultSet.getInt("stock");
            String imagen = resultSet.getString("imagen");
            lista.add(new ProductoDTO(codigo, categoria, nombre, descripcion, precio, stock, imagen));
        }
        return lista;
    }

    public ArrayList<ProductoDTO> getAllByCategory(CategoriaDTO categoria) throws SQLException {

        // SELECT * from TIENDA_PRODUCTO WHERE CODIGO_CATEGORIA like 1
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE CODIGO_CATEGORIA LIKE ?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, categoria.getCodigo());
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            double precio = resultSet.getDouble("precio");
            int stock = resultSet.getInt("stock");
            String imagen = resultSet.getString("imagen");
            lista.add(new ProductoDTO(codigo, categoria, nombre, descripcion, precio, stock, imagen));
        }
        return lista;
    }

    @Override
    public int actualizar(ProductoDTO p) throws SQLException {
        String sentenciaSQL = "UPDATE " + tabla + " SET codigo_categoria=?, nombre=?, descripcion=?, precio=?, stock=?, imagen=? WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo());
        prepared.setString(2, p.getNombre());
        prepared.setString(3, p.getDescripccion());
        prepared.setDouble(4, p.getPrecio());
        prepared.setInt(5, p.getStock());
        if (p.getImagen() == null) {
            prepared.setNull(6, java.sql.Types.VARCHAR);
        } else {
            prepared.setString(6, p.getImagen());
        }
        prepared.setInt(7, p.getCodigo());
        int resultado = prepared.executeUpdate();

        return resultado;
    }

    @Override
    public int anyadir(ProductoDTO p) throws SQLException {
        String sentenciaSQL = "INSERT INTO " + tabla + " VALUES(?,?,?,?,?,?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, p.getCodigo());
        prepared.setInt(2, p.getCategoria().getCodigo());
        prepared.setString(3, p.getNombre());
        prepared.setString(4, p.getDescripccion());
        prepared.setDouble(5, p.getPrecio());
        prepared.setInt(6, p.getStock());
        if (p.getImagen() == null) {
            prepared.setNull(6, java.sql.Types.VARCHAR);
        } else {
            prepared.setString(6, p.getImagen());
        }

        int resultado = prepared.executeUpdate();
        return resultado;
    }

    @Override
    public ProductoDTO eliminar(ProductoDTO p) throws SQLException {
        if (p == null) {
            return null;
        } else {
            return eliminar(p.getCodigo()) != null ? p : null;
        }
    }

    @Override
    public boolean existe(ProductoDTO p) throws SQLException {
        return existe(p.getCodigo());
    }

    @Override
    public ArrayList<ProductoDTO> getAll() throws SQLException {
        ArrayList<ProductoDTO> lista = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM " + tabla + " ORDER BY codigo";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            int codigo_categoria = resultSet.getInt("codigo_categoria");
            CategoriaDTO categoria = new CategoriaDAO().getByCodigo(resultSet.getInt("codigo_categoria"));
            String nombre = resultSet.getString("nombre");
            String descripcion = resultSet.getString("descripcion");
            double precio = resultSet.getDouble("precio");

            int stock = resultSet.getInt("stock");

            String imagen = resultSet.getString("imagen");

            lista.add(new ProductoDTO(codigo, categoria, nombre, descripcion, precio, stock, imagen));
        }

        return lista;
    }

    @Override
    public ProductoDTO getByCodigo(int codigo) throws SQLException {
        String sentenciaSQL = "SELECT * FROM " + tabla + " WHERE codigo=?";
        PreparedStatement prepared = getPrepared(sentenciaSQL);
        prepared.setInt(1, codigo);
        ResultSet resultSet = prepared.executeQuery();
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            CategoriaDTO categoria = new CategoriaDAO().getByCodigo(resultSet.getInt("codigo_categoria"));
            String descripcion = resultSet.getString("descripcion");
            double precio = resultSet.getDouble("precio");
            int stock = resultSet.getInt("stock");
            String imagen = resultSet.getString("imagen");

            return new ProductoDTO(codigo, categoria, nombre, descripcion, precio, stock, imagen);
        }

        return null;
    }

}
