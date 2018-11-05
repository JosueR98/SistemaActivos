/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.funcionarios;

import activos.logic.Funcionario;
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
public class FuncionariosView extends javax.swing.JFrame implements Observer{

    FuncionariosController controller;
    FuncionariosModel model;

    public FuncionariosController getController() {
        return controller;
    }

    public void setController(FuncionariosController controller) {
        this.controller = controller;
        
    }

    public FuncionariosModel getModel() {
        return model;
    }

    public void setModel(FuncionariosModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    public FuncionariosView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Agregar nuevo funcionario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        model.getAgregarView().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setTitle("Funcionarios");
        try {
            verTablaFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionariosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verTablaFuncionarios() throws SQLException{
        model.cargarLista();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Cedula");
        tabla.addColumn("Nombre");
        tabla.addColumn("Correo");
        
        String[] row = new String[3];
        for(Funcionario funcionario : model.getFuncionarios()){
            row[0] = "" + funcionario.getCedula();
            row[1] = funcionario.getNombre();
            row[2] = funcionario.getCorreo();
            tabla.addRow(row);
         }
       this.jTable1.setModel(tabla);
       
    }
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
