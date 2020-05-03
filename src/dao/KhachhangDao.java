/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import entities.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author BatTu
 */
public class KhachhangDao {

    public static void main(String[] args) {
        KhachhangDao k = new KhachhangDao();
        Khachhang x = k.find("ssss1");
        if(x != null){
            System.out.println("XXXXXXXX");
            System.out.println(x.getHoten());
        }else{
            System.out.println("aaaaaaaaaaa");
        }
        
    }

    public List<Khachhang> danhsach() {
        List<Khachhang> list = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Khachhang";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }

    public Khachhang find(String u) {
        Khachhang bb = null;
        Session ss = Hibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        bb = (Khachhang) ss.get(Khachhang.class, u);
        ss.close();
        return bb;
    }

    public boolean save(Khachhang kh) {
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(kh);
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
    public boolean update(Khachhang kh) {
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(kh);
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
     public boolean delete (Khachhang kh) {
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(kh);
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
    public List<Khachhang> timkiem(String cmnd,String name,String sdt){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Criteria criteria = session.createCriteria(Khachhang.class);
    if (name != null) {
      criteria.add(Restrictions.like("cmnd", "%"+cmnd+"%"));
      criteria.add(Restrictions.like("hoten", "%"+name+"%"));
      criteria.add(Restrictions.like("sdt", "%"+sdt+"%"));
    }    
    List<Khachhang> result = criteria.list();
    session.close();
    sessionFactory.close();
    return result;
    }
}
