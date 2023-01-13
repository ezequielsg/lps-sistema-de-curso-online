package br.com.ezequiellabs.curso_online.model.dao.jpa;

import br.com.ezequiellabs.curso_online.factory.Database;
import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.Lesson;
import br.com.ezequiellabs.curso_online.model.LessonComplete;
import br.com.ezequiellabs.curso_online.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class LessonCompleteDAO {

    EntityManager entityManager;
    
    Query qry;
    String sql;

    public LessonCompleteDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(LessonComplete lessonComplete) {
        this.entityManager.getTransaction().begin();
        if (lessonComplete != null && lessonComplete.getId() > 0) {
            this.entityManager.merge(lessonComplete);
        } else {
            this.entityManager.persist(lessonComplete);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(LessonComplete lessonComplete) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(lessonComplete);
        this.entityManager.getTransaction().commit();
    }

    public LessonComplete find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Lesson f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);
        
        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (LessonComplete) lst.get(0);
        }
    }
    
    public LessonComplete findByLesson(int user_id, int lesson_id) {
        sql = " SELECT f "
                + " FROM LessonComplete f "
                + " WHERE user_id = :user_id "
                + " AND lesson_id = :lesson_id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("user_id", user_id);
        qry.setParameter("lesson_id", lesson_id);
        
        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (LessonComplete) lst.get(0);
        }
    }
    
    public List<Lesson> findAllCompleteLessonsByUser(User user) {
        sql = " SELECT l "
                + " FROM LessonComplete lc, Lesson l WHERE lc.user = :user AND lc.lesson = l.id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("user", user);
        
        List lst = qry.getResultList();
        return (List<Lesson>) lst;
    }
    
//     public List<Lesson> findAllByModule(Integer module_id) {
//        //Está é um HQL (Hibernate Query Language)
//        sql = " SELECT f "
//                + " FROM Lesson f WHERE module_id = :module_id";
//
//        qry = this.entityManager.createQuery(sql);
//        qry.setParameter("module_id", module_id);
//        
//        List lst = qry.getResultList();
//        return (List<Lesson>) lst;
//    }
    
    public List<LessonComplete> findAllByUserAndCourse(User user, Course course) {
        sql = " SELECT lc "
                + " FROM LessonComplete lc, Lesson l, Module m WHERE l.module = m.id AND m.course = :course AND lc.user = :user AND lc.lesson = l.id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("user", user);
        qry.setParameter("course", course);
        
        List lst = qry.getResultList();
        return (List<LessonComplete>) lst;
    }
    
    public Long findAllByUserAndCourseCount(User user, Course course) {
        sql = " SELECT count(lc) "
                + " FROM LessonComplete lc, Lesson l, Module m WHERE l.module = m.id AND m.course = :course AND lc.user = :user AND lc.lesson = l.id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("user", user);
        qry.setParameter("course", course);
        
        return (Long) qry.getSingleResult();
    }

    public List<LessonComplete> findAll(Integer user_id) {
        sql = " SELECT f "
                + " FROM LessonComplete f "
                + " WHERE user_id = :user_id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("user_id", user_id);
        
        List lst = qry.getResultList();
        return (List<LessonComplete>) lst;
    }
    

   

}
