package com.mavenproyect.database;

import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Partido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO implements DAO<Partido>{
    private static final String SELECT_ONE = "SELECT * FROM resultados WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT * FROM resultados;";
    private static final String INSERT = "INSERT INTO resultados(grupo, equipo_1, cantidad_goles_1, equipo_2, cantidad_goles_2) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE resultados SET grupo = ?, equipo_1 = ?, cantidad_goles_1 = ?, equipo_2 = ?, cantidad_goles_2 = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM resultados WHERE id = ?;";
    private EquipoDAO equipoDAO;

    public PartidoDAO(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }

    @Override
    public Partido seleccionarUno(int id) {
        Partido partido = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ONE);
            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if(result.next()) {
                partido = resultSetToPartido(result);
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

        return partido;
    }

    @Override
    public List<Partido> seleccionarTodos() {
        List<Partido> listaPartidos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ALL);
            result = stmt.executeQuery();

            while (result.next()) {
                listaPartidos.add( resultSetToPartido(result) );
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

        return listaPartidos;
    }

    @Override
    public boolean insertar(Partido elemento) {
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
    public boolean actualizar(Partido elemento) {
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


    private Partido resultSetToPartido(ResultSet resultSet)
            throws SQLException {
        Integer id = resultSet.getInt(1);
        Character grupo = resultSet.getString(2).charAt(0);
        Integer idEquipo1 = resultSet.getInt(3);
        Integer cantidadGolesEquipo1 = resultSet.getInt(4);
        Integer idEquipo2 = resultSet.getInt(5);
        Integer cantidadGolesEquipo2 = resultSet.getInt(6);

        Equipo equipo1 = equipoDAO.seleccionarUno(idEquipo1);
        Equipo equipo2 = equipoDAO.seleccionarUno(idEquipo2);

        return new Partido(id, grupo, equipo1, cantidadGolesEquipo1, equipo2, cantidadGolesEquipo2);
    }

    private void fillPreparedStatement(PreparedStatement preparedStatement, Partido partido)
            throws SQLException {
        preparedStatement.setString(1, String.valueOf(partido.getGrupo()));
        preparedStatement.setInt(2, partido.getEquipo1().getID());
        preparedStatement.setInt(3, partido.getGolesEquipo1());
        preparedStatement.setInt(4, partido.getEquipo2().getID());
        preparedStatement.setInt(5, partido.getGolesEquipo2());
    }

}
