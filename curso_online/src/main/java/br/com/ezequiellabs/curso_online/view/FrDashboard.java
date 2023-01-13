package br.com.ezequiellabs.curso_online.view;

import javax.swing.JFrame;
import static br.com.ezequiellabs.curso_online.controller.AuthController.currentUser;


public class FrDashboard extends javax.swing.JFrame {

    
    JFrame previewScreen = null;
    
    public FrDashboard(JFrame previewScreen) {
        this.previewScreen = previewScreen;
        initComponents();  
        
        if (currentUser == null ) {
        return;
        }
        
        if (currentUser.getRole().equals("manager")) {
            btnCourse.setVisible(true);
            btnUser.setVisible(true);
        } else if (currentUser.getRole().equals("suport")) {
            btnCourse.setVisible(false);
            btnUser.setVisible(true);
        } else {
            btnCourse.setVisible(false);
            btnUser.setVisible(false);
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

        lblMenuPrincipal = new javax.swing.JLabel();
        btnUser = new javax.swing.JButton();
        btnCourse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMenuPrincipal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal.setText("Dashboard");

        btnUser.setText("Usuários");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnCourse.setText("Cursos");
        btnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
            .addComponent(btnCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        FrDashUser telaFuncionario = new FrDashUser(this);
        telaFuncionario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseActionPerformed
        FrDashCourse screen = new FrDashCourse(this);
        screen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCourseActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        this.previewScreen.setVisible(true);
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourse;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel lblMenuPrincipal;
    // End of variables declaration//GEN-END:variables
}
