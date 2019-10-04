/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Ships;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserShipsModel extends UserAllModel{
    
    //Lay danh sach tat ca Ship
    public List<Ships> getAllShips() {
        //Tao doi tuong luu tru danh sach Ship
        List<Ships> shipsList = null;
        Session session = getSession();
        try {
            //Lay danh sach tu CSDL
            shipsList = session.createQuery("from Ships where isDisabled = false").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return shipsList;
    }
    
    //Lay Ship theo Id
    public Ships getShipById(int shipId) {
        //Tao doi tuong luu tru danh sach Ship
        Ships ship = null;
        Session session = getSession();
        try {
            //Lay danh sach tu CSDL
            Query query = session.createQuery("from Ships where isDisabled = false and shipId=:shipId");
            query.setInteger("shipId", shipId);
            ship = (Ships)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return ship;
    }
}
