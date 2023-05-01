/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 *
 * @author Isaac
 */
public class Conexion {

    private static Conexion instancia = null;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
    private final DataSource datasource;
    private final PoolProperties pool;

    public static Conexion getConexion() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    private Conexion() {
        pool = new PoolProperties();
        pool.setUrl(URL);
        pool.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        pool.setUsername("isaac");
        pool.setPassword("isaac");
        pool.setMaxActive(15);
        pool.setMaxIdle(10);
        pool.setMaxWait(5000);
        datasource = new DataSource();
        datasource.setPoolProperties(pool);
    }

    public DataSource getDatasource() {
        return datasource;
    }

}
