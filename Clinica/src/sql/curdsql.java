/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import getset.variables;
import getset.variables1;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class curdsql extends conexionsql {
    
    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();
    variables1 var1 = new variables1();
    
    public void insertar(String nombre, String apellido, String ci, String tipo, String especialidad) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into profesional(nombre_profesional,apellido_profesional,ci_profesional,tipo_profesional,especialidad_profesional)"
                    + " values('" + nombre + "','" + apellido + "','" + ci + "','" + tipo + "','" + especialidad + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente! ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo correctamente! " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String id_profesional) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from profesional where id_profesional ='" + id_profesional + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setId_profesional(rs.getString("id_profesional"));
                var.setNombre_profesional(rs.getString("nombre_profesional"));
                var.setApellido_profesional(rs.getString("apellido_profesional"));
                var.setCi_profesional(rs.getString("ci_profesional"));
                var.setTipo_profesional(rs.getString("tipo_profesional"));
                var.setEspecialidad_profesional(rs.getString("especialidad_profesional"));
            } else {
                var.setId_profesional("");
                var.setNombre_profesional("");
                var.setApellido_profesional("");
                var.setCi_profesional("");
                var.setTipo_profesional("");
                var.setEspecialidad_profesional("");
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(String nombre, String apellido, String ci, String tipo, String especialidad, String id_profesional) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update profesional set nombre_profesional='" + nombre + "',apellido_profesional='" + apellido + "',ci_profesional='" + ci + 
                    "',tipo_profesional='" + tipo + "',especialidad_profesional='" + especialidad + "' where id_profesional='" + id_profesional + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String id_profesional) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from profesional where id_profesional='" + id_profesional + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


//Crud Plan    


    public void insertar_plan(String tipo_plan, String precio_plan, String duracion_plan) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into plan(tipo_plan,precio_plan,duracion_plan) values('" + tipo_plan + "','" + precio_plan + "','" + duracion_plan + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente! ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo correctamente! " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar_plan(String id_plan) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from plan where id_plan ='" + id_plan + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var1.setId_plan(rs.getString("id_plan"));
                var1.setTipo_plan(rs.getString("tipo_plan"));
                var1.setPrecio_plan(rs.getString("precio_plan"));
                var1.setDuracion_plan(rs.getString("duracion_plan"));
            } else {
                var1.setId_plan("");
                var1.setTipo_plan("");
                var1.setPrecio_plan("");
                var1.setDuracion_plan("");
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actualizar_plan(String tipo_plan, String precio_plan, String duracion_plan, String id_plan) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update plan set tipo_plan='" + tipo_plan + "',precio_plan='" +precio_plan + "',duracion_plan='" + duracion_plan + 
                    "' where id_plan='" + id_plan + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar_plan(String id_plan) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from plan where id_plan='" + id_plan + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void transaccion1(String id_paciente, String tipo_servicio, String cantidad_servicio, String observaciones_servicio,
            String tratamiento_servicio) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "CALL transaccion_servicio('"+id_paciente+"','"+tipo_servicio+"','"+cantidad_servicio+"','"+observaciones_servicio+"','"
                    +tratamiento_servicio+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void transaccion2(String id_paciente, String id_servicio, String tipo_tratamiento, String fecha_tratamiento,String nombre_tratamiento, String cantidad_tratamiento) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "CALL transaccion_tratamiento('"+id_paciente+"','"+id_servicio+"','"+tipo_tratamiento+"','"+fecha_tratamiento+"','"+nombre_tratamiento+"','"+cantidad_tratamiento+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    

}
