/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Stores;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserStoresModel extends UserAllModel{
    //Lay danh sach tat ca Store
    public List<Stores> getAllStore() {
        //Tao doi tuong luu tru danh sach Store
        List<Stores> usersList = null;
        Session session = getSession();
        try {
            //Lay danh sach tu CSDL
            usersList = session.createQuery("from Stores where isDisabled = false").list();
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
