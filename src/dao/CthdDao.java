/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import entities.*;
import org.hibernate.Session;

/**
 *
 * @author BatTu
 */
public class CthdDao {
    public static void main(String[] args) {
        CthdDao c = new CthdDao();
        Cthd l = c.cthdtheotrangthai(null,"SUT002");
        if(l != null){
            System.out.println(l.getPhong().getLoaiphong()+"_"+l.getCheckin()+"_"+l.getKhachhang().getCmnd());
        }else{
            System.out.println("zaaaaaaaaaaaaa");
        }
        
    }
    public List<Cthd> danhsachphong() {
        List<Cthd> list = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from CTHD";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }

    public Cthd find(String u) {
        Cthd bb = null;
        Session ss = Hibernate.getSessionFactory().openSession();
        ss.beginTransaction();
        bb = (Cthd) ss.get(Cthd.class, u);
        ss.close();
        return bb;
    }

    public boolean save(Cthd cthd) {
        Session ss = Hibernate.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(cthd);
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
    public boolean update(Cthd kh) {
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
    public Cthd cthdtheotrangthai(String trangthai,String maphong){
        List<Cthd> list = null;
        Cthd cthd = null;
        Session ss = Hibernate.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql= "from Cthd where checkout = "+trangthai;
        Query query = ss.createQuery(sql);
        list = query.list();
        if(list != null){
            for(Cthd ct : list ){
                if(ct.getPhong().getMaphong().equalsIgnoreCase(maphong)){
                    cthd = ct;
                    break;
                }
            }
        }
        ss.close();
        return cthd;
    }
}
