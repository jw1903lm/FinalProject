/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.OrderDetail;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminOrderDetailModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminOrderDetailModel.class);

    @SuppressWarnings("unchecked")
    public static List<OrderDetail> getAllOrderDetails() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from OrderDetail");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static OrderDetail getOrderDetailById(String orderId, String productId, String sizeId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from OrderDetail where OrderId =:orderId and ProductId =:productId and SizeId =:sizeId");
            query.setParameter("orderId", orderId);
            query.setParameter("productId", productId);
            query.setParameter("sizeId", sizeId);
            return (OrderDetail) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public static boolean addOrderDetail(OrderDetail orderDetail) {
        Session session = AdminUtil.getSession();
        try {
            session.save(orderDetail);
            session.getTransaction().commit();
            logger.info("Add orderDetail successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add orderDetail failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateOrderDetail(OrderDetail orderDetail) {
        Session session = AdminUtil.getSession();
        try {
            Query query = session.createQuery("UPDATE OrderDetail SET isDisabled = :isDisabled WHERE OrderId = :orderId AND ProductId = :productId AND SizeId = :sizeId");
            query.setParameter("isDisabled", orderDetail.isIsDisabled());
            query.setParameter("orderId", orderDetail.getOrders().getOrderId());
            query.setParameter("productId", orderDetail.getProducts().getProductId());
            query.setParameter("sizeId", orderDetail.getSizes().getSizeId());
            query.executeUpdate();
            session.getTransaction().commit();
            logger.info("Update orderDetail successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update orderDetail failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteOrderDetail(OrderDetail orderDetail) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(orderDetail);
            session.getTransaction().commit();
            logger.info("Delete orderDetail successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete orderDetail failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
