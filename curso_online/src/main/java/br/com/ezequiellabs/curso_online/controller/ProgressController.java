package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.LessonComplete;
import br.com.ezequiellabs.curso_online.model.Module;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.CourseDAO;
import br.com.ezequiellabs.curso_online.model.dao.jpa.LessonCompleteDAO;
import br.com.ezequiellabs.curso_online.model.dao.jpa.LessonDAO;
import br.com.ezequiellabs.curso_online.model.dao.jpa.ModuleDAO;
import java.util.List;

public class ProgressController {

    private CourseDAO courseDAO;
    private ModuleDAO moduleDAO;
    private LessonDAO lessonDAO;
    private LessonCompleteDAO lessonCompleteDAO;

    public ProgressController() {
        courseDAO = new CourseDAO();
        moduleDAO = new ModuleDAO();
        lessonDAO = new LessonDAO();
        lessonCompleteDAO = new LessonCompleteDAO();
    }

//    public String getProgressByCourse(User user, Course course) {
//        List<Module> modules = moduleDAO.findAllByCourse(course.getId());
//        List<Lesson> lessons = lessonDAO.findAllByCourse(course);
//        List<LessonComplete> lessonsCompletes = lessonCompleteDAO.findAllByUserAndCourse(user, course);
//        
//        int lessonsCount = 0;
//        int completedCount = 0;
//        
//        for (Module module : modules) {
//            for (Lesson lesson : lessons) {
//                if (lesson.getModule().getId().equals(module.getId())) {
//                    lessonsCount++;
//                
//                    for (LessonComplete lessonComplete: lessonsCompletes) {
//                        if (lessonComplete.getLesson().getId().equals(lesson.getId())) {
//                            completedCount++;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        
//        if (lessonsCount == 0 || completedCount == 0) {
//            return "0";
//        }
//        
//        try {
//            return  String.format("%2.02f", (((float) completedCount) / lessonsCount) * 100);
//        } catch(Exception e) {
//            return "0";
//        }
//    }    
    
    public String getProgressByCourse(User user, Course course) {
        Long lessonsCount = lessonDAO.findAllByCourseCount(course);
        Long completedCount = lessonCompleteDAO.findAllByUserAndCourseCount(user, course);
       
        if (lessonsCount == 0 || completedCount == 0) {
            return "0";
        }
        
        try {
            return  String.format("%2.02f", (((float) completedCount) / lessonsCount) * 100);
        } catch(Exception e) {
            return "0";
        }
    }    
    
   

}
