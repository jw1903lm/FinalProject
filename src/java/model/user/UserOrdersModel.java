/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Orders;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserOrdersModel extends UserAllModel{
    
    //Tao order moi
    public boolean insertOrder(Orders order) {
        boolean check = false;
        Session session = getSession();
        //Tao isDisable
        order.setIsDisabled(false);
        //Tao created
        if (order.getCreated() == null) {
            order.setCreated(getCurrentDate());
        }
        try {
            //Luu Order moi vao CSDL
            session.save(order);
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
    
    //lay hoa don moi nhat
    public Orders getLastestOrder() {
        //tao doi tuong luu danh sach
        Orders lastestOrder = null;
        Session session = getSession();
        try {
            Query query = null;
            query = session.createQuery("from Orders where isDisabled = false order by orderId DESC");
            query.setMaxResults(1);
            if(!query.list().isEmpty()){
                lastestOrder = (Orders)query.list().get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return lastestOrder;
    }
    
    //lay hoa don theo orderId
    public Orders getOrderByOrderId(int orderId) {
        //tao doi tuong luu danh sach
        Orders lastestOrder = null;
        Session session = getSession();
        try {
            Query query = null;
            query = session.createQuery("from Orders where isDisabled = false and orderId=:orderId");
            query.setInteger("orderId", orderId);
            lastestOrder = (Orders)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return lastestOrder;
    }
    
    //lay hoa don theo userId
    public List<Orders> getOrderByUserId(int userId) {
        //tao doi tuong luu danh sach
        List<Orders> listOrder = null;
        Session session = getSession();
        try {
            Query query = null;
            query = session.createQuery("from Orders where isDisabled = false and userId=:userId");
            query.setInteger("userId", userId);
            listOrder = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listOrder;
    }
    
    //cap nhat san pham
    public boolean deleteOrder(Orders order){
        Session session = getSession();
        boolean check = false;
        try {
            session.delete(order);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return check;
    }
}
