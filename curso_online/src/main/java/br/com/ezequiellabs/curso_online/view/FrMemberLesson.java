package br.com.ezequiellabs.curso_online.view;

import br.com.ezequiellabs.curso_online.controller.LessonCompleteController;
import br.com.ezequiellabs.curso_online.controller.LessonController;
import br.com.ezequiellabs.curso_online.model.Lesson;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import static br.com.ezequiellabs.curso_online.controller.AuthController.currentUser;


public class FrMemberLesson extends javax.swing.JFrame {

    JFrame previewScreen;
    LessonController lessonController;
    LessonCompleteController lessonCompleteController;
    
    Lesson lesson;
    
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;

    public FrMemberLesson(JFrame previewScreen, Lesson lesson) {
        this.previewScreen = previewScreen;
        this.lesson = lesson;

        
        lessonController = new LessonController();
        lessonCompleteController = new LessonCompleteController();

        initComponents();
        
        
        
        lModule.setText(lesson.getModule().getTitle()); 
        lLesson.setText(lesson.getTitle()); 
        lDescription.setText("<html>" + lesson.getDescription() + "</html>");   
        

        Platform.runLater(() -> {
            WebView view = new WebView();
            engine = view.getEngine();
            engine.load("https://www.youtube.com/embed/" + lesson.getYoutube());
//            engine.load("https://www.youtube.com/watch?v=" + lesson.getYoutube());
            Scene scene = new Scene(view);
            jfxPanel.setScene(scene);
        });
        
        
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jfxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jfxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        
        
        

        
        this.updateComplete();
        
    }
    
   
   
    public void updateComplete() {
        if (currentUser == null) return;
        
        if (lessonCompleteController.completed(currentUser, lesson)) {
            cbComplete.setSelected(true);
        } else {
            cbComplete.setSelected(false);
        }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lDescription = new javax.swing.JLabel();
        lModule = new javax.swing.JLabel();
        lLesson = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        cbComplete = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lDescription.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        lDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lDescription.setText("Descrição");
        lDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lModule.setFont(new java.awt.Font("Fira Sans", 0, 14)); // NOI18N
        lModule.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lModule.setText("Módulo");

        lLesson.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        lLesson.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lLesson.setText("Aula");

        panel.setPreferredSize(new java.awt.Dimension(480, 360));
        panel.setSize(new java.awt.Dimension(480, 360));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        cbComplete.setText("Assistido");
        cbComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCompleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lLesson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lModule, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                                .addComponent(cbComplete)
                                .addGap(18, 18, 18))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbComplete)
                            .addComponent(lModule))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lLesson)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.previewScreen.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void cbCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCompleteActionPerformed
        if (currentUser == null) return;
        
        this.lessonCompleteController.toggle(currentUser,  lesson);
        
        this.updateComplete();
    }//GEN-LAST:event_cbCompleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbComplete;
    private javax.swing.JLabel lDescription;
    private javax.swing.JLabel lLesson;
    private javax.swing.JLabel lModule;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
