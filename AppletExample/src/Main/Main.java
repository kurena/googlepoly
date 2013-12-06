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
        arregloPropiedadades[0] = new Propiedades(0, "", 700,625,0,0,0,0,"Salida", "Salida",0,0);
        arregloPropiedadades[1] = new Propiedades(60, "", 605,625,0,0,10,20,"Wikipedia", "PROPIEDAD",50,100);
        arregloPropiedadades[2] = new Propiedades(0, "", 530,625,0,0,0,0,"Google.org", "LEERCARTA",0,0);
        arregloPropiedadades[3] = new Propiedades(70, "", 455,625,0,0,25,35,"ASK", "PROPIEDAD",50,100);
        arregloPropiedadades[4] = new Propiedades(15, "", 383,625,0,0,0,0,"Impuestos Servidor", "IMPUESTO15",0,0);
        arregloPropiedadades[5] = new Propiedades(120, "", 310,625,0,0,50,70,"Blogspot", "PROPIEDAD",50,100);
        arregloPropiedadades[6] = new Propiedades(130, "", 235,625,0,0,65,80,"JotSpot", "PROPIEDAD",50,100);
        arregloPropiedadades[7] = new Propiedades(20, "", 160,625,0,0,0,0,"Mobile Platorm", "BONUS",0,0);
        arregloPropiedadades[8] = new Propiedades(0, "", 50,625,0,0,0,0,"Dead Pool", "CARCEL",0,0);
        arregloPropiedadades[9] = new Propiedades(210, "", 50,514,0,0,90,120,"Drupal", "PROPIEDAD",50,100);
        arregloPropiedadades[10] = new Propiedades(210, "", 50,440,0,0,100,150,"Drupal", "PROPIEDAD",50,100);
        arregloPropiedadades[11] = new Propiedades(0, "", 50,377,0,0,0,0,"Google Adworks", "LEERCARTA",0,0);
        arregloPropiedadades[12] = new Propiedades(210, "", 50,304,0,0,100,150,"Wordpress", "PROPIEDAD",50,100);
        arregloPropiedadades[13] = new Propiedades(240, "", 50,230,0,0,110,180,"Opera", "PROPIEDAD",50,100);
        arregloPropiedadades[14] = new Propiedades(240, "", 50,155,0,0,110,180,"Opera", "PROPIEDAD",50,100);
        arregloPropiedadades[15] = new Propiedades(75, "", 50,35,0,0,0,0,"Google Foundation", "DONACION",0,0);
        arregloPropiedadades[16] = new Propiedades(200, "", 160,35,0,0,95,135,"Internet Explorer", "PROPIEDAD",50,100);
        arregloPropiedadades[17] = new Propiedades(200, "", 230,35,0,0,95,135,"Moxilla Firefox", "PROPIEDAD",50,100);
        arregloPropiedadades[18] = new Propiedades(0, "", 300,35,0,0,0,0,"I'm feeling lucky", "LEERCARTA",0,0);
        arregloPropiedadades[19] = new Propiedades(225, "", 375,35,0,0,100,150,"Paypal", "PROPIEDAD",50,100);
        arregloPropiedadades[20] = new Propiedades(15, "", 447,35,0,0,0,0,"Impuestos Servidor", "IMPUESTOS15",50,100);
        arregloPropiedadades[21] = new Propiedades(300, "", 523,35,0,0,190,250,"Skype", "PROPIEDAD",50,100);
        arregloPropiedadades[22] = new Propiedades(0, "", 598,35,0,0,0,0,"I'm feeling lucky", "LEERCARTA",0,0);
        arregloPropiedadades[23] = new Propiedades(0, "", 700,35,0,0,0,0,"Dead Pool", "CARCEL",0,0);
        arregloPropiedadades[24] = new Propiedades(380, "", 700,150,0,0,210,295,"Ebay", "PROPIEDAD",50,100);
        arregloPropiedadades[25] = new Propiedades(75, "", 700,221,0,0,0,0,"Developer Platform", "BONUS",0,0);
        arregloPropiedadades[26] = new Propiedades(400, "", 700,301,0,0,310,350,"Amazon", "PROPIEDAD",50,100);
        arregloPropiedadades[27] = new Propiedades(0, "", 700,372,0,0,0,0,"Google.org", "LEERCARTA",0,0);
        arregloPropiedadades[28] = new Propiedades(480, "", 700,440,0,0,350,100,"Oracle", "PROPIEDAD",50,100);
        arregloPropiedadades[29] = new Propiedades(500, "", 700,513,0,0,400,460,"Microsoft", "PROPIEDAD",50,100);
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
