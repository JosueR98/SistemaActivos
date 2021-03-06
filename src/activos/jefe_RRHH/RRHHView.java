/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH;

import activos.logic.Dependencia;
import activos.logic.Funcionario;
import activos.logic.Puesto;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue R
 */
public class RRHHView extends javax.swing.JFrame implements Observer {

    RRHHController controller;
    RRHHModel model;
    int selectedOption = 1;

    public RRHHController getController() {
        return controller;
        
    }

    public void setController(RRHHController controller) {
        this.controller = controller;

    }

    public RRHHModel getModel() {
        return model;
    }

    public void setModel(RRHHModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public RRHHView() {
        initComponents();
         this.MostrarFuncionarios.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonAgregarFuncionario = new javax.swing.JButton();
        MostrarFuncionarios = new javax.swing.JButton();
        MostrarPuestos = new javax.swing.JButton();
        mostrarDependencias = new javax.swing.JButton();
        botonAgregarPuesto = new javax.swing.JButton();
        botonAgregarDependencia = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        botonAgregarFuncionario.setText("Agregar nuevo funcionario");
        botonAgregarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarFuncionarioActionPerformed(evt);
            }
        });

        MostrarFuncionarios.setBackground(new java.awt.Color(102, 153, 255));
        MostrarFuncionarios.setText("Funcionarios");
        MostrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarFuncionariosActionPerformed(evt);
            }
        });

        MostrarPuestos.setBackground(new java.awt.Color(102, 153, 255));
        MostrarPuestos.setText("Puestos");
        MostrarPuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarPuestosActionPerformed(evt);
            }
        });

        mostrarDependencias.setBackground(new java.awt.Color(102, 153, 255));
        mostrarDependencias.setText("Dependencias");
        mostrarDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarDependenciasActionPerformed(evt);
            }
        });

        botonAgregarPuesto.setText("Agregar nuevo Puesto");
        botonAgregarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPuestoActionPerformed(evt);
            }
        });

        botonAgregarDependencia.setText("Agregar nueva Dependencia");
        botonAgregarDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarDependenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MostrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MostrarPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarDependencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAgregarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(botonAgregarPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(botonAgregarDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MostrarFuncionarios)
                    .addComponent(MostrarPuestos)
                    .addComponent(mostrarDependencias))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarPuesto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(botonAgregarDependencia)))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarFuncionarioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        model.getAgregarFView().setVisible(true);
    }//GEN-LAST:event_botonAgregarFuncionarioActionPerformed

    private void MostrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarFuncionariosActionPerformed
        // TODO add your handling code here:
        this.selectedOption = 1;
        this.update(model, evt);
        this.jTable1.setModel(new DefaultTableModel());
        this.botonAgregarFuncionario.setVisible(true);
        this.botonAgregarPuesto.setVisible(false);
         this.botonAgregarDependencia.setVisible(false);
    }//GEN-LAST:event_MostrarFuncionariosActionPerformed

    private void MostrarPuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarPuestosActionPerformed
        // TODO add your handling code here:
        this.selectedOption = 2;
        this.update(model, evt);
        this.jTable1.setModel(new DefaultTableModel());
        this.botonAgregarFuncionario.setVisible(false);
        this.botonAgregarPuesto.setVisible(true);
         this.botonAgregarDependencia.setVisible(false);
    }//GEN-LAST:event_MostrarPuestosActionPerformed

    private void mostrarDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarDependenciasActionPerformed
        // TODO add your handling code here:
        this.selectedOption = 3;
        this.update(model, evt);
        this.jTable1.setModel(new DefaultTableModel());
        this.botonAgregarFuncionario.setVisible(false);
        this.botonAgregarPuesto.setVisible(false);
        this.botonAgregarDependencia.setVisible(true);
    }//GEN-LAST:event_mostrarDependenciasActionPerformed

    private void botonAgregarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPuestoActionPerformed
        // TODO add your handling code here:
        model.getAgregarPView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonAgregarPuestoActionPerformed

    private void botonAgregarDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarDependenciaActionPerformed
        // TODO add your handling code here:
        model.getAgregarDView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botonAgregarDependenciaActionPerformed

    @Override
    public void paint(Graphics g) {
        super.paint(g);
       
        this.jTable1.setModel(new DefaultTableModel());
        this.setTitle("Funcionarios");
        if (selectedOption == 1) {
            try {
                verTablaFuncionarios();
            } catch (SQLException ex) {
                Logger.getLogger(RRHHView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (selectedOption == 2) {
            try {
                verTablaPuestos();
            } catch (SQLException ex) {
                Logger.getLogger(RRHHView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(selectedOption == 3){
            try {
                verTablaDependencias();
            } catch (SQLException ex) {
                Logger.getLogger(RRHHView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void verTablaFuncionarios() throws SQLException {
        model.cargarListaFuncionarios();
        DefaultTableModel tabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.addColumn("Cedula");
        tabla.addColumn("Nombre");
        tabla.addColumn("Correo");

        String[] row = new String[3];
        for (Funcionario funcionario : model.getFuncionarios()) {
            row[0] = "" + funcionario.getCedula();
            row[1] = funcionario.getNombre();
            row[2] = funcionario.getCorreo();
            tabla.addRow(row);
        }
        this.jTable1.setModel(tabla);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);

    }

    private void verTablaPuestos() throws SQLException {

        model.cargarListaPuestos();
        DefaultTableModel tabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.addColumn("Codigo");
        tabla.addColumn("Rol");
        tabla.addColumn("Funcionario encargado");
        tabla.addColumn("Dependencia");

        String[] row = new String[4];
        for (Puesto puesto : model.getPuestos()) {
            row[0] = "" + puesto.getCodigo();
            row[1] = puesto.getRol();
            if (puesto.getFuncionario() != null) {
                row[2] = "" + puesto.getFuncionario().getCedula() + ": " + puesto.getFuncionario().getNombre();
            } else {
                row[2] = "Nadie";
            }
            if (puesto.getDependencia() != null) {
                row[3] = puesto.getDependencia().getNombre() + " (" + puesto.getDependencia().getUbicacion() + ") ";
            } else {
                row[3] = "Nadie";
            }
            tabla.addRow(row);
        }
        this.jTable1.setModel(tabla);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MostrarFuncionarios;
    private javax.swing.JButton MostrarPuestos;
    private javax.swing.JButton botonAgregarDependencia;
    private javax.swing.JButton botonAgregarFuncionario;
    private javax.swing.JButton botonAgregarPuesto;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mostrarDependencias;
    // End of variables declaration//GEN-END:variables

    private void verTablaDependencias() throws SQLException {
         model.cargarListaDependencias();
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Codigo Postal");
        tabla.addColumn("Nombre");
        tabla.addColumn("Localizacion");
        
        String[] row = new String[3];
        
        for(Dependencia dependencia : model.getDependencias()){
            row[0] = "" + dependencia.getCodigoPostal();
            row[1] = dependencia.getNombre();
            row[2] = dependencia.getUbicacion();
            tabla.addRow(row);
        }
        
        this.jTable1.setModel(tabla);
    }

}
