/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.util.ArrayList;

/**
 *
 * @author raiam.quesada.urena
 */
public class Jugador extends Persona {
    private int posicion;
    private ArrayList<String> CantPropiedades = new ArrayList();
    private int dinero;

    public Jugador() {
        super();
    }

    


    public Jugador(String Nombre, int posicion, int dinero) {
        super(Nombre);
        this.posicion = posicion;
        this.dinero = dinero;
    }
    
    

    public String getNombre() {
        return this.getNombreP();
    }

    public void setNombre(String Nombre) {
        this.setNombreP(Nombre);
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ArrayList getCantPropiedades() {
        return CantPropiedades;
    }

    public void setCantPropiedades(String propiedad) {
        System.out.println("SetCantPropiedades");
        this.CantPropiedades.add(propiedad);
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    
    
}
