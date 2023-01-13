package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.UserDAO;

public class AuthController {
    
    public static User currentUser = null;

    private UserDAO repositorio;

    public AuthController() {
        repositorio = new UserDAO();
    }

    public User login(String username, String password) {
        User user = repositorio.login(username, password);
        
        this.currentUser = user;
                
        return user;
    }    
    

}
