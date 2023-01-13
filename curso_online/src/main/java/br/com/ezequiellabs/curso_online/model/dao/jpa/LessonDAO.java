package br.com.ezequiellabs.curso_online.model.dao.jpa;

import br.com.ezequiellabs.curso_online.factory.Database;
import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.Lesson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class LessonDAO {

    EntityManager entityManager;
    
    Query qry;
    String sql;

    public LessonDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Lesson lesson) {
        this.entityManager.getTransaction().begin();
        if (lesson != null && lesson.getId() > 0) {
            this.entityManager.merge(lesson);
        } else {
            this.entityManager.persist(lesson);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Lesson lesson) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(lesson);
        this.entityManager.getTransaction().commit();
    }

    public Lesson find(int id) {
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
            return (Lesson) lst.get(0);
        }
    }
    
    public List<Lesson> findAllByModule(Integer module_id) {
        //Está é um HQL (Hibernate Query Language)
        sql = "SELECT f "
                + " FROM Lesson f WHERE module_id = :module_id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("module_id", module_id);
        
        List lst = qry.getResultList();
        return (List<Lesson>) lst;
    }
    
    public List<Lesson> findAllByCourse(Course course) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT l FROM Lesson l, Module m WHERE l.module = m.id AND m.course = :course";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("course", course);
        
        List lst = qry.getResultList();
        return (List<Lesson>) lst;
    }
    
    public Long findAllByCourseCount(Course course) {
        sql = " SELECT count(l) FROM Lesson l, Module m WHERE l.module = m.id AND m.course = :course";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("course", course);
        
        return (Long) qry.getSingleResult();
    }

    public List<Lesson> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Lesson f ";

        qry = this.entityManager.createQuery(sql);
        
        List lst = qry.getResultList();
        return (List<Lesson>) lst;
    }
    

   

}
