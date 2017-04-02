/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democrud.helper;

import democrud.model.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguyenminhluan
 */
public class SystemuserHelper {
    Session session = null;
    
    public List<Systemuser> findAll() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Systemuser");
            return (List<Systemuser>) q.list();
        } catch (HibernateException e) {
            return null;
        } finally {
            session.close();
        }
    }
    
    public boolean create(Systemuser systemuser) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            for(Userdiploma userdiploma : systemuser.getUserdiplomas()) {
                userdiploma.setSystemuser(systemuser);
                session.persist(userdiploma);
            }
            systemuser.setUserdiplomas(null);
            session.persist(systemuser);
            
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            return false;
        } finally {
            session.close();
        }
    }
    
    public boolean update(Systemuser systemuser) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            for(Userdiploma userdiploma : systemuser.getUserdiplomas()) {
                userdiploma.setSystemuser(systemuser);
                session.update(userdiploma);
            }
            systemuser.setUserdiplomas(null);
            session.update(systemuser);
            
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            return false;
        } finally {
            session.close();
        }
    }
    
    public Systemuser findOne(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Systemuser where id = :id").setInteger("id", id);
            return (Systemuser) q.uniqueResult();
        } catch (HibernateException e) {
            return null;
        } finally {
            session.close();
        }
    }
    
    public boolean delete(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Systemuser systemuser = this.findOne(id);
            session.delete(systemuser);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            return false;
        } finally {
            session.close();
        }
    }
    
}
