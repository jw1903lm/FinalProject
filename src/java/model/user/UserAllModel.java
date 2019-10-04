/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.text.ParseException;
import org.hibernate.Session;
import util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhQuan
 */
public class UserAllModel {

    //Khoi tao session va transaction
    public Session getSession() {
        //khoi tao doi tuong session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //khoi tao Transaction
        session.getTransaction().begin();

        return session;
    }

    public Date getCurrentDate() {
        Date created = null;
        try {
            //tao mau ngay thang
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            //Lay thoi gian dang String
            String timeString = formatter.format(date);
            //Chuyen thoi gian sang dang Date va luu vao CSDL
            created = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(timeString);  
        } catch (ParseException ex) {
            Logger.getLogger(UserUsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return created;
    }
}
