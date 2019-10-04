/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Faq;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserFaqModel extends UserAllModel{
    
    //Lay danh sach tat ca Faq
    public List<Faq> getAllFaq() {
        //Tao doi tuong luu tru danh sach User
        List<Faq> usersList = null;
        Session session = getSession();
        try {
            //Lay danh sach tu CSDL
            usersList = session.createQuery("from Faq where isDisabled = false").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return usersList;
    }
    
}
