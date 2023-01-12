package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.Module;
import br.com.ezequiellabs.curso_online.model.dao.jpa.LessonDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.LessonException;
import br.com.ezequiellabs.curso_online.model.valid.ValidateLesson;
import javax.swing.JTable;


public class LessonController {

    private LessonDAO repositorio;

    public LessonController() {
        repositorio = new LessonDAO();
    }

    public void create(String title, Module module) {
        ValidateLesson valid = new ValidateLesson();
        Lesson lesson = valid.validaCamposEntrada(title);
        lesson.setModule(module);
      
        repositorio.save(lesson);
    }    
    
    public void update(int idPage, String title) {
        ValidateLesson valid = new ValidateLesson();
        Lesson lesson = valid.validaCamposEntrada(title);
        lesson.setId(idPage);
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
