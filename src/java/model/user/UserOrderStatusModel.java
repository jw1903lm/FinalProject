package model.user;


import entity.OrderStatus;
import java.util.List;
import model.user.UserAllModel;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MinhQuan
 */
public class UserOrderStatusModel extends UserAllModel{
    //Lay danh sach tat ca Ship
    public List<OrderStatus> getAllOrderStatus() {
        //Tao doi tuong luu tru danh sach User
        List<OrderStatus> shipsList = null;
        Session session = getSession();
        try {
            //Lay danh sach tu CSDL
            shipsList = session.createQuery("from OrderStatus where isDisabled = false").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return shipsList;
    }
}
