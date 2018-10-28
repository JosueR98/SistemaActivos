/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.adminPresentation.verEspecifica;

import java.awt.Graphics;
import java.sql.SQLException;
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
public class verView extends javax.swing.JFrame implements Observer {

    private verModel model;
    private verController controller;

    
    /**
     * Creates new form verView
     */
    public verView() {
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

        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        MontoTotal = new javax.swing.JTextField();
        CantidadBienes = new javax.swing.JTextField();
        Estado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Codigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        rechazar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tipo = new javax.swing.JTextField();
        motivoCLABEL = new javax.swing.JLabel();
        motivoC = new javax.swing.JTextField();

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Solicitud #");

        jLabel2.setText("Fecha :");

        jLabel3.setText("Cantidad de bienes :");

        jLabel4.setText("Monto total :");

        jLabel6.setText("Estado : ");

        jLabel7.setText("Lista de bienes :");

        Fecha.setEditable(false);

        MontoTotal.setEditable(false);

        CantidadBienes.setEditable(false);
        CantidadBienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadBienesActionPerformed(evt);
            }
        });

        Estado.setEditable(false);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        Codigo.setEditable(false);
        Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoActionPerformed(evt);
            }
        });

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        rechazar.setText("Rechazar");
        rechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo :");

        tipo.setEditable(false);
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        motivoCLABEL.setText("Motivo cancelacion : ");

        motivoC.setEditable(false);
        motivoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(204, 204, 204)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(CantidadBienes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                                            .addComponent(MontoTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Fecha, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(34, 34, 34))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(motivoCLABEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tipo, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                                            .addComponent(Estado, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(motivoC, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(34, 34, 34)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CantidadBienes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoCLABEL)
                    .addComponent(motivoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CantidadBienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadBienesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadBienesActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        model._controladorPadre.getView().setVisible(true);
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        model.getSolicitud().setEstado(3);
        try {
            activos.data.SolicitudesDB.aceptar(model.getSolicitud().getCodigoSolicitud());
        } catch (SQLException ex) {
            Logger.getLogger(verView.class.getName()).log(Level.SEVERE, null, ex);
        }
     //   this.model._controladorPadre.getView().update(model, evt);
        this.setVisible(false);
        model._controladorPadre.getView().setVisible(true);
    }//GEN-LAST:event_AceptarActionPerformed

    private void rechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazarActionPerformed
        // TODO add your handling code here:
        String razon;
        razon= JOptionPane.showInputDialog("Digite el motivo del rechazo");
        model.getSolicitud().setMotivoC(razon);
        model.getSolicitud().setEstado(2);
        try {
            activos.data.SolicitudesDB.reclinar(model.getSolicitud().getCodigoSolicitud(), razon);
        } catch (SQLException ex) {
            Logger.getLogger(verView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        model._controladorPadre.getView().setVisible(true);
    }//GEN-LAST:event_rechazarActionPerformed

    private void motivoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motivoCActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    /**
     * @param args the command line arguments
     */
    @Override
    public void paint(Graphics g){
       super.paint(g);
       this.setTitle("Ver Especifica");
       
       if(activos.loginPresentation.loginModel.getUsuarioActual().getTipoUsuario()!= 2){
           Aceptar.setVisible(false);
           rechazar.setVisible(false);
       }
       this.CantidadBienes.setText("" + model.getSolicitud().getCantidad_bienes());
       this.Codigo.setText("" + model.getSolicitud().getCodigoSolicitud());
    
       String _estado = "";
          switch(model.getSolicitud().getEstado()){
                    case 1: _estado = "Recibida"; break;
                    case 2: _estado = "Por verificar";break;
                    case 3: _estado = "Cancelada";break;
                    case 4: _estado = "Procesada";break;
                    case 5: _estado = "Espera de rotulacion";break;
                }
       this.Estado.setText(_estado);
       this.Fecha.setText(model.getSolicitud().getFecha().toString());
       this.MontoTotal.setText("" + model.getSolicitud().getMontoTotal());
       int _tipo =  model.getSolicitud().getTipo();
       System.out.print(model.getSolicitud().getTipo());
       String tipoS = "";
                switch(_tipo){
                    case 1: tipoS = "Compra"; break;
                    case 2: tipoS = "Donacion"; break;
                    case 3: tipoS = "Produccion"; break;
                }
       this.tipo.setText(tipoS);
       
       if(model.getSolicitud().getEstado() != 3){
           this.motivoC.setVisible(false);
           this.motivoCLABEL.setVisible(false);
       }else{
           this.motivoC.setText(model.getSolicitud().getMotivoC());
       }
       cargarTablaBienes();
       
     
    }
    void setController(verController aThis) {
        this.controller = aThis;
    }

    void setModel(verModel verModel) {
        this.model = verModel;
         verModel.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
       this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField CantidadBienes;
    private javax.swing.JTextField Codigo;
    private javax.swing.JTextField Estado;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField MontoTotal;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField motivoC;
    private javax.swing.JLabel motivoCLABEL;
    private javax.swing.JButton rechazar;
    private javax.swing.JTextField tipo;
    // End of variables declaration//GEN-END:variables

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
        modelo.addColumn("Registrador Asignado");
        String[] datos = new String[6];

        this.Tabla.setModel(modelo);
            
     
     
        if(!model.getSolicitud().getLista_bienes().isEmpty()){
        
        for(int i=0; i<model.getSolicitud().getLista_bienes().size(); i++) {
            datos[0] = "" + model.getSolicitud().getLista_bienes().get(i).getCodigo();
            datos[1] =  model.getSolicitud().getLista_bienes().get(i).getDescripcion();
            datos[2] =  model.getSolicitud().getLista_bienes().get(i).getMarca();
            datos[3] =  model.getSolicitud().getLista_bienes().get(i).getModelo();
            datos[4] = "" +  model.getSolicitud().getLista_bienes().get(i).getPrecio_unitario();
            if(model.getSolicitud().getLista_bienes().get(i).getRegistrador() != null){
            datos[5] = "" + model.getSolicitud().getLista_bienes().get(i).getRegistrador().getId();
            }else
                datos[5] = "No Asignado";
            
            modelo.addRow(datos);
 
        }   
    }else
            System.out.print("Hola");
    

    }
    
  
}

