package com.politecnicomalaga.Persistencia.DAO.MYSQL;

import com.politecnicomalaga.Modelo.HistorialClinico;
import com.politecnicomalaga.Modelo.Medico;
import com.politecnicomalaga.Persistencia.DAO.HistorialClinicoDAO;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class HistorialClinicoMYSQL implements HistorialClinicoDAO {

    private final static String INSERT = "INSERT INTO HistorialClinico(Fecha, IdPaciente, IdMedico, Observacion) VALUES(?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE HistorialClinico SET Fecha = ?, IdPaciente = ?, IdMedico = ?, Observacion = ? WHERE Id = ?";
    private final static String DELETE = "DELETE FROM HistorialClinico WHERE Id = ?";
    private final static String GETALL = "SELECT Cod, Fecha, IdPaciente, IdMedico, Observacion FROM HistorialClinico";
    private final static String GET = "SELECT Cod, Fecha, IdPaciente, IdMedico, Observacion FROM HistorialClinico WHERE Id = ?";

    DBConnection dbConnection = new DBConnection();

    private Connection conn;

    public HistorialClinicoMYSQL(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(HistorialClinico historialClinico) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(INSERT, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, historialClinico.getFecha());
            statement.setString(2, historialClinico.getIdPaciente());
            statement.setString(3, historialClinico.getIdMedico());
            statement.setString(3, historialClinico.getObservacion());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                historialClinico.setCod(resultSet.getString(1));
            } else throw new Exception("No se pudo asignar el COD al Historial Clínico");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
    }

    @Override
    public void modificar(HistorialClinico historialClinico) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, historialClinico.getFecha());
            statement.setString(2, historialClinico.getIdPaciente());
            statement.setString(3, historialClinico.getIdMedico());
            statement.setString(4, historialClinico.getObservacion());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (statement != null) {
            dbConnection.desconectar();
        }
    }

    @Override
    public void eliminar(HistorialClinico historialClinico) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE);
            statement.setString(1, historialClinico.getCod());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (statement != null) {
            dbConnection.desconectar();
        }
    }

    private HistorialClinico convertir (ResultSet resultSet) throws SQLException {
        String cod = resultSet.getString("Cod");
        String fecha = resultSet.getString("Fecha");
        String idPaciente = resultSet.getString("IdPaciente");
        String idMedico = resultSet.getString("IdMedico");
        String observacion = resultSet.getString("Observacion");

        HistorialClinico historialClinico = new HistorialClinico(fecha, idPaciente, idMedico, observacion);

        historialClinico.setCod(cod);

        return historialClinico;
    }

    @Override
    public List<HistorialClinico> obtenerTodos() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HistorialClinico> listaHistorialesClinicos = new LinkedList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaHistorialesClinicos.add(convertir(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return listaHistorialesClinicos;
    }

    @Override
    public HistorialClinico obtener(String cod) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        HistorialClinico historialClinico = null;
        try {
            statement = conn.prepareStatement(GET);
            statement.setString(1, cod);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                historialClinico = convertir(resultSet);
            } else throw new Exception("No se ha encontrado el Historial Clínico");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return historialClinico;
    }

}
