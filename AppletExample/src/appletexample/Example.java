

package appletexample;
import Main.Persona;
import Main.Main;
import Main.Propiedades;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.xml.sax.Attributes;

public class Example extends javax.swing.JApplet implements ActionListener {
        Persona persona[] = new Persona[2];  
        Main createGame=new Main();
        private int control= 0;
        private int movimiento;
       
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
    }
    //------------------------------------------cargar la informacion al hacer click en jugar----------------//
    public void loadData(){
        createGame.createAndAskNames();
        nombre.setText("Nombre: "+createGame.getNameJug(0));
        nombre2.setText("Nombre: "+createGame.getNameJug(1));
        dinero.setText("Dinero Actual:"+createGame.obtenerDineroJug(0));
        dinero2.setText("Dinero Actual:"+createGame.obtenerDineroJug(1));
        System.out.println(this.createGame.getJugador(0).getCantPropiedades());
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
        if(posicion >= 29){
            returning = posicion - 30;
        }
        return returning;
    }
    
    //---------------------------------cuando hace click en lanzar-------------------------//
    public void clickLanzar(int valor){
       int move = valor;
       valor = 4;
       int finalMove;
        if(this.control == 0){
            finalMove = createGame.getPersonaPosicion(0) + move;
            createGame.setPersonaPosicion(0,validarDado(valor));
            this.control=1;
            updateChip(1,createGame.getPersonaPosicion(0));
            
        } else {
            finalMove = createGame.getPersonaPosicion(1) + move;
            createGame.setPersonaPosicion(1,validarDado(valor));
            this.control=0;
            updateChip(0,createGame.getPersonaPosicion(1));
        }
        
        log(createGame.getPersonaNombre(this.returnControl())+" ha lanzado los dados, el numero de posiciones a mover es de: "+valor);
        
    }//cerrar clicklnzar
    
    //--------------------------------------Devuelve el valor del actual jugador------------//
    public int returnControl(){
        int valor;
        if(this.control== 0){
            valor= 1;
        } else {
            valor= 0;
        }
        return valor;
    }
    //-----------------------------------actualizar ficha!-------------------------------//
    public void updateChip(int index, int pos){
        if(index == 1){
            player1.setLocation(createGame.getPropiedades(pos).getPosX(),createGame.getPropiedades(pos).getPosY()+10);
        } else {
            player2.setLocation(createGame.getPropiedades(pos).getPosX(),createGame.getPropiedades(pos).getPosY()+10);
        }
        validarPropiedad();
    }//fin de la funcion
    
    //----------------------Funcion validar casilla---------------------------//
    
    public void validarPropiedad(){
        String dueño = this.createGame.getPropiedades(this.getCurrentProperty()).getDueño();
        String[] opcionesIniciales = {"Comprar", "Avanzar"};
        int posicionActual = this.createGame.getPersonaPosicion(this.getCurrentPosition());
        System.out.println(this.createGame.getPropiedades(posicionActual).getDueño());
        if(this.createGame.getPropiedades(posicionActual).getDueño()==""){
                    log(this.createGame.getNameJug(this.returnControl())+", seleccione una opcion de las habilitadas.");
                    Avanzar.setEnabled(true);
                    Comprar.setEnabled(true);
        }
        
        if(dueño!="" && dueño != getCurrentPlayerName()){
           setDinero();
                log(this.createGame.getNameJug(this.getCurrentPosition())+" debe de pagar: "+this.createGame.getPropiedades(this.getCurrentProperty()).getRenta()+" por el alquiler de la propiedad");
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
        if(Accions.equals("Comprar")){
            if(dueño ==""){
                this.createGame.getPropiedades(this.getCurrentProperty()).setDueño(this.createGame.getJugador(this.returnControl()).getNombreP());
                this.setDinero();
                log(this.createGame.getPropiedades(this.getCurrentProperty()).getDueño() +" ha comprado a la propiedad: "+this.createGame.getPropiedades(this.getCurrentProperty()).getNombre());
                this.updateMoney();
                this.createGame.getJugador(this.getCurrentPosition()).setCantPropiedades("datos");
                this.updatePropiedades();
            } else {
                log("Esta propiedad ya ha sido comprada por: "+this.createGame.getPropiedades(this.getCurrentProperty()).getDueño());
            }
            
        } 
        
    }
    //--------------setear el dinero del jugador---------------------------------------//
    public void setDinero(){
        this.createGame.getJugador(this.getCurrentPosition()).setDinero(this.createGame.getJugador(this.getCurrentPosition()).getDinero()-this.createGame.getPropiedades(this.getCurrentProperty()).getRenta());
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
        String[] choicesHotel = {"Agregar Casa", "Agregar hotel","Mejorar Propiedad", "Avanzar"};
        String[] choicesCondominio = {"Agregar Casa", "Agregar hotel","Agregar Condominio","Mejorar Propiedad","Avanzar"};
        String[] finalChoice =choicesCasa;
        if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas() <=0){
            finalChoice=choicesCasa;
        }  else if(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas()>0){
            finalChoice = choicesHotel;
        }  
        String picked = (String)JOptionPane.showInputDialog(this, "Seleccione una opcion", "Opciones de propiedad", JOptionPane.INFORMATION_MESSAGE, null, finalChoice, finalChoice[0]);
        secondAction(picked);
    }
    
    //-------------------------------funcion para el caluclo de alquiler de acuerdo a casa y hotel---------------/
    public void secondAction(String texto){
        if(texto.equals("Agregar Casa")){
            this.createGame.getPropiedades(this.getCurrentProperty()).setCantCasas(this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas() +1);
            log("Una Casa ha sido comprada, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantCasas()+" casa(s)");

        } else 
            if (texto.equals("Agregar hotel")){
                this.createGame.getPropiedades(this.getCurrentProperty()).setCantHoteles(this.createGame.getPropiedades(this.getCurrentProperty()).getCantHoteles()+1);
                log("Un Hotel ha sido comprado, esta propiedad posee: "+this.createGame.getPropiedades(this.getCurrentProperty()).getCantHoteles()+" hotel(es)");
            }
    }
    
    
    //-----------------------Retornar quien juega------------------------------------------------//
    
    public int getCurrentPosition(){
        return returnControl();
    }
   
    public int getNextPlayer(){
        return this.control;
    }
    //---------------------------------------- actualizar el dinero----------------------------------------//
    public void updateMoney(){
        if(this.getCurrentPosition()==0){
             dinero.setText("Dinero Actual:"+this.createGame.getJugador(0).getDinero());
        } else {
             dinero2.setText("Dinero Actual:"+this.createGame.getJugador(1).getDinero());
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
                    jLabel5.setText("Espacios a mover: "+Resultado);
                    clickLanzar(Resultado);
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
        table = new javax.swing.JLabel();
        Avanzar = new javax.swing.JButton();
        Comprar = new javax.swing.JButton();
        More = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lanzar = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        propiedades = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        nombre2 = new javax.swing.JLabel();
        dinero2 = new javax.swing.JLabel();
        propiedades2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        logText = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fichachrome2.png"))); // NOI18N

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fichachrome1.png"))); // NOI18N
        player1.setToolTipText("");

        table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/table.png"))); // NOI18N

        Avanzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avanzar_1.png"))); // NOI18N
        Avanzar.setToolTipText("Terminar turno");
        Avanzar.setBorderPainted(false);
        Avanzar.setContentAreaFilled(false);
        Avanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Avanzar.setEnabled(false);

        Comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        Comprar.setToolTipText("Comprar esta propiedad");
        Comprar.setBorderPainted(false);
        Comprar.setContentAreaFilled(false);
        Comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Avanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(More, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(player1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(table)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(player1)
                            .addComponent(player2))
                        .addGap(214, 214, 214))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Comprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Avanzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(More, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jInternalFrame1.setBackground(java.awt.Color.white);
        jInternalFrame1.setVisible(true);

        lanzar.setText("Lanzar");
        lanzar.setToolTipText("Lanzar");

        jugar.setText("Jugar");
        jugar.setToolTipText("Jugar");
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
                .addComponent(jugar)
                .addGap(32, 32, 32)
                .addComponent(lanzar)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lanzar))
                    .addComponent(jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addContainerGap(58, Short.MAX_VALUE))
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
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane3)
                    .addComponent(jTabbedPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(logText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Jugador 1");
        jTabbedPane2.getAccessibleContext().setAccessibleName("Jugador 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel1))
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
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
        
        if (buttonText.equals("Jugar")){
            log("El Juego ha iniciado");
            startGame();
            jugar.setEnabled(false);
        }
        
        if (buttonText.equals("Lanzar")){
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
        
        
    }//Fin del listener
}
