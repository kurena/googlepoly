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
public class Propiedades extends Persona{
    private int costo;
    private int posX;
    private int posY;
    private int cantHoteles;
    private int cantCasas;
    private int hipotecaPrecio;
    private int renta;
    private String dueño;
    private String nombreP;
    private String tipo;
    
    public Propiedades(){
        super();
    }
    
    public Propiedades(int costo, String dueño, int posX, int posY, int cantHoteles, int cantCasas, int hipotecaPrecio, int renta,String nombre, String tipo){
        super(dueño);
        this.costo = costo;
        this.posX = posX;
        this.posY = posY;
        this.cantHoteles = cantHoteles;
        this.cantCasas = cantCasas;
        this.hipotecaPrecio = hipotecaPrecio;
        this.renta = renta;
        this.nombreP = nombre;
        this.tipo = tipo;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public int getCosto(){
        return this.costo;
    }
    
    public void setCantCasas(int casas){
       this.cantCasas = casas;
    }
    
    public int getCantCasas(){
       return this.cantCasas;
    }
    
    public void setCantHoteles(int hoteles){
       this.cantHoteles = hoteles;
    }
    
    public int getCantHoteles(){
       return this.cantHoteles;
    }
    
    public int getHipotecaPrecio(){
       return this.hipotecaPrecio;
    }
    
    public int getRenta(){
       return this.renta;
    }
    
    public String getDueño(){
       return this.getNombreP();
    }
    
    public void setDueño( String nombre){
       this.setNombreP(nombre);
    }
    
    public String getNombreP(){
       return this.nombreP;
    }
    
    
}
