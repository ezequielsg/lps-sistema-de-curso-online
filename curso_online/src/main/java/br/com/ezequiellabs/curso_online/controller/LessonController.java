package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.Module;
import br.com.ezequiellabs.curso_online.model.dao.jpa.LessonDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.LessonException;
import br.com.ezequiellabs.curso_online.model.valid.ValidateLesson;
import javax.swing.JTable;


public class LessonController {

    private LessonDAO repositorio = null;

    public LessonController() {
        repositorio = new LessonDAO();
    }

    public void create(Module module, String title, String youtube, String description) {
        Lesson lesson = new Lesson();
        
        ValidateLesson.validate(lesson, title, youtube, description);
        lesson.setModule(module);
      
        repositorio.save(lesson);
    }    
    
    public void update(int id, String title, String youtube, String description) {
        Lesson lesson = repositorio.find(id);
        ValidateLesson.validate(lesson, title, youtube, description);
        repositorio.save(lesson);
    }    

    public void updateTable(JTable grd, Integer module_id) {
        Util.jTableShow(grd, new TMCadLesson(repositorio.findAllByModule(module_id)), null);
    }

    public void remove(Lesson lesson) {
        if (lesson != null) {
            repositorio.delete(lesson);
        } else {
            throw new LessonException("Error - Aula inexistente.");
        }
    }    

}
