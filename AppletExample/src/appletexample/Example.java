

package appletexample;
import Main.Persona;
import Main.Main;
import Main.Propiedades;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import org.xml.sax.Attributes;

public class Example extends javax.swing.JApplet implements ActionListener {
        Persona persona[] = new Persona[2];  
        Main createGame=new Main();
        private int control= 0;
        private int pares = 0;
        private int iniciar = 0;
        private int resul1 =0;
        private int resul2 =0;
        private int movimiento;
        private boolean flag;
        private boolean flagLose=false;
       
    @Override
    public void init() {
        setSize(1400,1500);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    createGame.createGame();
                    setImagenes();
                    log("Dale en el boton de Jugar para empezar la accion");
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jugar.addActionListener(this);
        lanzar.addActionListener(this);
        Comprar.addActionListener(this);
        Avanzar.addActionListener(this);
        More.addActionListener(this);
        prop.addActionListener(this);
        prop2.addActionListener(this);
    }
    
    //-----------------------imagen para bloqueadas-------------------------------//
    public void setImagenes(){
        Comprar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addBlock.png")));
        jugar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jugarBlocked.png")));
        lanzar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lanzarBlocked.png")));
        More.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/moreBlocked.png")));
        Avanzar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avanzar_1Blocked.png")));
    }
    //------------------------------------------cargar la informacion al hacer click en jugar----------------//
    public void loadData(){
        createGame.createAndAskNames();
        nombre.setText("Nombre: "+createGame.getNameJug(0));
        nombre2.setText("Nombre: "+createGame.getNameJug(1));
        dinero.setText("Dinero Actual:"+createGame.obtenerDineroJug(0));
        dinero2.setText("Dinero Actual:"+createGame.obtenerDineroJug(1));
        propiedades.setText("# de propiedades: 0");
        propiedades2.setText("# de propiedades: 0");
    }
    //llama la funcion para crear el juego
    public void startGame(){
        loadData();        
    }
    //---------------validamos si se pasa de 30 que es la posicion final, volvemos al inicio-----------------//
    public int validarDado(int posicion){
        int returning = posicion;
        if(posicion >= 30){
            returning = posicion - 30;
            this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()+100);
            log("Has recibido $100 por dar la vuelta");
            this.updateMoney();
        }
        return returning;
    }
    
    //---------------------------------cuando hace click en lanzar-------------------------//
    public void clickLanzar(int valor){
       int move = valor;
       //valor = 3;
       int finalMove;
        if(this.control == 0){
            finalMove = createGame.getPersonaPosicion(0) + move;
            createGame.setPersonaPosicion(0,validarDado(finalMove));
            log(createGame.getPersonaNombre(0)+" ha lanzado los dados, el numero de posiciones a mover es de: "+valor);
            if(this.pares == 1){
                this.control = 0;
                this.pares = 0;
                flag=true;
            }
            else{
             this.control=1;   
             flag=false;
            }
            updateChip(1,createGame.getPersonaPosicion(0));
            
        } else {
            finalMove = createGame.getPersonaPosicion(1) + move;
            createGame.setPersonaPosicion(1,validarDado(finalMove));
            log(createGame.getPersonaNombre(1)+" ha lanzado los dados, el numero de posiciones a mover es de: "+valor);            
            if(this.pares == 1){
                this.control = 1;
                this.pares = 0;
                flag=true;
            }
            else{
             this.control=0;   
             flag=false;
            }
            updateChip(0,createGame.getPersonaPosicion(1));
        }
        
    }//cerrar clicklnzar
    
    private void showPropiedades(){
        
        String texto="";
        if(this.createGame.getJugador(0).getCantPropiedades().size() >0){
            for(int x=0; x<this.createGame.getJugador(0).getCantPropiedades().size();x++){
                texto=texto+"\n"+this.createGame.getJugador(0).getCantPropiedades().get(x);
            }
        } else {
            texto="\nNo posee propiedades";
        }

        JOptionPane.showMessageDialog(rootPane,"Propiedades de Jugador 1:"+texto);
    }
    
    private void showPropiedades2(){
        
        String texto="";
        if(this.createGame.getJugador(1).getCantPropiedades().size() >0){
            for(int x=0; x<this.createGame.getJugador(1).getCantPropiedades().size();x++){
                texto=texto+"\n"+this.createGame.getJugador(1).getCantPropiedades().get(x);
            }
        } else {
            texto="No posee propiedades";
        }

        JOptionPane.showMessageDialog(rootPane,"Propiedades de Jugador 2:"+texto);
    }
    //--------------------------------------Devuelve el valor del actual jugador------------//
    public int returnControl(){
        int valor=this.control;
        if(this.flag){
        } else {
            if(this.control== 0){
                valor= 1;
            } else {
                valor= 0;
            }
          } 
        return valor;
    }
    
    public void ableAll(){
        prop.setEnabled(true);
        prop2.setEnabled(true);
        lanzar.setEnabled(true);
    }
    //-----------------------------------actualizar ficha!-------------------------------//
    public void updateChip(int index, int pos){
        if(index == 1){
            player1.setLocation(this.createGame.getPropiedades(pos).getPosX(),this.createGame.getPropiedades(pos).getPosY());
        } else {
           player2.setLocation(this.createGame.getPropiedades(pos).getPosX(),this.createGame.getPropiedades(pos).getPosY());
        }
        validarPropiedad();
    }//fin de la funcion
    public void  putChips(){
            int ang =20;
            int mag =165;
            int mag2=160;
            int xi=player1.getX();
            int yi=player1.getY();
            int x2= player2.getX();
            int y2= player2.getY();
                       
            for (int m = 1; m <= mag2; m++) {
                int y = (int) (m * Math.sin(Math.toRadians(ang)));
                int x = (int) (m * Math.cos(Math.toRadians(ang)));
                player2.setLocation(x2+x, y2-y);
                player2.paintImmediately(-1,-1,getWidth(),getHeight());
            }
            
            for (int m = 1; m <= mag; m++) {
                int y = (int) (m * Math.sin(Math.toRadians(ang)));
                int x = (int) (m * Math.cos(Math.toRadians(ang)));
                player1.setLocation(xi+x, yi-y);
                player1.paintImmediately(-1,-1,getWidth(),getHeight());
            }
    }
    //----------------------Funcion validar casilla---------------------------//
    public void reduceMoney(String texto){
        if(this.flagLose !=true){
         if(texto.equals("IMPUESTOS15")){
             this.setDinero(15);
             log("A "+this.createGame.getNameJug(this.getCurrentPosition())+" se le ha descontado $15 producto de impuestos");
             this.updateMoney();
        } else if(texto.equals("BONUS")){
             this.setMasDinero(20);
             log(this.createGame.getNameJug(this.getCurrentPosition())+" ha obtenido $20 por visitar la plataforma android");
             this.updateMoney();
        } else if(texto.equals("DONACION")){
            this.setMasDinero(50);
             log(this.createGame.getNameJug(this.getCurrentPosition())+" ha obtenido $50 por participar en la donacion de google");
             this.updateMoney();
        } else if(texto.equals("BONUSDEV")){
            this.setMasDinero(75);
             log(this.createGame.getNameJug(this.getCurrentPosition())+" ha obtenido $75 por ser developer");
             this.updateMoney();
        } else if(texto.equals("CARCEL")){
             this.setDinero(50);
             log("A LA CARCEL!! Se te ha descontado $50 para salir de la carcel. Lo sentimos "+this.createGame.getNameJug(this.getCurrentPosition())+"!!!");
             this.updateMoney();
        } else if(texto.equals("LEERCARTA")){
            String tipo, pregunta, respuestas;
            int valor;
                Random generator = new Random(); 
                int i = generator.nextInt(10);
                tipo = this.createGame.getPregunta(i).getTipo();
                valor = this.createGame.getPregunta(i).getValor();
                pregunta= this.createGame.getPregunta(i).getPreguntaexto();
                respuestas = this.createGame.getPregunta(i).getContestar();
                this.question(pregunta, tipo, valor,respuestas);
                
        }
         Avanzar.setEnabled(true);
        }
        
    }
    
    //---------------------------------------validar la pregunta-------------------------------------//
    public void question(String texto, String tipo, int valor, String respuestas){
        if(tipo.equals("Ganar")){
            if(respuestas != ""){
                String respuesta = JOptionPane.showInputDialog(rootPane, texto, "Podes ganar o perder, Contesta.", JOptionPane.QUESTION_MESSAGE);
                if(respuesta.equals(respuestas)){
                  this.setMasDinero(valor);
                    log("Se le ha otorgado a "+this.createGame.getNameJug(this.getCurrentPosition())+" una bonificacion de $"+valor);
                    this.updateMoney();
                } else {
                    this.setDinero(valor);
                    log("Se le ha rebajado a "+this.createGame.getNameJug(this.getCurrentPosition())+" una cantidad de $"+valor+" por no contestar correctamente");
                    this.updateMoney();
                }
            } else {
                this.setMasDinero(valor);
                log("Se le ha otorgado a "+this.createGame.getNameJug(this.getCurrentPosition())+" una bonificacion de $"+valor);
                this.updateMoney();
                JOptionPane.showMessageDialog(rootPane, ""+texto, "Ganaste Dinero", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else if(tipo.equals("Perder")){
            this.setDinero(valor);
            log("Se le ha rebajado a "+this.createGame.getNameJug(this.getCurrentPosition())+" una cantidad de $"+valor);
            this.updateMoney();
            JOptionPane.showMessageDialog(rootPane, ""+texto, "Perdiste Dinero", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    //-------------------------------------------- validar datos de propiedad------------------------//
    public void validarPropiedad(){
        
        String dueño = this.createGame.getPropiedades(this.getCurrentProperty()).getDueño();
        String tipo = this.createGame.getPropiedades(this.getCurrentProperty()).getType();
        String[] opcionesIniciales = {"Comprar", "Avanzar"};
        System.out.println("DUENO: "+dueño+" tipo: "+tipo);
        //else if(tipo!= "PROPIEDAD"){
              //  log();
            //}
        int posicionActual = this.createGame.getPersonaPosicion(this.getCurrentPosition());
        if(this.createGame.getPropiedades(this.getCurrentProperty()).getDueño()=="" && tipo =="PROPIEDAD"){
                    log(this.createGame.getNameJug(this.getCurrentPosition())+", seleccione una opcion de las habilitadas.");
                    Avanzar.setEnabled(true);
                    Comprar.setEnabled(true);
        } else if(tipo!="PROPIEDAD"){
            this.reduceMoney(tipo);
        }
        
        if(dueño!="" && dueño != getCurrentPlayerName()){
                setDinero();
                log(this.createGame.getNameJug(this.getCurrentPosition())+" debe de pagar: $"+this.createGame.getPropiedades(this.getCurrentProperty()).getRenta()+" por el alquiler de la propiedad");
                setDineroNew();
                this.updateNewMoney();
                this.updateMoney();
                Avanzar.setEnabled(true);
                More.setEnabled(false);
            } else if(dueño == this.getCurrentPlayerName()){
                    Avanzar.setEnabled(true);
                    Comprar.setEnabled(false);
                    More.setEnabled(true);
                }//end else

    }
    
     //----------------------Funcion validar casilla---------------------------//
    public void accion(String Accions){
        String dueño = this.createGame.getPropiedades(this.getCurrentProperty()).getDueño();
        String tipo = this.createGame.getPropiedades(this.getCurrentProperty()).getType();
        if(Accions.equals("Comprar")){
            if(dueño =="" && tipo=="PROPIEDAD"){
                if(this.createGame.getJugador(this.getCurrentPosition()).getDinero()>=this.createGame.getPropiedades(this.getCurrentProperty()).getCosto()){
                    this.createGame.getPropiedades(this.getCurrentProperty()).setDueño(this.createGame.getJugador(this.returnControl()).getNombreP());
                    this.setDineroPropiedad();
                    log(this.createGame.getPropiedades(this.getCurrentProperty()).getDueño() +" ha comprado a la propiedad: "+this.createGame.getPropiedades(this.getCurrentProperty()).getNombre()+" en: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCosto());
                    this.updateMoney();
                    this.createGame.getJugador(this.getCurrentPosition()).setCantPropiedades(this.createGame.getPropiedades(this.getCurrentProperty()).getNombre());
                    this.updatePropiedades();   
                }else {
                    log("No hay los fondos suficientes para comprar la propiedad");
                }
            } else if(dueño !=""){
                log("Esta propiedad ya ha sido comprada por: "+this.createGame.getPropiedades(this.getCurrentProperty()).getDueño());
            } 
            
        } 
        
    }
    //--------------setear el dinero del jugador---------------------------------------//
    public void setDinero(){
        this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()-this.createGame.getPropiedades(this.getCurrentProperty()).getRenta());
    }
    public void setDineroPropiedad(){
            this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()-this.createGame.getPropiedades(this.getCurrentProperty()).getCosto());        
    }
    public void setDinero(int valor){
        this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()-valor);
    }
    public void setMasDinero(int valor){
        this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()+valor);
    }
    
    public void setDineroNew(){
        this.createGame.getJugador(this.control).setDinero( this.createGame.getJugador(this.control).getDinero()+this.createGame.getPropiedades(this.getCurrentProperty()).getRenta());
    }
    public void addPropiedad(String nombre){
        this.createGame.getJugador(this.getCurrentPosition()).setCantPropiedades(nombre);
    }
    //------------------devuelve jugador actual el nombre---------------------// 
    public String getCurrentPlayerName(){
        return this.createGame.getNameJug(this.getCurrentPosition());
    }
    
    //----------------------------------mostrar opciones para mejorar y demas--------------------------------//
    public void showMoreOptions(){
        //Options for the combo box dialog
        String[] choicesCasa = {"Agregar Casa", "Mejorar Propiedad", "Avanzar"};
        String[] choicesResidencial = {"Agregar Casa", "Agregar Residencial","Mejorar Propiedad","Avanzar"};
        String[] choicesCondominio = {"Agregar Casa", "Agregar Residencial","Agregar Condominio","Mejorar Propiedad","Avanzar"};
        String[] choicesHotel = {"Agregar Casa", "Agregar Residencial","Agregar Condominio","Agregar Hotel","Mejorar Propiedad", "Avanzar"};
        
        String[] finalChoice =choicesCasa;
        if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas() >0){
            finalChoice=choicesResidencial;
            if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantResidenciales()>0){
                finalChoice = choicesCondominio;
            }
            if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCondominios()>0){
                finalChoice = choicesHotel;
            } 
        }  else if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantResidenciales()>0){
            finalChoice = choicesCondominio;
            }
            else if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCondominios()>0){
                finalChoice = choicesHotel;
            } 
            //else if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCondominios()>0){
              //  finalChoice = choicesHotel;
            //} 
        String picked = (String)JOptionPane.showInputDialog(this, "Seleccione una opcion", "Opciones de propiedad", JOptionPane.INFORMATION_MESSAGE, null, finalChoice, finalChoice[0]);
        secondAction(picked);
    }
    
    //-------------------------------funcion para el caluclo de alquiler de acuerdo a casa y hotel---------------/
    public void secondAction(String texto){
        int dinero;
        if(texto.equals("Agregar Casa")){
            this.createGame.getPropiedades(this.getCurrentProperty()).setCantCasas(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas() +1);
            log("Una Casa ha sido comprada, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas()+" casa(s)");
            this.setDineroExtra(this.createGame.getPropiedades(this.getCurrentProperty()).getPrecioCasa());
        } else if (texto.equals("Agregar Hotel")){
                this.createGame.getPropiedades(this.getCurrentProperty()).setCantHoteles(this.createGame.getPropiedades(this.getCurrentProperty()).getCantHoteles()+1);
                log("Un Hotel ha sido comprado, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantHoteles()+" hotel(es)");
                this.setDineroExtra(this.createGame.getPropiedades(this.getCurrentProperty()).getPrecioHotel());
        }
        else if(texto.equals("Agregar Condominio")){
            this.createGame.getPropiedades(this.getCurrentProperty()).setCantHoteles(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCondominios()+1);
            log("Un Condominio ha sido comprado, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantCondominios()+" condominio(s)");
            this.setDineroExtra(this.createGame.getPropiedades(this.getCurrentProperty()).getPrecioCondiminio());
        }
        else if(texto.equals("Agregar Residencial")){
            this.createGame.getPropiedades(this.getCurrentProperty()).setCantHoteles(this.createGame.getPropiedades(this.getCurrentProperty()).getCantResidenciales()+1);
            log("Un Residencial ha sido comprado, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantResidenciales()+" residencial(es)");
            this.setDineroExtra(this.createGame.getPropiedades(this.getCurrentProperty()).getPrecioResidencial());
        }
        this.updateMoney();
    }
    
    
    //-----------------------Retornar quien juega------------------------------------------------//
    
    public int getCurrentPosition(){
        return returnControl();
    }
   
    public int getNextPlayer(){
        return this.control;
    }
    
    //-------------------------------------------------Reducirdinero de los hoteles y eso
    public void setDineroExtra(int dinero){
        log("Ademas, se ha rebajado $"+dinero+" a "+this.createGame.getJugador(this.getCurrentPosition()).getNombre()+" por su compra");
        this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()-dinero);
    }
    
    
    //---------------------------------------- actualizar el dinero----------------------------------------//
    public void updateMoney(){
        if(this.getCurrentPosition()==0){
             dinero.setText("Dinero Actual:"+this.createGame.getJugador(0).getDinero());
        } else {
             dinero2.setText("Dinero Actual:"+this.createGame.getJugador(1).getDinero());
        }
        if(this.createGame.getJugador(this.getCurrentPosition()).getDinero()<0){
            JOptionPane.showMessageDialog(rootPane, this.createGame.getJugador(this.control).getNombre()+" ha ganado la partida, su rival se quedo sin fondos", "Tenemos un ganador", JOptionPane.INFORMATION_MESSAGE);
            this.flagLose=true;
            resetAll();
        }
    }
    
    public void resetAll(){
        control= 0;
        pares = 0;
        iniciar = 0;
        resul1 =0;
        resul2 =0;
        flag=false;
        flagLose=false;
        this.blockButton();
        jugar.setEnabled(true);
    }
    
    public void updateNewMoney(){
        if(this.getCurrentPosition()==0){
             dinero2.setText("Dinero Actual:"+this.createGame.getJugador(1).getDinero());
        } else {
             dinero.setText("Dinero Actual:"+this.createGame.getJugador(0).getDinero());
        }
    }
    //--------------------------------------actualizar la cantidad de propiedades-------------------------//
    public void updatePropiedades(){
        if(this.getCurrentPosition()==0){
            propiedades.setText("# de propiedades: "+this.createGame.getJugador(0).getCantPropiedades().size());
        } else {
            propiedades2.setText("# de propiedades: "+this.createGame.getJugador(1).getCantPropiedades().size());
        }
    }
    
    //-------------------------Obtener la posicion de la ficha de la persona-------------//
    public int getCurrentProperty(){
        return this.createGame.getPersonaPosicion(this.returnControl());
    }
    
    //---------------------------------Funcion cuando se hace click al dado---------//
    public void moverDado(){
        lanzar.setEnabled(false);
         //Animacion Gif
            final Timer timer = new Timer(1,new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    imagene image = new imagene();
                    jLabel11.setIcon(image.gifDado(0));
                    jLabel12.setIcon(image.gifDado(0));
                }
            });
            //Dados Estaticos Aleatoriamente
            
            final Timer timer2 = new Timer(1000,new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    lanzar.setEnabled(false);
                    timer.stop();
                    imagene image = new imagene();
                    dados tirar = new dados();
                    int numDado = tirar.calculaNumero();
                    int numDado2 = tirar.calculaNumero();
                    jLabel11.setIcon(image.gifDado(numDado));
                    jLabel12.setIcon(image.gifDado(numDado2));
                    int Resultado = numDado+numDado2;
                    movimiento = numDado+numDado2;
                    if(iniciar == 1){
                        jLabel5.setText("Resultado 1 : "+Resultado);
                        resul1=Resultado;
                        iniciar=2;
                        lanzar.setEnabled(true);
                        log(createGame.getNameJug(0)+" obtuvo "+Resultado);
                        
                    }
                    else if(iniciar==2){
                        lanzar.setEnabled(true);
                        jLabel5.setText("Resultado 2 : "+Resultado);
                        log(createGame.getNameJug(1)+" obtuvo "+Resultado);
                        resul2=Resultado;
                        iniciar=0;
     
                        if(resul1>resul2){
                            control=0;
                            setControl(0);
                            log(createGame.getNameJug(0)+" inicia el juego!");
                        }else
                        if(resul1<resul2){
                            log(createGame.getNameJug(1)+" inicia el juego!");
                            control=1;
                            setControl(1);
                        }else
                        if(resul1==resul2){
                            log("Empates a lanzar los dados de nuevo!");
                            iniciar=1;
                            
                        }
                    }
                    else if(iniciar ==0){
                        
                        if(numDado == numDado2){
                        pares = 1;
                        setPares(1);
                        }
                        jLabel5.setText("Espacios a mover: "+Resultado);
                        clickLanzar(Resultado);
                    }
                    
                    
                    
                }
            });
            //Start y delay entre animaciones
            timer.start();
            timer2.setInitialDelay(3000);
            timer2.start();
            timer2.setRepeats(false);
    }
 //---------------------------Logear las acciones a jugar----------------------------------//
    public void log(String text){
        java.util.Date ras= new java.util.Date();
        log.setText(log.getText()+"["+ras.getMonth()+"/"+ras.getDay()+"/"+ras.getYear()+" "+ras.getHours()+":"+ras.getMinutes()+":"+ras.getSeconds()+"] "+text+"\n");
    }
   
    public void blockButton(){
        Comprar.setEnabled(false);
        Avanzar.setEnabled(false);
        More.setEnabled(false);
    }
    public void allowButton(){
        Comprar.setEnabled(true);
        Avanzar.setEnabled(true);
    }

    public void setControl(int controlData){
        this.control = controlData;
    }
    public void setPares(int controlData){
        this.pares = controlData;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        player2 = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        Avanzar = new javax.swing.JButton();
        Comprar = new javax.swing.JButton();
        More = new javax.swing.JButton();
        table = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lanzar = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        propiedades = new javax.swing.JLabel();
        prop = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        nombre2 = new javax.swing.JLabel();
        dinero2 = new javax.swing.JLabel();
        propiedades2 = new javax.swing.JLabel();
        prop2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        logText = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fichachrome2.png"))); // NOI18N

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fichachrome1.png"))); // NOI18N
        player1.setToolTipText("");

        Avanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avanzar_1.png"))); // NOI18N
        Avanzar.setToolTipText("Terminar turno");
        Avanzar.setBorderPainted(false);
        Avanzar.setContentAreaFilled(false);
        Avanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Avanzar.setEnabled(false);

        Comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        Comprar.setToolTipText("Comprar esta propiedad");
        Comprar.setBorderPainted(false);
        Comprar.setContentAreaFilled(false);
        Comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Comprar.setEnabled(false);
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });

        More.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/more.png"))); // NOI18N
        More.setToolTipText("Mas opciones");
        More.setBorderPainted(false);
        More.setContentAreaFilled(false);
        More.setEnabled(false);

        table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/googolopoly.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Avanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(More, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(player1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player2)
                        .addGap(157, 157, 157))
                    .addComponent(table))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(More)
                    .addComponent(player2)
                    .addComponent(Avanzar)
                    .addComponent(Comprar)
                    .addComponent(player1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame1.setBackground(java.awt.Color.white);
        jInternalFrame1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jInternalFrame1.setVisible(true);

        lanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lanzar.png"))); // NOI18N
        lanzar.setToolTipText("Lanzar");
        lanzar.setContentAreaFilled(false);
        lanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lanzar.setEnabled(false);

        jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jugar.png"))); // NOI18N
        jugar.setToolTipText("Jugar");
        jugar.setContentAreaFilled(false);
        jugar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lanzar))
                .addContainerGap())
        );

        jLabel5.setText("Dados: 0");

        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombre.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        nombre.setText("Nombre:");

        dinero.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        dinero.setText("Dinero:");

        propiedades.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        propiedades.setText("# de propiedades:");

        prop.setText("Ver Propiedades");
        prop.setToolTipText("Propiedades Jugador 1");
        prop.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dinero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propiedades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(prop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dinero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propiedades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(prop))
        );

        jTabbedPane3.addTab("Jugador 1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombre2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        nombre2.setText("Nombre:");

        dinero2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        dinero2.setText("Dinero:");

        propiedades2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        propiedades2.setText("# de propiedades:");

        prop2.setText("Ver Propiedades");
        prop2.setToolTipText("Propiedades Jugador 2");
        prop2.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dinero2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propiedades2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(prop2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dinero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propiedades2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(prop2))
        );

        jTabbedPane2.addTab("Jugador 2", jPanel4);

        log.setColumns(20);
        log.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        log.setRows(5);
        log.setEnabled(false);
        jScrollPane1.setViewportView(log);

        logText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logText.setText("Acciones del Juego:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(104, 104, 104)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logText)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Jugador 1");
        jTabbedPane2.getAccessibleContext().setAccessibleName("Jugador 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1314, 1314, 1314)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed

    }//GEN-LAST:event_jugarActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComprarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Avanzar;
    private javax.swing.JButton Comprar;
    private javax.swing.JButton More;
    private javax.swing.JLabel dinero;
    private javax.swing.JLabel dinero2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JButton jugar;
    private javax.swing.JButton lanzar;
    private javax.swing.JTextArea log;
    private javax.swing.JLabel logText;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JButton prop;
    private javax.swing.JButton prop2;
    private javax.swing.JLabel propiedades;
    private javax.swing.JLabel propiedades2;
    private javax.swing.JLabel table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton b = null;
        String buttonText = "";
        String buttonID = "";

        if(o instanceof JButton)
          b = (JButton)o;

        if(b != null){
            buttonText = b.getText();
            buttonID = b.getToolTipText();
        }    
        
        if (buttonID.equals("Jugar")){
            log("A lanzar los dados para determinar quien inicia el juego!");
            startGame();
            jugar.setEnabled(false);
            ableAll();
            putChips();
            lanzar.setEnabled(true);
            this.iniciar = 1;
        }
        
        if (buttonID.equals("Lanzar")){
           moverDado();          
        }
        
        if(buttonID.equals("Comprar esta propiedad")){
            this.accion("Comprar");
        }
        
        if(buttonID.equals("Terminar turno")){
            log("Es el turno de: "+this.createGame.getNameJug(this.getNextPlayer()));
            lanzar.setEnabled(true);
            blockButton();
        }
        
        if(buttonID.equals("Mas opciones")){
            showMoreOptions();
        }
        
        if(buttonID.equals("Propiedades Jugador 1")){
            showPropiedades();
        }
        
        if(buttonID.equals("Propiedades Jugador 2")){
            showPropiedades2();
        }
        
        
    }//Fin del listener
}
