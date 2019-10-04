/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Sizes;
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
public class AdminSizeModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminSizeModel.class);

    @SuppressWarnings("unchecked")
    public static List<Sizes> getAllSizes() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sizes");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Sizes> findSizeByName(String sizeName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sizes where sizeName LIKE :sizeName");
            query.setString("sizeName", "%" + sizeName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Sizes getSizeById(String sizeId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sizes where SizeId = :sizeId");
            query.setParameter("sizeId", sizeId);
            return (Sizes) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addSize(Sizes size) {
        Session session = AdminUtil.getSession();
        try {
            session.save(size);
            session.getTransaction().commit();
            logger.info("Add size successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add size failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateSize(Sizes size) {
        Session session = AdminUtil.getSession();
        try {
            session.update(size);
            session.getTransaction().commit();
            logger.info("Update size successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update size failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteSize(String sizeId) throws SQLException {
        Connection conn = null;
        Statement stm = null;
        String deleteOrderDetail = "DELETE FROM OrderDetail WHERE SizeId = " + sizeId;
        String deleteSize = "DELETE FROM Sizes WHERE SizeId = " + sizeId;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(deleteOrderDetail);
            stm.addBatch(deleteSize);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete size successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete size failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
