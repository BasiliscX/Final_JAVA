package com.mavenproyect.database;

import com.mavenproyect.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAO implements DAO<Participante>{
    private static final String SELECT_ONE = "SELECT * FROM participantes WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT * FROM participantes;";
    private static final String INSERT = "INSERT INTO participantes(nombre) VALUES (?);";
    private static final String UPDATE = "UPDATE participantes SET nombre = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM participantes WHERE id = ?;";


    @Override
    public Participante seleccionarUno(int id) {
        Participante participante = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ONE);
            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if(result.next()) {
                participante = resultSetToParticipante(result);
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

        return participante;
    }

    @Override
    public List<Participante> seleccionarTodos() {
        List<Participante> listaParticipantes = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ALL);
            result = stmt.executeQuery();

            while (result.next()) {
                listaParticipantes.add( resultSetToParticipante(result) );
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

        return listaParticipantes;
    }

    @Override
    public boolean insertar(Participante elemento) {
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
    public boolean actualizar(Participante elemento) {
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


    private Participante resultSetToParticipante(ResultSet resultSet)
            throws SQLException {
        Integer id = resultSet.getInt(1);
        String nombre = resultSet.getString(2);

        return new Participante(id, nombre);
    }

    private void fillPreparedStatement(PreparedStatement preparedStatement, Participante participante)
            throws SQLException {
        preparedStatement.setString(1, participante.getNombre());
    }
}
