/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class conexionsql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5433/CrudTransacciones_Clinica";
    String usuario = "postgres";
    String clave = "Iauzumaki/28";
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    return conn;
    }
}
