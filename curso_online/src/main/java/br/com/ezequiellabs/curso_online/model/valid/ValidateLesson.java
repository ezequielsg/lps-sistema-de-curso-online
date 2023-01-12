
package br.com.ezequiellabs.curso_online.model.valid;
import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.exceptions.LessonException;

public class ValidateLesson {
    
    public Lesson validaCamposEntrada(String title){
        Lesson lesson = new Lesson();
        
        
        if (title.isEmpty()) 
            throw new LessonException("Error - Campo vazio: 'title'.");                
        lesson.setTitle(title);

        return lesson;
    }
    
}
