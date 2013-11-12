

package appletexample;

import java.util.Random;

public class dados {
    public int valorTira;
    
    public int calculaNumero(){
    
      Random generar = new Random();
      valorTira = generar.nextInt(6)+1;
      return valorTira;
    }
}
