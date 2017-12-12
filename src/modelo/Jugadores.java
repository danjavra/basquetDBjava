/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author DAM
 */
public class Jugadores {
    
    private String nombre;
    private LocalDate nacimiento;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private String posicion;
    private Equipo equipo;
    
    public Jugadores(){
        
    }

    public Jugadores(String nombre, LocalDate nacimiento, int canastas, int asistencias, int rebotes, String posicion, Equipo equipo) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugadores{" + "nombre=" + nombre + ", nacimiento=" + nacimiento + ", canastas=" + canastas + ", asistencias=" + asistencias + ", rebotes=" + rebotes + ", posicion=" + posicion + ", equipo=" + equipo + '}';
    }
    
    
}
