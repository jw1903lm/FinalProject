/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Orders;
import entity.Ships;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminShipModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminShipModel.class);

    @SuppressWarnings("unchecked")
    public static List<Ships> getAllShips() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Ships");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Ships getShipById(String shipId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Ships where ShipId = :shipId");
            query.setParameter("shipId", shipId);
            return (Ships) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addShip(Ships ship) {
        Session session = AdminUtil.getSession();
        try {
            session.save(ship);
            session.getTransaction().commit();
            logger.info("Add ship successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add ship failed! Error: " + e.getMessage());
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                logger.error("Rolback failed! Error: " + ex.getMessage());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    public static boolean updateShip(Ships ship) {
        Session session = AdminUtil.getSession();
        try {
            session.update(ship);
            session.getTransaction().commit();
            logger.info("Update ship successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update ship failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteShip(String shipId) throws SQLException{
        Connection conn = null;
        Statement stm = null;
        String deleteOrderDetail = "DELETE From OrderDetail WHERE OrderId IN(";
        String deleteOrder = "DELETE FROM Orders WHERE ShipId = " + shipId;
        String deleteShip = "DELETE FROM Ships WHERE ShipId = " + shipId;
        List<Orders> listOrder = AdminOrderModel.getOrdersByShipId(shipId);
        List<Integer> listOrderId = new ArrayList<>();
        if (listOrder != null) {
            for (Orders ord : listOrder) {
                listOrderId.add(ord.getOrderId());
            }
        }
        for (int i = 0; i < listOrderId.size(); i++) {
            int id = listOrderId.get(i);
            if (i == listOrderId.size() - 1) {
                deleteOrderDetail += id + ")";
            } else {
                deleteOrderDetail += id + ",";
            }
        }
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(deleteOrderDetail);
            stm.addBatch(deleteOrder);
            stm.addBatch(deleteShip);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete ship successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete ship failed! Error: " + e.getMessage());
            if (conn!= null) {
                conn.rollback();
            }
        } finally {
           AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
