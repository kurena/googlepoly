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
    private Preguntas preguntas[]= new Preguntas[10];
    private boolean ganador = false;
    public Main() {
        
    }
    
    public void createGame(){
        arregloPropiedadades[0] = new Propiedades(0, "", 515,500,0,0,0,0,0,0,"Salida", "Salida",0,0,0,0);
        arregloPropiedadades[1] = new Propiedades(60, "", 465,500,0,0,0,0,10,20,"Wikipedia", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[2] = new Propiedades(0, "", 405,500,0,0,0,0,0,0,"Google.org", "LEERCARTA",0,0,0,0);
        arregloPropiedadades[3] = new Propiedades(70, "", 350,500,0,0,0,0,25,35,"Ask.com", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[4] = new Propiedades(15, "", 295,500,0,0,0,0,0,0,"Impuestos Servidor", "IMPUESTOS15",0,0,0,0);
        arregloPropiedadades[5] = new Propiedades(20, "", 240,500,0,0,0,0,0,0,"Plaforma Movil", "BONUS",0,0,0,0);
        arregloPropiedadades[6] = new Propiedades(120, "", 180,500,0,0,0,0,50,70,"Blogspot", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[7] = new Propiedades(130, "", 120,500,0,0,0,0,65,80,"JotSpot", "Propiedad",100,200,300,300);
        arregloPropiedadades[8] = new Propiedades(0, "", 65,500,0,0,0,0,0,0,"Dead Pool", "CARCEL",0,0,0,0);
        arregloPropiedadades[9] = new Propiedades(210, "", 40,410,0,0,0,0,100,150,"Youtube", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[10] = new Propiedades(210, "", 40,360,0,0,0,0,100,150,"Twitter", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[11] = new Propiedades(0, "", 40,300,0,0,0,0,0,0,"Google Adworks", "LEERCARTA",0,0,0,0);
        arregloPropiedadades[12] = new Propiedades(220, "", 40,240,0,0,0,0,100,150,"Wordpress", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[13] = new Propiedades(240, "", 40,180,0,0,0,0,110,180,"Facebook", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[14] = new Propiedades(250, "", 40,120,0,0,0,0,120,190,"Instagram", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[15] = new Propiedades(75, "", 40,50,0,0,0,0,0,0,"Google Foundation", "DONACION",0,0,0,0);
        arregloPropiedadades[16] = new Propiedades(260, "", 120,35,0,0,0,0,195,235,"LinkedIn", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[17] = new Propiedades(0, "", 180,35,0,0,0,0,0,0,"I'm feeling lucky", "LEERCARTA",0,0,0,0);
        arregloPropiedadades[18] = new Propiedades(260, "", 235,35,0,0,0,0,195,235,"FOURSQUARE", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[19] = new Propiedades(225, "", 295,35,0,0,0,0,100,150,"Paypal", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[20] = new Propiedades(15, "", 350,35,0,0,0,0,0,0,"Impuestos Servidor", "IMPUESTOS15",0,0,0,0);
        arregloPropiedadades[21] = new Propiedades(300, "", 405,35,0,0,0,0,190,250,"Skype", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[22] = new Propiedades(0, "", 465,35,0,0,0,0,0,0,"GOOGLE ANALYTICS", "LEERCARTA",0,0,0,0);
        arregloPropiedadades[23] = new Propiedades(0, "", 540,35,0,0,0,0,0,0,"Go to Dead Pool", "CARCEL",0,0,0,0);
        arregloPropiedadades[24] = new Propiedades(380, "", 540,120,0,0,0,0,210,295,"Ebay", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[25] = new Propiedades(75, "", 540,185,0,0,0,0,0,0,"Developer Platform", "BONUSDEV",0,0,0,0);
        arregloPropiedadades[26] = new Propiedades(400, "", 540,240,0,0,0,0,310,350,"Amazon", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[27] = new Propiedades(0, "", 540,300,0,0,0,0,0,0,"I[m feeiling lucky", "LEERCARTA",0,0,0,0);
        arregloPropiedadades[28] = new Propiedades(480, "", 540,355,0,0,0,0,350,100,"Oracle", "PROPIEDAD",100,200,300,300);
        arregloPropiedadades[29] = new Propiedades(500, "", 540,415,0,0,0,0,400,460,"Microsoft", "PROPIEDAD",100,200,300,300);
        
        preguntas[0] = new Preguntas("Digite el nombre sistema Operativo de celulares de google.",10,"Ganar","Android");
        preguntas[1] = new Preguntas("Has ganado $10 por comisiones.",10,"Ganar","");
        preguntas[2] = new Preguntas("Google necesita $75 por servidores nuevos.",75,"Perder","");
        preguntas[3] = new Preguntas("El canal de google para ver videos.",60,"Ganar","youtube");
        preguntas[4] = new Preguntas("Has visitado google, resiviras $35 por contribuirnos.",35,"Ganar","");
        preguntas[5] = new Preguntas("Has ganado $40 por comisiones.",40,"Ganar","");
        preguntas[6] = new Preguntas("Has perdido $30 por comisiones.",30,"Perder","");
        preguntas[7] = new Preguntas("Necesitaras una ayuda. -$50 por no usar.",10,"Perder","");
        preguntas[8] = new Preguntas("Has ganado $20 por comisiones.",20,"Ganar","");
        preguntas[9] = new Preguntas("Has incrementado tus acciones, recibiras $80.",80,"Ganar","");
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
    
    public Preguntas getPregunta(int index){
        return this.preguntas[index];
    }
}
