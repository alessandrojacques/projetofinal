package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author alessandro jacques
 */
public class conectaBD {

    public static Connection conectabd() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/localhost","postgres","tmk9405");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        }
    }
}