package br.com.ezequiellabs.curso_online.model.dao.jpa;

import br.com.ezequiellabs.curso_online.factory.Database;
import br.com.ezequiellabs.curso_online.model.Module;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ModuleDAO {

    EntityManager entityManager;
    
    Query qry;
    String sql;

    public ModuleDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(Module module) {
        this.entityManager.getTransaction().begin();
        if (module != null && module.getId() > 0) {
            this.entityManager.merge(module);
        } else {
            this.entityManager.persist(module);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(Module module) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(module);
        this.entityManager.getTransaction().commit();
    }

    public Module find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Module f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);
        
        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (Module) lst.get(0);
        }
    }
    
     public List<Module> findAllByCourse(Integer course_id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Module f WHERE course_id = :course_id";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("course_id", course_id);
        
        List lst = qry.getResultList();
        return (List<Module>) lst;
    }

    public List<Module> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM Module f ";

        qry = this.entityManager.createQuery(sql);
        
        List lst = qry.getResultList();
        return (List<Module>) lst;
    }
    

   

}
