
package br.com.ezequiellabs.curso_online.model.valid;
import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.exceptions.LessonException;

public class ValidateLesson {
      
    public static void validate(Lesson lesson, String title, String youtube, String description){
        if (title.isEmpty()) 
            throw new LessonException("Error - Campo vazio: 'title'.");                
        lesson.setTitle(title);
        
        lesson.setYoutube(youtube);
        lesson.setDescription(description);

    }
    
}
