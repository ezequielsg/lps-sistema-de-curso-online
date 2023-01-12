
package br.com.ezequiellabs.curso_online.model.valid;
import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.exceptions.CourseException;


public class ValidateCourse {
    
    public Course validaCamposEntrada(String title, String author){
        Course course = new Course();
        if (title.isEmpty())
            throw new CourseException("Error - Campo vazio: 'title'.");
        course.setTitle(title);
        
        if (author.isEmpty()) 
            throw new CourseException("Error - Campo vazio: 'author'.");                
        course.setAuthor(author);

        return course;
    }
    
}
