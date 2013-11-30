/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appletexample;

import Main.Main;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.xml.sax.Attributes;

public class Example extends javax.swing.JApplet implements ActionListener {

    /**
     * Initializes the applet Example
     */
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
                    Main createGame=new Main();
                    createGame.createGame();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jButton4.addActionListener(this);
        jButton5.addActionListener(this);
    }
    
   

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

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

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/start.gif"))); // NOI18N
        jPanel2.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 595, 139, -1));

        wikipedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wikipedia.gif"))); // NOI18N
        jPanel2.add(wikipedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 595, -1, -1));

        LeerCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leerCarta.gif"))); // NOI18N
        jPanel2.add(LeerCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 595, -1, -1));

        ask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ask.gif"))); // NOI18N
        jPanel2.add(ask, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 595, -1, -1));

        blogspot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blogspot.gif"))); // NOI18N
        jPanel2.add(blogspot, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 595, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jotspot.gif"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 595, -1, -1));

        impuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impuestos.gif"))); // NOI18N
        jPanel2.add(impuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 595, 70, -1));

        android.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/android.gif"))); // NOI18N
        jPanel2.add(android, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 595, -1, -1));

        parqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parqueo.gif"))); // NOI18N
        jPanel2.add(parqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 595, -1, -1));

        drupal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drupal.gif"))); // NOI18N
        jPanel2.add(drupal, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 517, -1, -1));

        carta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carta2.gif"))); // NOI18N
        jPanel2.add(carta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 378, -1, 67));

        wordpress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wordpress.gif"))); // NOI18N
        jPanel2.add(wordpress, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 304, -1, -1));

        opera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/opera.gif"))); // NOI18N
        jPanel2.add(opera, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 228, -1, -1));

        fundacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/funadcion.gif"))); // NOI18N
        jPanel2.add(fundacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 11, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/opera.gif"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 150, -1, -1));

        IE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IE.gif"))); // NOI18N
        jPanel2.add(IE, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 11, -1, -1));

        mozilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mozilla.gif"))); // NOI18N
        jPanel2.add(mozilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 11, -1, -1));

        leerCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta3.gif"))); // NOI18N
        jPanel2.add(leerCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 11, -1, -1));

        paypal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Paypal.gif"))); // NOI18N
        jPanel2.add(paypal, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 11, -1, -1));

        impuestosArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impuestos2.gif"))); // NOI18N
        jPanel2.add(impuestosArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 11, -1, -1));

        skype.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Skype.gif"))); // NOI18N
        jPanel2.add(skype, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 11, -1, -1));

        leerCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta3.gif"))); // NOI18N
        jPanel2.add(leerCarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 11, -1, -1));

        jail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Jail.gif"))); // NOI18N
        jPanel2.add(jail, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 11, -1, -1));

        eBay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ebay.gif"))); // NOI18N
        jPanel2.add(eBay, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 148, -1, -1));

        developer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Premio2.gif"))); // NOI18N
        jPanel2.add(developer, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 225, -1, -1));

        amazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Amazon.gif"))); // NOI18N
        jPanel2.add(amazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 300, -1, -1));

        carta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Carta4.gif"))); // NOI18N
        jPanel2.add(carta, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 375, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Oracle.gif"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 450, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Microsoft.gif"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 525, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drupal.gif"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 440, -1, -1));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jInternalFrame1.getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 280, 10));

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

        jInternalFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 180, -1));

        jLabel5.setText("Dados:");
        jInternalFrame1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 192, 44));
        jInternalFrame1.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 160));

        jLabel9.setText("Nombre:");
        jTabbedPane1.addTab("Jugador 2", jLabel9);

        jInternalFrame1.getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, 170));

        jLabel8.setText("Nombre:");
        jTabbedPane2.addTab("Jugador 1", jLabel8);

        jLabel10.setText("jLabel10");
        jTabbedPane3.addTab("tab1", jLabel10);

        jTabbedPane2.addTab("tab2", jTabbedPane3);

        jInternalFrame1.getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 170));
        jInternalFrame1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 90, 110));
        jInternalFrame1.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 90, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        /*        dados tirar = new dados();
        int numDado = tirar.calculaNumero();
        int numDado2 = tirar.calculaNumero();
        int Resultado = numDado+numDado2;
        imagene imagen = new imagene();
        jLabel5.setIcon(imagen.gifDado(numDado));
        jLabel5.setText("Espacios a mover: "+Resultado);*/
        // JOptionPane.showMessageDialog(rootPane,"alerta");
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel jail;
    private javax.swing.JLabel leerCarta;
    private javax.swing.JLabel leerCarta2;
    private javax.swing.JLabel mozilla;
    private javax.swing.JLabel opera;
    private javax.swing.JLabel parqueo;
    private javax.swing.JLabel paypal;
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
            dados tirar = new dados();
            imagene image = new imagene();
            int numDado = tirar.calculaNumero();
            int numDado2 = tirar.calculaNumero();
            try {
                animarGif();
                Thread.sleep(3000);
            } catch(Exception ex) {
                
            }
            jLabel11.setIcon(image.gifDado(numDado));
            
            jLabel12.setIcon(image.gifDado(numDado2));
            int Resultado = numDado+numDado2;
            jLabel5.setText("Espacios a mover: "+Resultado);
        }
    }
    public void animarGif(){
        imagene image = new imagene();
        jLabel11.setIcon(image.gifDado(0));
    }
}
