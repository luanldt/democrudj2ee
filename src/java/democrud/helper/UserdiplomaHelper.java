package democrud.helper;


import democrud.model.Userdiploma;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luan
 */
public class UserdiplomaHelper {

    Session session = null;

    public List<Userdiploma> findAll(int i) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Userdiploma where UserId = :id").setInteger("id", i);
            return (List<Userdiploma>) q.list();
        } catch (Exception e) {
            return null;
        }
    }
}
