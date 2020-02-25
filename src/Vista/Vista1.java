/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Builder.Builder;
import Builder.ConstructorElfo;
import Builder.ConstructorHumano;
import Builder.ConstructorOrco;

   
import Builder.Elfo;
import Builder.Personaje;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Juan David
 */
public class Vista1 extends javax.swing.JFrame implements KeyListener{

    ArrayList<Personaje> p = new ArrayList<>();
    public static JLabel Imagen = new JLabel();
    
     
    int aux=0;  
    
    public Vista1(Personaje per) {
        initComponents();
        Imagen.setBounds(50, 50, 200, 200);
        panel.add(Imagen);
        System.out.print(aux);
        per.setPanel(panel);
        this.p.add(per);
        this.p.add(per.clone());
        
        this.p.get(1).setDesplazamientoVertical(200);
       
        panel.add(this.p.get(0));
        panel.add(this.p.get(1));
        panel.add(Imagen);
        

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

  

     @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) { 
            case KeyEvent.VK_RIGHT:
                p.get(0).derecha();
                p.get(1).derecha();
               
                break;
            case KeyEvent.VK_LEFT:
                p.get(0).izquierda();
                p.get(1).izquierda();
               
                break;
            case KeyEvent.VK_UP:
                p.get(0).saltar();
                p.get(1).saltar();
             
                break;
            case KeyEvent.VK_X:
                p.get(0).atacar();
                p.get(1).atacar();
               
                break;
            case KeyEvent.VK_Z:
                p.get(0).morir();
                p.get(1).morir();
            
                break;
            
            default:
                break;
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        BotonClonar = new javax.swing.JButton();
        BotonPoder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        BotonClonar.setText("Clonar");
        BotonClonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClonarActionPerformed(evt);
            }
        });

        BotonPoder.setText("Poder");
        BotonPoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPoderActionPerformed(evt);
            }
        });
        BotonPoder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KP(evt);
            }
        });

        BotonClonar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KP(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonClonar)
                    .addComponent(BotonPoder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(BotonClonar)
                .addGap(189, 189, 189)
                .addComponent(BotonPoder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotonClonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClonarActionPerformed(evt);
            }
        });
        BotonClonar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KP(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonClonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClonarActionPerformed
        aux++;
    }//GEN-LAST:event_BotonClonarActionPerformed

    private void BotonPoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPoderActionPerformed
        Imagen.setBounds(50, 50, 300, 300);
    }//GEN-LAST:event_BotonPoderActionPerformed
    
    private void KP(java.awt.event.KeyEvent evt) {                                      
        keyPressed(evt);
    } 
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonClonar;
    private javax.swing.JButton BotonPoder;
    public javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void CorrerSonido(){
        AudioClip sonido = null; //Quitar el null
        //int n = Componentes.size()-1; 
        //sonido = java.applet.Applet.newAudioClip(getClass().getResource(Componentes.get(n)));
        sonido.play();
    }

 
}
