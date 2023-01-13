package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.CourseDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.CourseException;
import br.com.ezequiellabs.curso_online.model.valid.ValidateCourse;
import javax.swing.JTable;

public class CourseController {

    private CourseDAO repositorio;

    public CourseController() {
        repositorio = new CourseDAO();
    }

    public void create(String title, String author) {
        ValidateCourse valid = new ValidateCourse();
        Course course = valid.validaCamposEntrada(title, author);
                
        if (repositorio.findByTitle(course.getTitle()) != null) {
            throw new CourseException("Error - Já existe um curso com este 'titulo'.");
        } else {
            repositorio.save(course);
        }
    }    
    
    public void update(int id, String title, String author) {
        ValidateCourse valid = new ValidateCourse();
        Course course = valid.validaCamposEntrada(title, author);
        course.setId(id);
        repositorio.save(course);
    }    

    public void updateDashTable(JTable grd) {
        Util.jTableShow(grd, new TMCadCourse(repositorio.findAll()), null);
    }
    
    public void updateMemberTable(JTable grd, User user) {
        Util.jTableShow(grd, new TMCourse(repositorio.findAll(), user), null);
    }

    public void remove(Course course) {
        //Encontrar professor e exlcui                   
        
        if (course != null) {
            repositorio.delete(course);
        } else {
            throw new CourseException("Error - Curso inexistente.");
        }
    }    

}
