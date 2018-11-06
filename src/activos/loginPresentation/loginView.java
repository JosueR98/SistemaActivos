/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.loginPresentation;

import activos.logic.Dependencia;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import activos.logic.Usuario;

/**
 *
 * @author Josue R
 */
public class loginView extends javax.swing.JFrame implements Observer {

    private loginController controller;
    private loginModel model;

    public loginView() {
        initComponents();

    }

    public void setController(loginController controller) {
        this.controller = controller;
    }

    public loginController getController() {
        return controller;
    }

    public void setModel(loginModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public loginModel getModel() {
        return model;
    }

    @Override
    public void paint(Graphics r) {
        super.paint(r);
        this.setTitle("LOG IN");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        ClaveLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        IngresarButton = new javax.swing.JButton();
        SalirButton = new javax.swing.JButton();
        ClaveTextField = new javax.swing.JPasswordField();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(550, 300));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("ID : ");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        ClaveLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClaveLabel.setForeground(new java.awt.Color(255, 255, 255));
        ClaveLabel.setText("Clave :");
        getContentPane().add(ClaveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        idTextField.setText("jefe_RRHH");
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, -1));

        IngresarButton.setText("Ingresar");
        IngresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(IngresarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        SalirButton.setText("Salir");
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SalirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 73, -1));

        ClaveTextField.setText("eeee");
        ClaveTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ClaveTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 180, -1));

        FONDO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FONDO.setForeground(new java.awt.Color(255, 255, 255));
        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButtonActionPerformed
        String id = this.idTextField.getText();
        String clave = this.ClaveTextField.getText();
        Usuario _user = null;
        try {
            _user = controller.validar(id, clave);
        } catch (Exception ex) {
            Logger.getLogger(loginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (_user != null) {
            try {
                controller.login(_user);
                //JOptionPane.showMessageDialog(rootPane, "Ingresado Correctamente");

                switch (_user.getTipoUsuario()) {
                    case 1:
                        controller.ingresoAdmin();
                        break;
                    case 2:
                        controller.ingresoAdmin();
                        break;
                    case 3:
                        controller.ingresoJefe();
                        break;
                    case 4:
                        controller.ingresoRegistrador();
                        break;
                    case 5:
                        controller.ingresoJefeRHHH();
                        break;
                    // case para cada tipo de usuario
                }
            } catch (Exception ex) {
                Logger.getLogger(loginView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Clave Incorrecta");
        }
    }//GEN-LAST:event_IngresarButtonActionPerformed

    private void SalirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirButtonActionPerformed
        // TODO add your handling code here:
        controller.exit();
    }//GEN-LAST:event_SalirButtonActionPerformed

    private void ClaveTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveTextFieldActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClaveLabel;
    private javax.swing.JPasswordField ClaveTextField;
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton IngresarButton;
    private javax.swing.JButton SalirButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    // End of variables declaration//GEN-END:variables
}
