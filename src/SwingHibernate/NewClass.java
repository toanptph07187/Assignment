/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingHibernate;

import java.util.Date;

/**
 *
 * @author BatTu
 */
public class NewClass {

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        System.out.println(date);
        String j1 = "nam";
        String j2 = "Le Van Nam";
        int d = j2.indexOf(j1);
        System.out.println(d);

    }
}
