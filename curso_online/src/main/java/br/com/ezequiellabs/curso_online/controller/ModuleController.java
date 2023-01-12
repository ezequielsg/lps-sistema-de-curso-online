package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.Module;
import br.com.ezequiellabs.curso_online.model.dao.jpa.ModuleDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.ModuleException;
import br.com.ezequiellabs.curso_online.model.valid.ValidateModule;
import javax.swing.JTable;


public class ModuleController {

    private ModuleDAO repositorio;

    public ModuleController() {
        repositorio = new ModuleDAO();
    }

    public void create(String title, Course course) {
        ValidateModule valid = new ValidateModule();
        Module module = valid.validaCamposEntrada(title);
        module.setCourse(course);
      
        repositorio.save(module);
    }    
    
    public void update(int id, String texto) {
        Module module = repositorio.find(id);

        ValidateModule.validate(module, texto);
        
        repositorio.save(module);
    }    

    public void updateTable(JTable grd, Integer course_id) {
        Util.jTableShow(grd, new TMCadModule(repositorio.findAllByCourse(course_id)), null);
    }

    public void remove(Module module) {
        if (module != null) {
            repositorio.delete(module);
        } else {
            throw new ModuleException("Error - Módulo inexistente.");
        }
    }    

}
