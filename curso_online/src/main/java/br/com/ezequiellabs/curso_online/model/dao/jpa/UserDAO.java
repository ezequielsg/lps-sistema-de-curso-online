package br.com.ezequiellabs.curso_online.model.dao.jpa;

import br.com.ezequiellabs.curso_online.factory.Database;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.exceptions.UserNotFoundLoginException;
import br.com.ezequiellabs.curso_online.model.exceptions.WrongPasswordLoginException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDAO {

    EntityManager entityManager;
    
    Query qry;
    String sql;

    public UserDAO() {
        entityManager = Database.getInstance().getEntityManager();
    }

    public void save(User user) {
        this.entityManager.getTransaction().begin();
        if (user != null && user.getId() > 0) {
            this.entityManager.merge(user);
        } else {
            this.entityManager.persist(user);
        }
        this.entityManager.getTransaction().commit();
    }

    public void delete(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(user);
        this.entityManager.getTransaction().commit();
    }
    
    public User login(String username, String password) {
        sql = " SELECT f "
                + " FROM User f"
                + " WHERE username like :username"
                + " AND password = :password ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("username", username);
        qry.setParameter("password", password);
        
        List lst = qry.getResultList();
        
        if (!lst.isEmpty()) {
            return (User) lst.get(0);
        }
        
        sql = " SELECT f "
                + " FROM User f"
                + " WHERE username like :username";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("username", username);
        
        lst = qry.getResultList();
        
        if (lst.isEmpty()) {
            throw new UserNotFoundLoginException(null);
        }
        
        throw new WrongPasswordLoginException(null);
    }

    public User find(int id) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM User f "
                + " WHERE id = :id ";

        qry = this.entityManager.createQuery(sql);
        qry.setParameter("id", id);
        
        List lst = qry.getResultList();
        if (lst.isEmpty()) {
            return null;
        } else {
            return (User) lst.get(0);
        }
    }

    public List<User> findAll() {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM User f ";

        qry = this.entityManager.createQuery(sql);
        
        List lst = qry.getResultList();
        return (List<User>) lst;
    }

    public User findByEmail(String email) {
        //Está é um HQL (Hibernate Query Language)
        sql = " SELECT f "
                + " FROM User f"
                + " WHERE email like :email ";
        qry = this.entityManager.createQuery(sql);
        qry.setParameter("email", email);
        
        List lst = qry.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (User) lst.get(0);
        }
    }

}
