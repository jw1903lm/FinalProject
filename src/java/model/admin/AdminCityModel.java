/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Cities;
import entity.Orders;
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
public class AdminCityModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminCityModel.class);

    @SuppressWarnings("unchecked")
    public static List<Cities> getAllCities() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Cities");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Cities> findCityByName(String cityName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Cities where cityName LIKE :cityName");
            query.setString("cityName", "%" + cityName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Cities getCityById(String cityId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Cities where CityId = :cityId");
            query.setParameter("cityId", cityId);
            return (Cities) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addCity(Cities city) {
        Session session = AdminUtil.getSession();
        try {
            session.save(city);
            session.getTransaction().commit();
            logger.info("Add city successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add city failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateCity(Cities city) {
        Session session = AdminUtil.getSession();
        try {
            session.update(city);
            session.getTransaction().commit();
            logger.info("Update city successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update city failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteCity(String cityId) throws SQLException {
        Connection conn = null;
        Statement stm = null;
        List<Orders> listOrder = AdminOrderModel.getOrdersByCityId(cityId);
        List<Integer> listOrderId = new ArrayList<>();
        if (listOrder.size() > 0) {
            for (Orders ord : listOrder) {
                listOrderId.add(ord.getOrderId());
            }
        }
        String deleteCity = "DELETE FROM Cities WHERE CityId = " + cityId;
        String deleteUser = "DELETE FROM Users WHERE CityId = " + cityId;
        String deleteOrder = "DELETE FROM Orders WHERE CityId = " + cityId;
        String deleteOrderDetail = "DELETE FROM OrderDetail WHERE OrderId IN(";
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
            stm.addBatch(deleteUser);
            stm.addBatch(deleteCity);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete city successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete city failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
