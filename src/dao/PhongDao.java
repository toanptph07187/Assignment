/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import entities.*;
/**
 *
 * @author BatTu
 */
public class PhongDao {
    public static void main(String[] args) {
        CthdDao cdao = new CthdDao();
        PhongDao pdao = new PhongDao();
    }
    public List<Phong> danhsachphong(){
        List<Phong> list = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Phong";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    public Phong find(String u){
       Phong bb= null;
        Session ss = Hibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        bb= (Phong) ss.get(Phong.class, u);
        ss.close();
        return bb;
    }
    public List<Phong> timkiemphongtrong(boolean trangthai){
        List<Phong> list = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql= "from Phong where trangthai = "+trangthai;
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    public boolean save(Phong kh) {
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
    public boolean update(Phong kh) {
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
    
}
