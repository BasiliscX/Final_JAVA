package com.mavenproyect.database;

import com.mavenproyect.model.Equipo;
import com.mavenproyect.model.Participante;
import com.mavenproyect.model.Partido;
import com.mavenproyect.model.Pronostico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PronosticoDAO implements DAO<Pronostico>{
    private static final String SELECT_ONE = "SELECT * FROM pronosticos WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT * FROM pronosticos;";
    private static final String INSERT = "INSERT INTO pronosticos(id_participante, id_resultado, id_equipo, opcion_G_E_P) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE pronosticos SET id_participante = ?, id_resultado = ?, id_equipo = ?, opcion_G_E_P = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM pronosticos WHERE id = ?;";
    private ParticipanteDAO participanteDAO;
    private PartidoDAO partidoDAO;
    private EquipoDAO equipoDAO;

    public PronosticoDAO(ParticipanteDAO participanteDAO, PartidoDAO partidoDAO, EquipoDAO equipoDAO) {
        this.participanteDAO = participanteDAO;
        this.partidoDAO = partidoDAO;
        this.equipoDAO = equipoDAO;
    }

    @Override
    public Pronostico seleccionarUno(int id) {
        Pronostico pronostico = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ONE);
            stmt.setInt(1, id);

            result = stmt.executeQuery();

            if(result.next()) {
                pronostico = resultSetToPronostico(result);
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

        return pronostico;
    }

    @Override
    public List<Pronostico> seleccionarTodos() {
        List<Pronostico> listaPronosticos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SELECT_ALL);
            result = stmt.executeQuery();

            while (result.next()) {
                listaPronosticos.add( resultSetToPronostico(result) );
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

        return listaPronosticos;
    }

    @Override
    public boolean insertar(Pronostico elemento) {
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
    public boolean actualizar(Pronostico elemento) {
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


    private Pronostico resultSetToPronostico(ResultSet resultSet)
            throws SQLException {
        Integer id = resultSet.getInt(1);
        Integer idParticipante = resultSet.getInt(2);
        Integer idPartido = resultSet.getInt(3);
        Integer idEquipo = resultSet.getInt(4);
        Character resultado = resultSet.getString(5).charAt(0);

        Participante participante = participanteDAO.seleccionarUno(idParticipante);
        Partido partido = partidoDAO.seleccionarUno(idPartido);
        Equipo equipo = equipoDAO.seleccionarUno(idEquipo);

        return new Pronostico(id, participante, partido, equipo, resultado);
    }

    private void fillPreparedStatement(PreparedStatement preparedStatement, Pronostico pronostico)
            throws SQLException {
        preparedStatement.setInt(1, pronostico.getParticipante().getID());
        preparedStatement.setInt(2, pronostico.getPartido().getID());
        preparedStatement.setInt(3, pronostico.getEquipo().getID());
        preparedStatement.setString(4, String.valueOf( pronostico.getOpcion() ));
    }

}
