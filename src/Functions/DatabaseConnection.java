/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_autocare";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){
        try{
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
                return null;
                }
    }
}
