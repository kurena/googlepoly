

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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
        
    }
    
    public void loadData(){
        createGame.createAndAskNames();
        nombre.setText(createGame.getNameJug(0));
        nombre2.setText(createGame.getNameJug(1));
        dinero.setText("Dinero Actual:"+createGame.obtenerDineroJug(0));
        dinero2.setText("Dinero Actual:"+createGame.obtenerDineroJug(1));
    }
    
    public void startGame(){
        loadData();        
    }
    
    public int validarDado(int posicion){
        int returning = posicion;
        if(posicion > 30){
            returning = posicion - 30;
        }
        return returning;
    }
    
    
    public void clickLanzar(int valor){
       int move = valor;
       int finalMove;
        if(this.control == 0){
            finalMove = createGame.getPersonaPosicion(0) + move;
            System.out.println("val1:"+validarDado(finalMove));
            createGame.setPersonaPosicion(0,validarDado(finalMove));
            updateChip(1,createGame.getPersonaPosicion(0));
            this.control=1;
            
        } else {
            finalMove = createGame.getPersonaPosicion(1) + move;
            System.out.println("val2:"+validarDado(finalMove));
            createGame.setPersonaPosicion(1,validarDado(finalMove));
            updateChip(0,createGame.getPersonaPosicion(1));
            this.control=0;
            
        }
    }//cerrar clicklnzar
    
    public void updateChip(int index, int pos){
        if(index == 1){
            player1.setLocation(createGame.getPropiedades(pos).getPosX(),createGame.getPropiedades(pos).getPosY());
        } else {
            player2.setLocation(createGame.getPropiedades(pos).getPosX(),createGame.getPropiedades(pos).getPosY());
        }
    }
    public int moverDado(){
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
            return movimiento;
    }
 
    public void log(String text){
        log.setText(log.getText()+"\n\n"+text);
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        start = new javax.swing.JLabel();
        wikipedia = new javax.swing.JLabel();
        LeerCarta = new javax.swing.JLabel();
        ask = new javax.swing.JLabel();
        blogspot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        impuestos = new javax.swing.JLabel();
        android = new javax.swing.JLabel();
        parqueo = new javax.swing.JLabel();
        drupal = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        wordpress = new javax.swing.JLabel();
        opera = new javax.swing.JLabel();
        fundacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IE = new javax.swing.JLabel();
        mozilla = new javax.swing.JLabel();
        leerCarta = new javax.swing.JLabel();
        paypal = new javax.swing.JLabel();
        impuestosArriba = new javax.swing.JLabel();
        skype = new javax.swing.JLabel();
        leerCarta2 = new javax.swing.JLabel();
        jail = new javax.swing.JLabel();
        eBay = new javax.swing.JLabel();
        developer = new javax.swing.JLabel();
        amazon = new javax.swing.JLabel();
        carta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        nombre2 = new javax.swing.JLabel();
        dinero2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();

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

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/start.gif"))); // NOI18N

        wikipedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wikipedia.gif"))); // NOI18N

        LeerCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leerCarta.gif"))); // NOI18N

        ask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ask.gif"))); // NOI18N

        blogspot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blogspot.gif"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jotspot.gif"))); // NOI18N

        impuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impuestos.gif"))); // NOI18N

        android.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/android.gif"))); // NOI18N

        parqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parqueo.gif"))); // NOI18N

        drupal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drupal.gif"))); // NOI18N

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carta2.gif"))); // NOI18N

        wordpress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wordpress.gif"))); // NOI18N

        opera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/opera.gif"))); // NOI18N

        fundacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/funadcion.gif"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/opera.gif"))); // NOI18N

        IE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IE.gif"))); // NOI18N

        mozilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mozilla.gif"))); // NOI18N

        leerCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta3.gif"))); // NOI18N

        paypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Paypal.gif"))); // NOI18N

        impuestosArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impuestos2.gif"))); // NOI18N

        skype.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Skype.gif"))); // NOI18N

        leerCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta3.gif"))); // NOI18N

        jail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Jail.gif"))); // NOI18N

        eBay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ebay.gif"))); // NOI18N

        developer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Premio2.gif"))); // NOI18N

        amazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Amazon.gif"))); // NOI18N

        carta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta4.gif"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Oracle.gif"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft.gif"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drupal.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(IE))
                                    .addComponent(fundacion))
                                .addGap(69, 69, 69)
                                .addComponent(leerCarta))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(mozilla))
                            .addComponent(jLabel3)
                            .addComponent(opera)
                            .addComponent(wordpress)
                            .addComponent(carta2)
                            .addComponent(drupal)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(blogspot))
                            .addComponent(parqueo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(android))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(impuestosArriba)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(skype)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(amazon))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(leerCarta2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(jail))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(developer))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(eBay))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(impuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ask)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(wikipedia))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(LeerCarta))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(carta))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(paypal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IE)
                    .addComponent(fundacion)
                    .addComponent(leerCarta)
                    .addComponent(mozilla))
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opera)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(wordpress))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(drupal)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blogspot)
                    .addComponent(parqueo)
                    .addComponent(android)
                    .addComponent(jLabel2)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(impuestosArriba)
                            .addComponent(skype)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(amazon))
                            .addComponent(leerCarta2)
                            .addComponent(jail)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(developer))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(eBay)))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(impuestos))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(ask))
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(wikipedia))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(start))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(LeerCarta))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(carta))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jLabel7))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(paypal))
        );

        jInternalFrame1.setVisible(true);

        jButton5.setText("Lanzar");

        jButton4.setText("Jugar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(32, 32, 32)
                .addComponent(jButton5)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setText("Dados:");

        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombre.setText("Nombre:");

        dinero.setText("Dinero:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre)
                    .addComponent(dinero))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dinero)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nombre2.setText("Nombre:");

        dinero2.setText("Dinero:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre2)
                    .addComponent(dinero2))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dinero2)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel4);

        log.setColumns(20);
        log.setRows(5);
        log.setEnabled(false);
        jScrollPane1.setViewportView(log);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(130, 130, 130))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jTabbedPane2)
                    .addComponent(jTabbedPane3))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Jugador 1");
        jTabbedPane2.getAccessibleContext().setAccessibleName("Jugador 2");

        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/player1.png"))); // NOI18N

        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/player2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(player1)
                        .addGap(121, 121, 121)
                        .addComponent(player2)))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInternalFrame1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1)
                    .addComponent(player2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IE;
    private javax.swing.JLabel LeerCarta;
    private javax.swing.JLabel amazon;
    private javax.swing.JLabel android;
    private javax.swing.JLabel ask;
    private javax.swing.JLabel blogspot;
    private javax.swing.JLabel carta;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel developer;
    private javax.swing.JLabel dinero;
    private javax.swing.JLabel dinero2;
    private javax.swing.JLabel drupal;
    private javax.swing.JLabel eBay;
    private javax.swing.JLabel fundacion;
    private javax.swing.JLabel impuestos;
    private javax.swing.JLabel impuestosArriba;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel jail;
    private javax.swing.JLabel leerCarta;
    private javax.swing.JLabel leerCarta2;
    private javax.swing.JTextArea log;
    private javax.swing.JLabel mozilla;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel opera;
    private javax.swing.JLabel parqueo;
    private javax.swing.JLabel paypal;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel skype;
    private javax.swing.JLabel start;
    private javax.swing.JLabel wikipedia;
    private javax.swing.JLabel wordpress;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton b = null;
        String buttonText = "";

        if(o instanceof JButton)
          b = (JButton)o;

        if(b != null)
            buttonText = b.getText();
        if (buttonText.equals("Jugar")){
            startGame();
        }
        if (buttonText.equals("Lanzar")){
           moverDado();          
        }
    }
}
