package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.LessonComplete;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.LessonCompleteDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.LessonException;
import javax.swing.JTable;


public class LessonCompleteController {

    private LessonCompleteDAO repositorio;

    public LessonCompleteController() {
        repositorio = new LessonCompleteDAO();
    }
    
    public void toggle(User user, Lesson lesson) {
        LessonComplete lessonComplete = repositorio.findByLesson(user.getId(), lesson.getId());
        
        if (lessonComplete != null) {
            repositorio.delete(lessonComplete);
        } else {
            this.create(user, lesson);
        }
    }
    
    public boolean completed(User user, Lesson lesson) {
        LessonComplete lessonComplete = repositorio.findByLesson(user.getId(), lesson.getId());
        
        return lessonComplete != null;
    }

    public void create(User user, Lesson lesson) {
        LessonComplete lessonComplete = new LessonComplete();
        lessonComplete.setLesson(lesson);
        lessonComplete.setUser(user);
      
        repositorio.save(lessonComplete);
    }    
    
    public void update(int id, User user, Lesson lesson) {
        LessonComplete lessonComplete =  repositorio.find(id);
        lessonComplete.setUser(user);
        lessonComplete.setLesson(lesson);
        repositorio.save(lessonComplete);
    }    

    public void remove(LessonComplete lessonComplete) {
        if (lessonComplete != null) {
            repositorio.delete(lessonComplete);
        } else {
            throw new LessonException("Error - Marcação de aula inexistente.");
        }
    }  
    
    

    public void updateTable(JTable grd, User user) {
        Util.jTableShow(grd, new TMCadLesson(repositorio.findAllCompleteLessonsByUser(user)), null);
    }

}
