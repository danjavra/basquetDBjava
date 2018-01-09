/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetApp;

import basquet.Basquet;
import excepciones.MiExcepcion;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;
import modelo.Jugadores;

/**
 *
 * @author DAM
 */
public class BasquetApp {
    
     public static void main(String[] args)  {
        // Necesitamos un objeto de tipo RestaurantDAO
        Basquet basquet = new Basquet();
        System.out.println("Testeando conexión con la base de datos...");
        
        try{
            basquet.conectar();
             System.out.println("Establecida la conexión.");
             Equipo e1 = new Equipo("Warriors", "Golden State",LocalDate.of(1899,06,23));
             System.out.println("Testeando insert equipo " + e1.getNombre());
              try {
                basquet.insertarEquipo(e1);
                System.out.println("Equipo dado de alta");
                } catch (SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                }
             Equipo e2 = new Equipo("Bulls", "Chicago",LocalDate.of(1890,03,17)); 
             System.out.println("Testeando insert equipo " + e2.getNombre());
              try {
                basquet.insertarEquipo(e2);
                System.out.println("Equipo dado de alta");
                } catch (SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                }
             Jugadores j1 = new Jugadores("Angelo", LocalDate.of(1987,01,22), 30, 10, 8, "Base", e1);
             System.out.println("Testeando insert jugadores " + j1.getNombre());
               try {
                basquet.insertarJugadores(j1);
                System.out.println("jugador dado de alta");
                } catch (SQLException | MiExcepcion ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                }
             Jugadores j2 = new Jugadores("Martin", LocalDate.of(1997,04,20), 10, 20, 5, "Alero", e2);
             System.out.println("Testeando insert jugadores " + j2.getNombre());
               try {
                basquet.insertarJugadores(j2);
                System.out.println("jugador dado de alta");
                } catch (SQLException | MiExcepcion ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                }
             System.out.println("Testeando modificar canastas, asistencias y rebotes de jugadores" + j1.getNombre()); 
               try{
                    basquet.modificarCanastas(j1,35);
                    System.out.println("Datos modificados");
                } catch (MiExcepcion | SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
               }
        } catch (SQLException ex) {
            System.out.println("Error al conectar / desconectar: " + ex.getMessage());
        }
     }
}
