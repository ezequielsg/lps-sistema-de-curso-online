package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.UserDAO;
import br.com.ezequiellabs.curso_online.model.exceptions.UserException;
import br.com.ezequiellabs.curso_online.model.valid.ValidateUser;
import javax.swing.JTable;


public class UserController {

    private UserDAO repositorio;

    public UserController() {
        repositorio = new UserDAO();
    }

    public void create(String nome, String email, String password, String role) {
        User user = new User();
        ValidateUser.validate(user, nome, email, password, role);
                
        if (repositorio.findByEmail(user.getEmail()) != null) {
            throw new UserException("Error - Já existe um usuário com este 'email'.");
        } else {
            repositorio.save(user);
        }
    }    
    
    public void update(int id, String nome, String email, String password, String role) {
        User user = repositorio.find(id);
        ValidateUser.validate(user, nome, email, password, role);
        repositorio.save(user);
    }    

    public void updateTable(JTable grd) {
        Util.jTableShow(grd, new TMCadUser(repositorio.findAll()), null);
    }

    public void remove(User funcionario) {
        //Encontrar professor e exlcui                   
        
        if (funcionario != null) {
            repositorio.delete(funcionario);
        } else {
            throw new UserException("Error - Usuário inexistente.");
        }
    }    

}
