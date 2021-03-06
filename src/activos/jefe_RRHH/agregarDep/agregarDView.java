/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.jefe_RRHH.agregarDep;

import activos.logic.Dependencia;
import activos.logic.Funcionario;
import activos.logic.Puesto;
import activos.logic.Usuario;
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
public class agregarDView extends javax.swing.JFrame implements Observer {

    agregarDModel model;
    agregarDController controller;

    public agregarDModel getModel() {
        return model;
    }

    public void setModel(agregarDModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public agregarDController getController() {
        return controller;
    }

    public void setController(agregarDController controller) {
        this.controller = controller;
    }
    
    
    public agregarDView() {
        initComponents();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setTitle("Agregar nueva dependencia");
        try {
            cargarTablaFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(agregarDView.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        nombreD = new javax.swing.JTextField();
        CodigoD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncionarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        UbicacionD = new javax.swing.JTextField();
        idADMIN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        claveAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de la dependencia :");

        nombreD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreDActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo :");

        tablaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaFuncionarios);

        jLabel3.setText("Ubicacion de la dependencia :");

        jLabel4.setText("Ingrese los datos del administrador de la nueva dependencia :");

        jLabel5.setText("ID");

        jLabel6.setText("Clave");

        jLabel7.setText("Seleccione el funcionario al que quieres delegar ese cargo :");

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CodigoD)
                                            .addComponent(nombreD)
                                            .addComponent(UbicacionD)
                                            .addComponent(idADMIN)
                                            .addComponent(claveAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodigoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(UbicacionD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(claveAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.atras();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nombreDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nombre,ubicacion,id,clave;
        int codigo,rowIndex,codigoF;
        Funcionario _funcionario = null;
        Usuario user = null;
        codigo = Integer.parseInt((String)this.CodigoD.getText());
        nombre = this.nombreD.getText();
        ubicacion = this.UbicacionD.getText();
        Dependencia depe= new Dependencia(codigo,nombre,ubicacion);
        try {
            activos.data.DependenciasDB.add(depe);
        } catch (Exception ex) {
            Logger.getLogger(agregarDView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            rowIndex = this.tablaFuncionarios.getSelectedRow();
            codigoF = Integer.parseInt((String) this.tablaFuncionarios.getValueAt(rowIndex, 0));
            _funcionario = activos.data.FuncionariosDB.get(codigoF);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Debiste haber seleccionado una dependencia");
            controller.atras();
            return;
        }
         id = this.idADMIN.getText();
         clave = this.claveAdmin.getText();
         
         user = new Usuario(id,clave,1,_funcionario,depe);
        try {
            activos.data.UsuariosDB.add(user);
        } catch (Exception ex) {
            Logger.getLogger(agregarDView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Puesto puesto = new Puesto(0,"Administrador dependencia " + depe.getNombre(),_funcionario,depe);
        try {
            activos.data.PuestosDB.add(puesto);
        } catch (Exception ex) {
            Logger.getLogger(agregarDView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(rootPane, "Dependencia agregada correctamente");
        controller.atras();
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
       this.repaint();
    }

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodigoD;
    private javax.swing.JTextField UbicacionD;
    private javax.swing.JTextField claveAdmin;
    private javax.swing.JTextField idADMIN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreD;
    private javax.swing.JTable tablaFuncionarios;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaFuncionarios() throws SQLException {
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
        this.tablaFuncionarios.setModel(tabla);
        this.tablaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.tablaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.tablaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
}
