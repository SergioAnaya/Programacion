package com.politecnicomalaga.Persistencia.DAO.MYSQL;

import com.politecnicomalaga.Modelo.Paciente;
import com.politecnicomalaga.Persistencia.DAO.PacienteDAO;
import com.politecnicomalaga.Persistencia.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PacienteMYSQL implements PacienteDAO {

    private final static String INSERT = "INSERT INTO Paciente(Id, Nombre, Apellidos, Edad, Genero) VALUES(?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE Paciente SET Nombre = ?, Apellidos = ?, Edad = ?, Genero = ? WHERE Id = ?";
    private final static String DELETE = "DELETE * FROM Paciente WHERE Id = ?";
    private final static String GETALL = "SELECT Id, Nombre, Apellidos, Edad, Genero FROM Paciente";
    private final static String GET = "SELECT Id, Nombre, Apellidos, Edad, Genero FROM Paciente WHERE Id = ?";

    DBConnection dbConnection = new DBConnection();

    private Connection conn;

    public PacienteMYSQL() throws SQLException {
        this.conn = dbConnection.conectar();
    }

    @Override
    public void crear(Paciente paciente) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(INSERT);
            statement.setString(1, paciente.getId());
            statement.setString(2, paciente.getNombre());
            statement.setString(3, paciente.getApellidos());
            statement.setInt(4, paciente.getEdad());
            statement.setString(5, paciente.getGenero());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbConnection.desconectar();
    }

    @Override
    public void modificar(Paciente paciente) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(UPDATE);
            statement.setString(1, paciente.getId());
            statement.setString(2, paciente.getNombre());
            statement.setString(3, paciente.getApellidos());
            statement.setInt(4, paciente.getEdad());
            statement.setString(5, paciente.getGenero());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbConnection.desconectar();
    }

    @Override
    public void eliminar(Paciente paciente) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(DELETE);
            statement.setString(1, paciente.getId());
            if (statement.executeUpdate() == 0) {
                throw new Exception("Puede que no se haya guardado.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbConnection.desconectar();
    }

    public Paciente convertir (ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("Id");
        String nombre = resultSet.getString("Nombre");
        String apellidos = resultSet.getString("Apellidos");
        int edad = resultSet.getInt("Edad");
        String genero = resultSet.getString("Genero");

        Paciente paciente = new Paciente(nombre, apellidos, edad, genero);

        paciente.setId(id);

        return paciente;
    }

    @Override
    public List<Paciente> obtenerTodos() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Paciente> listaPacientes = new LinkedList<>();
        try {
            statement = conn.prepareStatement(GETALL);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listaPacientes.add(convertir(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return listaPacientes;
    }

    @Override
    public Paciente obtener(String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Paciente paciente = null;
        try {
            statement = conn.prepareStatement(GET);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                paciente = convertir(resultSet);
            } else throw new Exception("No se ha encontrado el Paciente");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null || statement != null) {
            dbConnection.desconectar();
        }
        return paciente;
    }
}
