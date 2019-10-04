/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.Admins;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author MinhQuan
 */
public class UserAdminModel {

    //Khoi tao session va transaction
    public Session getSession() {
        //khoi tao doi tuong session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //khoi tao Transaction
        session.getTransaction().begin();

        return session;
    }

    //Tao admin moi
    public boolean insertAdmin(Admins admin) {
        boolean check = false;
        Session session = getSession();
        try {
            //Luu admin moi vao CSDL
            session.save(admin);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            //in ra loi va dong Transaction
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //Dong session
        session.close();
        return check;
    }
}
