package com.mavenproyect.database;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class Conexion {
    private static final String USER = "root"; // TODO: Reemplazar con nombre del usuario
    private static final String PASSWORD = "1234"; // TODO: Reemplazar con contrasena del usuario
    private static final String DATABASE = "pronosticos_db";
    private static final String DDBB_URL = String.format(
            "jdbc:mysql://%s:%s@localhost:3306/%s?useSSL=false", USER, PASSWORD, DATABASE);

    private static BasicDataSource dataSource;

    /**
     * Devuelve el datasource estatico de la clase.
     *
     * @return DataSource   data source existente, o uno creado si no existia anteriormente.
     */
    private static BasicDataSource getDataSource(){
        if(Conexion.dataSource == null){
            Conexion.dataSource = new BasicDataSource();

            Conexion.dataSource.setUrl(DDBB_URL);
            Conexion.dataSource.setInitialSize(50);
        }

        return Conexion.dataSource;
    }

    /**
     * Devuelve una conexion del data source.
     *
     * @return Conexion del data source.
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


}