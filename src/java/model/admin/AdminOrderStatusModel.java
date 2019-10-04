/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.OrderStatus;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminOrderStatusModel {
    private static final Logger logger = LoggerFactory.getLogger(AdminOrderStatusModel.class);

    @SuppressWarnings("unchecked")
    public static List<OrderStatus> getAllOrderStatus() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from OrderStatus");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static OrderStatus getOrderStatusById(String orderStatusId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from OrderStatus where OrderStatusId = :orderStatusId");
            query.setParameter("orderStatusId", orderStatusId);
            return (OrderStatus) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addOrderStatus(OrderStatus orderStatus) {
        Session session = AdminUtil.getSession();
        try {
            session.save(orderStatus);
            session.getTransaction().commit();
            logger.info("Add orderStatus successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add orderStatus failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateOrderStatus(OrderStatus orderStatus) {
        Session session = AdminUtil.getSession();
        try {
            session.update(orderStatus);
            session.getTransaction().commit();
            logger.info("Update orderStatus successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update orderStatus failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }  
        return false;
    }

    public static boolean deleteOrderStatus(String orderStatusId) throws SQLException {
       Connection conn = null;
        Statement stm = null;
        String updateOrder = "UPDATE Orders SET OrderStatusId = NULL WHERE OrderStatusId = " + orderStatusId;
        String deleteOrderStatus = "DELETE FROM OrderStatus WHERE OrderStatusId = "+ orderStatusId;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(updateOrder);
            stm.addBatch(deleteOrderStatus);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete orderStatus successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete orderStatus failed! Error: " + e.getMessage());
            if (conn!= null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
