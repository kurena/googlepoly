/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

/**
 *
 * @author ACER
 */
public class Persona {
    private String Nombre;
    private int posicion;
    private int CantPropiedades;
    private int dinero;
    
    
    public Persona(){
        
    }
    
    public Persona(String Nombre, int posicion, int cantPropiedades, int dinero){
        this.Nombre = Nombre;
        this.posicion= posicion;
        this.CantPropiedades = cantPropiedades;
        this.dinero = dinero;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
    
    public int getPosicion(){
        return this.posicion;
    }
    
    public void setDinero(int dinero){
        this.dinero = dinero;
    }
    
    public int getDinero(){
        return this.dinero;
    }
    
    public void setCantPropiedades(int cant){
        this.CantPropiedades = cant;
    }
    
    public int getCantPropiedades(){
        return this.CantPropiedades;
    }
    
    
}
