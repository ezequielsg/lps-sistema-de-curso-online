
package br.com.ezequiellabs.curso_online.model.valid;

import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.exceptions.UserException;

public class ValidateUser {
    
    public static void validate(User user, String name, String email, String password, String role){
        if (name.isEmpty())
            throw new UserException("Error - Campo vazio: 'name'.");
        user.setName(name);
        
        if (email.isEmpty()) 
            throw new UserException("Error - Campo vazio: 'email'.");                
        user.setEmail(email);
        
        if (password.isEmpty()) 
            throw new UserException("Error - Campo vazio: 'password'.");                
        user.setPassword(password);
        
        if (role.isEmpty()) 
            throw new UserException("Error - Campo vazio: 'role'.");                
        user.setRole(role);
        
        
    }
    
}
