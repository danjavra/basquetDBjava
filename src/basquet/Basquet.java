/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet;

import excepciones.MiExcepcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import modelo.Equipo;
import modelo.Jugadores;

/**
 *
 * @author DAM
 */
public class Basquet {
private Connection conexion;
    /**
     * @param args the command line arguments
     */
    public void insertarEquipo (Equipo e) throws SQLException {
        // Definimos la consulta
        String insert = "insert into team values (?, ?, ?)";
        // Necesitamos preparar la consulta parametrizada
        PreparedStatement ps = conexion.prepareStatement(insert); 
        // Le damos valor a los interrogantes
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getCiudad());
        ps.setDate(3, Date.valueOf(e.getCreacion()));
         // Ejecutamos la consulta
        ps.executeUpdate();
        // cerramos recursos
        ps.close();
    }
    
    public void insertarJugadores (Jugadores j) throws SQLException, MiExcepcion {
      if (existeJugador(j)){
          throw new MiExcepcion("Ya existe un jugador con ese nombre");
      } else { 
        // Definimos la consulta
        String insert = "insert into player values (?, ?, ?, ?, ?, ?, ?)";
        // Necesitamos preparar la consulta parametrizada
        PreparedStatement ps = conexion.prepareStatement(insert); 
        // Le damos valor a los interrogantes
        ps.setString(1, j.getNombre());
        ps.setDate(2, Date.valueOf(j.getNacimiento()));
        ps.setInt(3, j.getCanastas());
        ps.setInt(4, j.getAsistencias());
        ps.setInt(5, j.getRebotes());
        ps.setString(6, j.getPosicion());
        ps.setString(7, j.getEquipo().getNombre());
        
        ps.executeUpdate();
        ps.close();
      }
    }
    
    private boolean existeJugador(Jugadores j) throws SQLException {
        String select = "select * from player where name='" + j.getNombre() + "'";
        Statement st = conexion.createStatement();
        boolean existe = false;
        ResultSet rs = st.executeQuery(select);
        if (rs.next()) {
            existe = true;
        }
        rs.close();
        st.close();
        return existe;
    }

    
      public void modificarCanastas(Jugadores j, int valor) throws SQLException, MiExcepcion {
         if(!existeJugador(j)){
             throw new MiExcepcion("ERROR: No existe un jugador con ese nombre");
         }
         String update = "update from player set nbaskets=? where name='" + j.getNombre() + "'";
         PreparedStatement ps = conexion.prepareStatement(update); 
        // Le damos valor a los interrogantes
        //ps.setString(2, j.getNombre());
        ps.setInt(1, j.getCanastas());
        ps.executeUpdate();
        ps.close();
    } 
    
      public void modificarAsistensias(Jugadores j) throws SQLException, MiExcepcion {
         if(!existeJugador(j)){
             throw new MiExcepcion("ERROR: No existe un jugador con ese nombre");
         }
         String update = "update from player set nassists=? where nombre='" + j.getNombre() + "'";
         PreparedStatement ps = conexion.prepareStatement(update); 
        // Le damos valor a los interrogantes
       
        ps.setInt(4, j.getAsistencias());
        ps.executeUpdate();
        ps.close();
    } 
      
      public void modificarRebotes(Jugadores j, int valor) throws SQLException, MiExcepcion {
         if(!existeJugador(j)){
             throw new MiExcepcion("ERROR: No existe un jugador con ese nombre");
         }
         String update = "update from player set nrebounds=? where nombre='" + j.getNombre() + "'";
         PreparedStatement ps = conexion.prepareStatement(update); 
        // Le damos valor a los interrogantes
       
        ps.setInt(5, j.getRebotes());
        ps.executeUpdate();
        ps.close();
    } 
    
     public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/basket";
        String user = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
