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
    private int cantCondominios;
    private int cantResidenciales;
    private int hipotecaPrecio;
    private int renta;
    private String dueño;
    private String nombreP;
    private String tipo;
    private int PrecioCasa;
    private int precioResidencial;
    private int precioHotel;
    private int precioCondiminio;
    
    public Propiedades(){
        super();
    }
    
    public Propiedades(int costo, String dueño, int posX, int posY, int cantHoteles, int cantCasas, int cantResidenciales, int cantCondominios,int hipotecaPrecio, int renta,String nombre, String tipo, int PrecioCasa, int precioHotel,int precioResidencial,int precioCondomino){
        super(dueño);
        this.costo = costo;
        this.posX = posX;
        this.posY = posY;
        this.cantHoteles = cantHoteles;
        this.cantCasas = cantCasas;
        this.cantResidenciales = cantResidenciales;
        this.cantCondominios = cantCondominios;
        this.hipotecaPrecio = hipotecaPrecio;
        this.renta = renta;
        this.nombreP = nombre;
        this.tipo = tipo;
        this.precioHotel = precioHotel;
        this.PrecioCasa = PrecioCasa;
        this.precioResidencial = precioResidencial;
        this.precioCondiminio = precioCondomino;
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
    public void setCantResidenciales(int residenciales){
       this.cantResidenciales = residenciales;
    }
    
    public int getCantResidenciales(){
       return this.cantResidenciales;
    }
    
    public void setCantCondominios(int condominios){
       this.cantHoteles = condominios;
    }
    
    public int getCantCondominios(){
       return this.cantHoteles;
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
    
    public String getNombre(){
       return this.nombreP;
    }
    
    public int getRentaCasas(){
        return (this.PrecioCasa * this.cantCasas);
    }
    
    public int getRentaResidenciales(){
        return (this.precioResidencial * this.cantResidenciales);
    }
    
    public int getRentaCondominios(){
        return (this.precioCondiminio * this.cantCondominios);
    }
    
    public int getRentaHoteles(){
        return (this.precioHotel * this.cantHoteles);
    }
    
    public String getType(){
        return this.tipo;
    }
    
    
}
