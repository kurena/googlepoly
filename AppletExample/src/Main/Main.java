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
    //Variable privada de tipo persona
    private Persona persona[] = new Persona[2];
    private Propiedades arregloPropiedadades[] = new Propiedades[30];
    private boolean ganador = false;
    public Main() {
        
    }
    
    public void createGame(){
        arregloPropiedadades[0] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[1] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[2] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[3] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[4] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[5] = new Propiedades(0, "", 380,595,0,0,35,10,"Blogspot", "PROPIEDAD");
        arregloPropiedadades[6] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[7] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[8] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[9] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[10] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[11] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[12] = new Propiedades(0, "", 380,595,0,0,35,10,"Blogspot", "PROPIEDAD");
        arregloPropiedadades[13] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[14] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[15] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[16] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[17] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[18] = new Propiedades(0, "", 380,595,0,0,35,10,"Blogspot", "PROPIEDAD");
        arregloPropiedadades[19] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[20] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[21] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[22] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[23] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
        arregloPropiedadades[24] = new Propiedades(0, "", 380,595,0,0,35,10,"Blogspot", "PROPIEDAD");
        arregloPropiedadades[25] = new Propiedades(0, "", 746,595,0,0,30,10,"Salida", "PROPIEDAD");
        arregloPropiedadades[26] = new Propiedades(60, "", 675,595,0,0,30,10,"Wikipedia", "PROPIEDAD");
        arregloPropiedadades[27] = new Propiedades(0, "", 600,595,0,0,30,10,"Google.org", "LEERCARTA");
        arregloPropiedadades[28] = new Propiedades(70, "", 527,595,0,0,35,10,"ASK", "PROPIEDAD");
        arregloPropiedadades[29] = new Propiedades(0, "", 457,595,0,0,35,10,"IMPUESTOS15", "INPUESTOS15");
    }
    
    public void createAndAskNames(){
        //Se llena la variable con datos estaticos
        this.persona[0]= new Persona("",0,0,1500);
        this.persona[1]= new Persona("",0,0,1500);
        //Llamada al metodo para solicitar nombres
        askNames(this.persona);   
    }
    //Solicitar nombres
    public void askNames(Persona persona[]){
       String nombre = JOptionPane.showInputDialog("Digite el nombre del jugador 1");
       String nombre2 = JOptionPane.showInputDialog("Digite el nombre del jugador 2");
       setName(nombre,nombre2);
    }
    //Agregar nombres
    public void setName(String Nombre,String Nombre2){
       this.persona[0].setNombre(Nombre);
       this.persona[1].setNombre(Nombre2);
    }
    //Obtener nombre de jugadores
    public String getNameJug(int pos){
        return this.persona[pos].getNombre();
    }
   
    // Obtener dinero de jugadores
    public int obtenerDineroJug(int pos){
        return this.persona[pos].getDinero();
    }
    
    public Propiedades getPropiedades(int pos){
        return this.arregloPropiedadades[pos];
    }
    
    public int getPersonaPosicion(int pos){
        return this.persona[pos].getPosicion();
    }
    
    public void setPersonaPosicion(int pos, int val){
        this.persona[pos].setPosicion(val);
    }
    
    public void setGanador(boolean estado){
        this.ganador = estado;
    }
    
    public boolean getGanador(){
        return this.ganador;
    }
    
    public String getPersonaNombre(int pos){
        return this.persona[pos].getNombre();
    }
}
