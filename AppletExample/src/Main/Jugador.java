/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

/**
 *
 * @author raiam.quesada.urena
 */
public class Jugador extends Persona {
    private int posicion;
    private int CantPropiedades;
    private int dinero;

    public Jugador() {
        super();
    }

    


    public Jugador(String Nombre, int posicion, int CantPropiedades, int dinero) {
        super(Nombre);
        this.posicion = posicion;
        this.CantPropiedades = CantPropiedades;
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

    public int getCantPropiedades() {
        return CantPropiedades;
    }

    public void setCantPropiedades(int CantPropiedades) {
        this.CantPropiedades = CantPropiedades;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    
    
}
