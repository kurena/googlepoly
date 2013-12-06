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
public class Preguntas {
    private String pregunta;
    private int valor;
    private String tipo;
    private String contestar;

    public Preguntas() {
    }

    
    public Preguntas(String pregunta, int valor, String tipo, String contestar) {
        this.pregunta = pregunta;
        this.valor = valor;
        this.tipo = tipo;
        this.contestar = contestar;
    }
    

    public String getPreguntaexto() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getContestar() {
        return contestar;
    }

    public void setContestar(String contestar) {
        this.contestar = contestar;
    }
        
}
