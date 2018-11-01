/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefePresentation;

import activos.data.RelDatabase;
import activos.logic.Solicitud;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés
 */
public class JefeView extends javax.swing.JFrame implements Observer {

    JefeController controller;
    JefeModel model;
    
    /**
     * Creates new form JefeView
     */
    public JefeView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setText("Agregar Registrador a la solicitud seleccionada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
        model.AgregarRTrio(codigo); 
       model.getARview().setVisible(true);
       model.getARmodel().setControladorPadre(controller);
       this.setVisible(false);
    } catch (Exception ex) {
    Logger.getLogger(JefeView.class.getName()).log(Level.SEVERE, null, ex);
}
    
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void paint(Graphics g){
        super.paint(g);
        this.setTitle("Jefe de la OCCB");
        try {
    muestraTabla();
    } catch (SQLException ex) {
        Logger.getLogger(JefeView.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(JefeView.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    private void muestraTabla() throws SQLException, Exception{
    RelDatabase r = new RelDatabase();
    
    List<Solicitud> solicitudes = activos.data.SolicitudesDB.getListaPorDependencia(model.getDependenciaActual());
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Codigo");
    modelo.addColumn("Fecha");
    modelo.addColumn("Precio Total");
    modelo.addColumn("Tipo");
    modelo.addColumn("Estado");
    
    String[] datos = new String[6];
    for(Solicitud solicitud : solicitudes){
        if(solicitud.getEstado() == 2){    
            datos[0] = "" + solicitud.getCodigoSolicitud();
            datos[1] = solicitud.getFecha().toString();
            datos[2] = "" + solicitud.getMontoTotal();
            int tipo =  solicitud.getTipo();
            switch(tipo){
                case 1: datos[3] = "Compra"; break;
                case 2: datos[3] = "Donacion"; break;
                case 3: datos[3] = "Produccion"; break;
                
            }
            int estado = solicitud.getEstado();
            switch(estado){
                case 1: datos[4] = "Recibida"; break;
                case 2: datos[4]= "Por verificar";break;
                case 3: datos[4] = "Cancelada";break;
                case 4: datos[4]= "Procesada";break;
                case 5: datos[4] = "Espera de rotulacion";break;
            }
            modelo.addRow(datos);
        }
    }
    
            this.jTable1.setModel(modelo);
            
            this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);

    
    
}

    public JefeController getController() {
        return controller;
    }

    public void setController(JefeController controller) {
        this.controller = controller;
    }

    public JefeModel getModel() {
        return model;
    }

    public void setModel(JefeModel model) {
        this.model = model;
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
