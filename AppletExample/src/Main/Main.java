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
    //Variable privada de tipo jugador
    private Jugador jugador[] = new Jugador[2];
    private Propiedades arregloPropiedadades[] = new Propiedades[30];
    private boolean ganador = false;
    public Main() {
        
    }
    
    public void createGame(){
        arregloPropiedadades[0] = new Propiedades(60, "", 700,625,0,0,30,10,"Salida", "PROPIEDAD",10,20);
        arregloPropiedadades[1] = new Propiedades(60, "", 605,625,0,0,30,10,"Wikipedia", "PROPIEDAD",10,20);
        arregloPropiedadades[2] = new Propiedades(60, "", 530,625,0,0,30,10,"Google.org", "LEERCARTA",10,20);
        arregloPropiedadades[3] = new Propiedades(70, "", 455,625,0,0,35,10,"ASK", "PROPIEDAD",10,20);
        arregloPropiedadades[4] = new Propiedades(60, "", 383,625,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
        arregloPropiedadades[5] = new Propiedades(60, "", 310,625,0,0,35,10,"Blogspot", "PROPIEDAD",10,20);
        arregloPropiedadades[6] = new Propiedades(60, "", 235,625,0,0,30,10,"JotSpot", "PROPIEDAD",10,20);
        arregloPropiedadades[7] = new Propiedades(60, "", 160,625,0,0,30,10,"Wikipedia", "PROPIEDAD",10,20);
        arregloPropiedadades[8] = new Propiedades(60, "", 50,625,0,0,30,10,"Google.org", "LEERCARTA",10,20);
        arregloPropiedadades[9] = new Propiedades(70, "", 50,514,0,0,35,10,"ASK", "PROPIEDAD",10,20);
        arregloPropiedadades[10] = new Propiedades(60, "", 50,440,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
        arregloPropiedadades[11] = new Propiedades(60, "", 50,377,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
        arregloPropiedadades[12] = new Propiedades(60, "", 50,304,0,0,35,10,"Blogspot", "PROPIEDAD",10,20);
        arregloPropiedadades[13] = new Propiedades(0, "", 50,230,0,0,30,10,"Salida", "PROPIEDAD",10,20);
        arregloPropiedadades[14] = new Propiedades(60, "", 50,155,0,0,30,10,"Wikipedia", "PROPIEDAD",10,20);
        arregloPropiedadades[15] = new Propiedades(0, "", 50,35,0,0,30,10,"Google.org", "LEERCARTA",10,20);
        arregloPropiedadades[16] = new Propiedades(70, "", 160,35,0,0,35,10,"ASK", "PROPIEDAD",10,20);
        arregloPropiedadades[17] = new Propiedades(0, "", 230,35,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
        arregloPropiedadades[18] = new Propiedades(0, "", 300,35,0,0,35,10,"Blogspot", "PROPIEDAD",10,20);
        arregloPropiedadades[19] = new Propiedades(0, "", 375,35,0,0,30,10,"Salida", "PROPIEDAD",10,20);
        arregloPropiedadades[20] = new Propiedades(60, "", 447,35,0,0,30,10,"Wikipedia", "PROPIEDAD",10,20);
        arregloPropiedadades[21] = new Propiedades(0, "", 523,35,0,0,30,10,"Google.org", "LEERCARTA",10,20);
        arregloPropiedadades[22] = new Propiedades(70, "", 598,35,0,0,35,10,"ASK", "PROPIEDAD",10,20);
        arregloPropiedadades[23] = new Propiedades(0, "", 700,35,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
        arregloPropiedadades[24] = new Propiedades(0, "", 700,150,0,0,35,10,"Blogspot", "PROPIEDAD",10,20);
        arregloPropiedadades[25] = new Propiedades(0, "", 700,221,0,0,30,10,"Salida", "PROPIEDAD",10,20);
        arregloPropiedadades[26] = new Propiedades(60, "", 700,301,0,0,30,10,"Wikipedia", "PROPIEDAD",10,20);
        arregloPropiedadades[27] = new Propiedades(0, "", 700,372,0,0,30,10,"Google.org", "LEERCARTA",10,20);
        arregloPropiedadades[28] = new Propiedades(70, "", 700,440,0,0,35,10,"ASK", "PROPIEDAD",10,20);
        arregloPropiedadades[29] = new Propiedades(0, "", 700,513,0,0,35,10,"IMPUESTOS15", "INPUESTOS15",10,20);
    }
    
    public void createAndAskNames(){
        //Se llena la variable con datos estaticos
        this.jugador[0]= new Jugador("",0,1500);
        this.jugador[1]= new Jugador("",0,1500);
        //Llamada al metodo para solicitar nombres
        askNames(this.jugador);   
    }
    //Solicitar nombres
    public void askNames(Persona jugador[]){
       String nombre = JOptionPane.showInputDialog(null, "Digite el nombre del Jugador 1", "Brinde la informacion", JOptionPane.QUESTION_MESSAGE);
       String nombre2 = JOptionPane.showInputDialog(null, "Digite el nombre del jugador 2", "Brinde la informacion", JOptionPane.QUESTION_MESSAGE);
       setName(nombre,nombre2);
    }
    //Agregar nombres
    public void setName(String Nombre,String Nombre2){
       this.jugador[0].setNombre(Nombre);
       this.jugador[1].setNombre(Nombre2);
    }
    //Obtener nombre de jugadores
    public String getNameJug(int pos){
        return this.jugador[pos].getNombre();
    }
   
    // Obtener dinero de jugadores
    public int obtenerDineroJug(int pos){
        return this.jugador[pos].getDinero();
    }
    
    public Propiedades getPropiedades(int pos){
        return this.arregloPropiedadades[pos];
    }
    
    public Jugador getJugador(int pos){
        return this.jugador[pos];
    }
    
    public int getPersonaPosicion(int pos){
        return this.jugador[pos].getPosicion();
    }
    
    public void setPersonaPosicion(int pos, int val){
        this.jugador[pos].setPosicion(val);
    }
    
    public void setGanador(boolean estado){
        this.ganador = estado;
    }
    
    public boolean getGanador(){
        return this.ganador;
    }
    
    public String getPersonaNombre(int pos){
        return this.jugador[pos].getNombre();
    }
}
