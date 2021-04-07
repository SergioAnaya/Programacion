package com.politecnicomalaga.Persistencia.DAO.MYSQL;

import com.politecnicomalaga.Modelo.Medico;
import com.politecnicomalaga.Modelo.Paciente;
import com.politecnicomalaga.Persistencia.DAO.MedicoDAO;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MedicoMYSQL implements MedicoDAO {

    private final static String INSERT = "INSERT INTO Medico(Nombre, Apellidos, Especialidad) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE Medico SET Nombre = ?, Apellidos = ?, Especialidad = ? WHERE Id = ?";
    private final static String DELETE = "DELETE FROM Medico WHERE Id = ?";
    private final static String GETALL = "SELECT Id, Nombre, Apellidos, Especialidad FROM Medico";
    private final static String GET = "SELECT Id, Nombre, Apellidos, Especialidad FROM Medico WHERE Id = ?";

    DBConnection dbConnection = new DBConnection();

    private Connection conn;

    public MedicoMYSQL(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(Medico medico) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(INSERT, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getApellidos());
            statement.setString(3, medico.getEspecialidad());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                medico.setId(resultSet.getString(1));
            } else throw new Exception("No se pudo asignar el ID al Médico");
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
    public void modificar(Medico medico) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getApellidos());
            statement.setString(3, medico.getEspecialidad());
            statement.setString(4, medico.getId());
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
    public void eliminar(Medico medico) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE);
            statement.setString(1, medico.getId());
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

    private Medico convertir (ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("Id");
        String nombre = resultSet.getString("Nombre");
        String apellidos = resultSet.getString("Apellidos");
        String especialidad = resultSet.getString("Especialidad");

        Medico medico = new Medico(nombre, apellidos, especialidad);

        medico.setId(id);

        return medico;
    }

    @Override
    public List<Medico> obtenerTodos() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Medico> listaMedicos = new LinkedList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaMedicos.add(convertir(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return listaMedicos;
    }

    @Override
    public Medico obtener(String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Medico medico = null;
        try {
            statement = conn.prepareStatement(GET);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                medico = convertir(resultSet);
            } else throw new Exception("No se ha encontrado al Médico");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return medico;
    }
}
