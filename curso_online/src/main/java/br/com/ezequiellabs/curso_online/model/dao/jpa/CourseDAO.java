package br.com.ezequiellabs.curso_online.model.dao.jpa;

import br.com.ezequiellabs.curso_online.factory.Database;
import br.com.ezequiellabs.curso_online.model.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CourseDAO {

    EntityManager entityManager;
    
    Query qry;
    String sql;

    public CourseDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Course course) {
        this.entityManager.getTransaction().begin();
        if (course != null && course.getId() > 0) {
            this.entityManager.merge(course);
        } else {
            this.entityManager.persist(course);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Course course) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(course);
        this.entityManager.getTransaction().commit();
    }

    public Course find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Course f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);
        
        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Course) lst.get(0);
        }
    }

    public List<Course> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Course f ";

        qry = this.entityManager.createQuery(sql);
        
        List lst = qry.getResultList();
        return (List<Course>) lst;
    }

    public Course findByTitle(String title) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Course f"
                + " WHERE title like :title ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("title", title);
        
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Course) lst.get(0);
        }
    }
   

}
