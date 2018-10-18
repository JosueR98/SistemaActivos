/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaactivos.loginPresentation;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemaactivos.logic.Usuario;

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
      
    public void setController(loginController controller){
        this.controller=controller;
    }

    public loginController getController() {
        return controller;
    }
    
    public void setModel(loginModel model){
        this.model=model;
         model.addObserver(this);
    }

    public loginModel getModel() {
        return model;
    }
    
    @Override
    public void paint(Graphics r){
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
        ClaveTextField = new javax.swing.JTextField();
        IngresarButton = new javax.swing.JButton();
        SalirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLabel.setText("ID : ");

        ClaveLabel.setText("Clave :");

        IngresarButton.setText("Ingresar");
        IngresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarButtonActionPerformed(evt);
            }
        });

        SalirButton.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(ClaveLabel))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClaveTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(idTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(IngresarButton)
                        .addGap(37, 37, 37)
                        .addComponent(SalirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClaveLabel)
                    .addComponent(ClaveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresarButton)
                    .addComponent(SalirButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarButtonActionPerformed
        String id = this.idTextField.getText();
        String clave = this.ClaveTextField.getText();
        Usuario _user = controller.validar(id, clave);
        if(_user != null){
            try {
                controller.login(_user);
                JOptionPane.showMessageDialog(rootPane, "Ingresado Correctamente");
                 
                switch(_user.getTipoUsuario()){
                    case 1: controller.ingresoAdmin(); break;
                    // case para cada tipo de usuario
                }
            } catch (Exception ex) {
                Logger.getLogger(loginView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
          JOptionPane.showMessageDialog(rootPane, "Clave Incorrecta");
        }
    }//GEN-LAST:event_IngresarButtonActionPerformed
  
    
    
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClaveLabel;
    private javax.swing.JTextField ClaveTextField;
    private javax.swing.JButton IngresarButton;
    private javax.swing.JButton SalirButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    // End of variables declaration//GEN-END:variables
}
