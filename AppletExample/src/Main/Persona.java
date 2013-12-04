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

    
    
    public Persona(){
    }
    
    public Persona(String Nombre){
        this.Nombre = Nombre;
    
    }
    
    public void setNombreP(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombreP(){
        return this.Nombre;
    }   
    
}
