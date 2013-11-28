/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Main {
    
    public Main() {
        
    }
    
    public void createGame(){
        Propiedades arregloPropiedadades[] = new Propiedades[16];
        arregloPropiedadades[0] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[1] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[2] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[3] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[4] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[5] = new Propiedades(0, "", 380,595,0,0,35,10,"Blogspot", "PROPIEDAD");
        
        Persona persona[] = new Persona[2];
        persona[0]= new Persona("",0,0,1500);
        persona[1]= new Persona("",0,0,1500);
        askNames(persona);   
    }
    
    public void askNames(Persona persona[]){
       String nombre = JOptionPane.showInputDialog("Digite el nombre del jugador 1");
       String nombre2 = JOptionPane.showInputDialog("Digite el nombre del jugador 2");
       setName(persona, nombre,nombre2);
    }
    
    public void setName(Persona persona[],String Nombre,String Nombre2){
       persona[0].setNombre(Nombre);
       persona[1].setNombre(Nombre2);
    }
    
    public void alertName(Persona persona[]){
        JOptionPane.showMessageDialog(null,"Nombre 1: "+persona[0].getNombre());
        JOptionPane.showMessageDialog(null,"Nombre 2: "+persona[1].getNombre());
    }
}
