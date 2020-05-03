/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import org.hibernate.*;
import entities.*;

/**
 *
 * @author BatTu
 */
public class UsersDao {
    
        
    
    public List<Users> danhsach() {
        List<Users> list = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Users";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    
    
    public Users find(String u){
        Users bb= null;
        Session ss = Hibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        bb= (Users) ss.get(Users.class, u);
        ss.close();
        return bb;
    }
    public boolean save(Users u){
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(u);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
        finally{
            ss.close();
        }
    }
    public boolean update(Users u){
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(u);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }
        finally{
            ss.close();
        }
    }
    public boolean delete(Users u){
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(u);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }
        finally{
            ss.close();
        }
    }
 
}
