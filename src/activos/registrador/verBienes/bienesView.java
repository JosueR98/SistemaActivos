/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.registrador.verBienes;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue R
 */
public class bienesView extends javax.swing.JFrame implements Observer {

    bienesModel model;
    bienesController controller;
    
    public bienesView() {
        initComponents();
    }

    public bienesModel getModel() {
        return model;
    }

    public void setModel(bienesModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public bienesController getController() {
        return controller;
    }

    public void setController(bienesController controller) {
        this.controller = controller;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setTitle("Bienes de la Solicitud");
        cargarTablaBienes();
    }
    
    
   private void cargarTablaBienes() {
    DefaultTableModel modelo = new DefaultTableModel(){

    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
};
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Precio Unitario");
        String[] datos = new String[5];

        this.jTable1.setModel(modelo);
            
     
        if(!model.getSolicitud().getLista_bienes().isEmpty()){
        
        for(int i=0; i<model.getBienes().size(); i++) {
            
            if(!model.getBienes().get(i).isEstaRegistrado()){
            datos[0]= Integer.toString(model.getBienes().get(i).getCodigo());
            datos[1] =  model.getBienes().get(i).getDescripcion();
            datos[2] =  model.getBienes().get(i).getMarca();
            datos[3] =  model.getBienes().get(i).getModelo();
            datos[4] = "" +  model.getBienes().get(i).getPrecio_unitario();
            modelo.addRow(datos);
            }
            
        }   
    }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(264, 264, 264))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.getModel().getControladorPadre().getView().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int rowIndex = 0;int codigo = 0;
        try{
         rowIndex = this.jTable1.getSelectedRow();
         codigo = Integer.parseInt((String) this.jTable1.getValueAt(rowIndex, 0));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "No has seleccionado ninguna celda.");
            return;
        }
        try {
            model.RegistrarTrio(codigo);
            model.getRmodel().setControllerPadre(controller);
            model.getRview().setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(bienesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.update(model, evt);
    }//GEN-LAST:event_jButton3ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       this.repaint();
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
