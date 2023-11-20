package com.mavenproyect.database;

import com.mavenproyect.model.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO implements DAO<Equipo> {
    private static final String SELECT_ONE = "SELECT * FROM paises WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT * FROM paises;";
    private static final String INSERT = "INSERT INTO paises(nombre) VALUES (?);";
    private static final String UPDATE = "UPDATE paises SET nombre = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM paises WHERE id = ?;";


    @Override
    public Equipo seleccionarUno(int id) {
        Equipo equipo = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ONE);
            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if(result.next()) {
                equipo = resultSetToEquipo(result);
            }
        } catch (SQLException e) {
            String message = "Error al acceder a la base de datos, " + e.getMessage();

            throw new RuntimeException(message, e);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                String message = "Error al cerrar conexion con la base de datos, " + e.getMessage();

                throw new RuntimeException(message, e);
            }
        }

        return equipo;
    }

    @Override
    public List<Equipo> seleccionarTodos() {
        List<Equipo> listaEquipos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ALL);
            result = stmt.executeQuery();

            while (result.next()) {
                listaEquipos.add( resultSetToEquipo(result) );
            }
        } catch (SQLException e) {
            String message = "Error al acceder a la base de datos, " + e.getMessage();

            throw new RuntimeException(message, e);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                String message = "Error al cerrar conexion con la base de datos, " + e.getMessage();

                throw new RuntimeException(message, e);
            }
        }

        return listaEquipos;
    }

    @Override
    public boolean insertar(Equipo elemento) {
        Integer result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(INSERT);
            fillPreparedStatement(stmt, elemento);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            String message = "Error al acceder a la base de datos, " + e.getMessage();

            throw new RuntimeException(message, e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                String message = "Error al cerrar conexion con la base de datos, " + e.getMessage();

                throw new RuntimeException(message, e);
            }
        }

        return result > 0;
    }

    @Override
    public boolean actualizar(Equipo elemento) {
        Integer result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(UPDATE);

            fillPreparedStatement(stmt, elemento);
            stmt.setInt(2, elemento.getID());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            String message = "Error al acceder a la base de datos, " + e.getMessage();

            throw new RuntimeException(message, e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                String message = "Error al cerrar conexion con la base de datos, " + e.getMessage();

                throw new RuntimeException(message, e);
            }
        }

        return result > 0;
    }

    @Override
    public boolean eliminar(int id) {
        Integer result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            String message = "Error al acceder a la base de datos, " + e.getMessage();

            throw new RuntimeException(message, e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                String message = "Error al cerrar conexion con la base de datos, " + e.getMessage();

                throw new RuntimeException(message, e);
            }
        }

        return result > 0;
    }


    private Equipo resultSetToEquipo(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(1);
        String nombre = resultSet.getString(2);

        return new Equipo(id, nombre);
    }

    private void fillPreparedStatement(PreparedStatement preparedStatement, Equipo equipo)
            throws SQLException {
        preparedStatement.setString(1, equipo.getNombre());
    }


}
