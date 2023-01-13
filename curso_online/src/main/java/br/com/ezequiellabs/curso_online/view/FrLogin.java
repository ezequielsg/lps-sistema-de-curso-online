package br.com.ezequiellabs.curso_online.view;

import br.com.ezequiellabs.curso_online.controller.AuthController;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.exceptions.UserException;
import br.com.ezequiellabs.curso_online.model.exceptions.UserNotFoundLoginException;
import br.com.ezequiellabs.curso_online.model.exceptions.WrongPasswordLoginException;
import javax.swing.JOptionPane;


public class FrLogin extends javax.swing.JFrame {

    
    AuthController authController;
    
    public FrLogin() {
        
        authController = new AuthController();
        
        
        initComponents();  
        
        
    }
    
    public void enableFields(boolean flag) {
        for (int i = 0; i < panForm.getComponents().length; i++) {
            panForm.getComponent(i).setEnabled(flag);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenuPrincipal = new javax.swing.JLabel();
        lblMenuPrincipal1 = new javax.swing.JLabel();
        panForm = new javax.swing.JPanel();
        lblSexo = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        jLogin = new javax.swing.JButton();
        edtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMenuPrincipal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal.setText("Curso Online");

        lblMenuPrincipal1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblMenuPrincipal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal1.setText("Entrar");

        lblSexo.setText("Usuário:");

        lblPassword.setText("Senha:");

        jLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLogin.setText("Entrar");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panFormLayout = new javax.swing.GroupLayout(panForm);
        panForm.setLayout(panFormLayout);
        panFormLayout.setHorizontalGroup(
            panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormLayout.createSequentialGroup()
                .addGroup(panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSexo)
                    .addComponent(lblPassword))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(edtPassword)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormLayout.createSequentialGroup()
                .addContainerGap(128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        panFormLayout.setVerticalGroup(
            panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenuPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMenuPrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        try { 
            this.enableFields(false);
            
            User user = authController.login(edtEmail.getText(), edtPassword.getText());
            
            if (user != null) {
                FrMemberArea screen = new FrMemberArea(null);
                screen.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Email ou senha inválidos!");
                this.enableFields(true);
            }
            
            
        } catch (UserNotFoundLoginException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum usuário com esse email!");
        } catch (WrongPasswordLoginException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Senha inválida!");
        } catch (UserException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        this.enableFields(true);


    }//GEN-LAST:event_jLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edtEmail;
    private javax.swing.JPasswordField edtPassword;
    private javax.swing.JButton jLogin;
    private javax.swing.JLabel lblMenuPrincipal;
    private javax.swing.JLabel lblMenuPrincipal1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JPanel panForm;
    // End of variables declaration//GEN-END:variables
}
