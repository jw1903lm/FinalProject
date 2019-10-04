/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Orders;
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
public class AdminOrderModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminOrderModel.class);
    
    //Quan update
    @SuppressWarnings("unchecked")
    public static long countUserOrder() {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("Select count (orderId) from Orders where NOT userId=null");;
        return (Long) query.uniqueResult();
    }
    
    //Quan update
    @SuppressWarnings("unchecked")
    public static long countVisitorOrder() {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("Select count (orderId) from Orders where userId=null");;
        return (Long) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public static List<Orders> getAllOrders() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Orders");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Orders> getOrdersByShipId(String shipId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Orders where ShipId = " + shipId);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Orders getOrderById(String orderId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Orders where OrderId = :orderId");
            query.setParameter("orderId", orderId);
            return (Orders) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Orders> getOrdersByCityId(String cityId) {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("from Orders where cityId = " + cityId);
        return query.list();
    }

    public static boolean addOrder(Orders order) {
        Session session = AdminUtil.getSession();
        try {
            session.save(order);
            session.getTransaction().commit();
            logger.info("Add order successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add order failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateOrder(Orders order) {
        Session session = AdminUtil.getSession();
        String sql = "UPDATE Orders SET isDisabled = :isDisabled, OrderStatusId = :orderStatusId WHERE OrderId = :orderId";
        Query query = session.createQuery(sql);
        query.setParameter("isDisabled", order.isIsDisabled());
        query.setParameter("orderId", order.getOrderId());
        query.setParameter("orderStatusId", order.getOrderStatus().getOrderStatusId());
        try {
            query.executeUpdate();
            logger.info("Update order successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update order failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteOrder(String orderId) throws SQLException {
        Connection conn = null;
        Statement stm = null;
        String deleteOrder = "DELETE FROM Orders WHERE OrderId = " + orderId;
        String deleteOrderDetail = "DELETE FROM OrderDetail WHERE OrderId = " + orderId;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(deleteOrderDetail);
            stm.addBatch(deleteOrder);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete order successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete order failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
