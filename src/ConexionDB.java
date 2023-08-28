
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class ConexionDB {

    String url = "jdbc:mysql://localhost:3306/twitter";
    String user = "root";
    String password = "";

    public void insertarUsuario(String nombre, String contraseña, String correo) {

        String inserccion = "INSERT INTO Usuarios (nombre, contraseña, correo) VALUES (?, ?, ?)";

        try ( Connection connection = DriverManager.getConnection(url, user, password);  
                PreparedStatement preparedStatement = connection.prepareStatement(inserccion)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, contraseña);
            preparedStatement.setString(3, correo);

            preparedStatement.executeUpdate();
            System.out.println("Usuario insertado exitosamente");

        } catch (SQLException e) {
            System.out.println("NO SE PUDO INSERTAR el usuario");
            e.printStackTrace();
        }
    }

    public void insertarTweet(String contenido, String nombreUsuario) {

        String consulta = "SELECT idUsuario FROM usuarios WHERE nombre = ?";
        String inserccion = "INSERT INTO tweets (Mensaje, idUsuario) VALUES (?, ?)";

        try ( Connection connection = DriverManager.getConnection(url, user, password);
                
            PreparedStatement consultaStmt = connection.prepareStatement(consulta);  
            PreparedStatement inserccionStmt = connection.prepareStatement(inserccion)) {

            consultaStmt.setString(1, nombreUsuario);

            ResultSet resultSet = consultaStmt.executeQuery();

            if (resultSet.next()) {
                int idUsuario = resultSet.getInt("idUsuario");

                inserccionStmt.setString(1, contenido);
                inserccionStmt.setInt(2, idUsuario);

                inserccionStmt.executeUpdate();
                System.out.println("Contenido agregado correctamente");
            } else {
                System.out.println("El usuario no existe");
            }
        } catch (SQLException e) {
            System.out.println("no se pudo agregar.ERROR");
            e.printStackTrace();
        }

    }
    
    
    public void consultarTwetts(String nombreUsuario) {
    
    String busqueda = "SELECT idUsuario FROM usuarios WHERE nombre = ?";
    String consulta = "SELECT Mensaje FROM tweets WHERE idUsuario = ?";
    
    try (Connection connection = DriverManager.getConnection(url, user, password);
         PreparedStatement busquedaStmt = connection.prepareStatement(busqueda);
         PreparedStatement consultaStmt = connection.prepareStatement(consulta)) {
        
        busquedaStmt.setString(1, nombreUsuario);
        
        ResultSet busquedaResult = busquedaStmt.executeQuery();
        
        if (busquedaResult.next()) {
            int idUsuario = busquedaResult.getInt("idUsuario");
            
            consultaStmt.setInt(1, idUsuario);
            
            ResultSet consultaResult = consultaStmt.executeQuery();
            
            StringBuilder mensaje = new StringBuilder("Los twetts de " + nombreUsuario + " son :\n");
            
            while (consultaResult.next()) {
                String mensajeTweet = consultaResult.getString("Mensaje");
                mensaje.append(mensajeTweet).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
        
    

}
