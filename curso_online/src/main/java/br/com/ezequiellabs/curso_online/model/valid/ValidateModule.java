
package br.com.ezequiellabs.curso_online.model.valid;
import br.com.ezequiellabs.curso_online.model.Module;
import br.com.ezequiellabs.curso_online.model.exceptions.ModuleException;

public class ValidateModule {
    
    public Module validaCamposEntrada(String title){
        Module module = new Module();
        
        
        if (title.isEmpty()) 
            throw new ModuleException("Error - Campo vazio: 'title'.");                
        module.setTitle(title);

        return module;
    }
    
    public static void validate(Module module, String title){
        if (title.isEmpty()) 
            throw new ModuleException("Error - Campo vazio: 'title'.");                
        module.setTitle(title);

    }
    
}
