

package appletexample;

import javax.swing.ImageIcon;
public class imagene {
    public ImageIcon img;
    
    public ImageIcon gifDado(int Dado1){
        switch(Dado1){
            case 1:
                img = new ImageIcon(getClass().getResource("/images/dado(1).png"));
            break;
                
            case 2:
                img = new ImageIcon(getClass().getResource("/images/dado(2).png"));
            break;
                
            case 3:
                img = new ImageIcon(getClass().getResource("/images/dado(3).png"));
            break;
                
            case 4:
                img = new ImageIcon(getClass().getResource("/images/dado(4).png"));
            break;
                
            case 5:
                img = new ImageIcon(getClass().getResource("/images/dado(5).png"));
            break;
            case 6:
                img = new ImageIcon(getClass().getResource("/images/dado(6).png"));
            break;
            case 0:
                img = new ImageIcon(getClass().getResource("/images/mov.gif"));
            break;
        }
        
        return img;
    }
    
}
