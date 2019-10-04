/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.OrderDetail;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserOrderDetailModel extends UserAllModel {

    //Tao order detail moi
    public boolean insertOrderDetail(OrderDetail orderDetail) {
        boolean check = false;
        Session session = getSession();
        //Tao isDisable
        orderDetail.setIsDisabled(false);
        //Tao created
        if (orderDetail.getCreated() == null) {
            orderDetail.setCreated(getCurrentDate());
        }
        try {
            //Luu Order Detail moi vao CSDL
            session.save(orderDetail);
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

    //tim orderDetail qua OrderId
    public List<OrderDetail> getListByOrderId(int orderId) {
        List<OrderDetail> listOrderDetail = null;
        Session session = getSession();
        try {
            Query query = null;
            query = session.createQuery("from OrderDetail where isDisabled = false and orderId=:orderId");
            query.setInteger("orderId", orderId);
            listOrderDetail = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return listOrderDetail;
    }
}
