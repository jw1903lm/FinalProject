/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Sales;
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
public class AdminSaleModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminSaleModel.class);

    @SuppressWarnings("unchecked")
    public static List<Sales> getAllSales() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sales");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Sales> findSaleByName(String saleName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sales where saleName LIKE :saleName");
            query.setString("saleName", "%" + saleName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Sales getSaleById(String saleId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sales where SaleId = :saleId");
            query.setParameter("saleId", saleId);
            return (Sales) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addSale(Sales sale) {
        Session session = AdminUtil.getSession();
        try {
            session.save(sale);
            session.getTransaction().commit();
            logger.info("Add sale successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add sale failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateSale(Sales sale) {
        Session session = AdminUtil.getSession();
        try {
            session.update(sale);
            session.getTransaction().commit();
            logger.info("Update sale successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update sale failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteSale(String saleId) throws SQLException {
        Connection conn = null;
        String update = "Update Products SET SaleId = NULL where SaleId = " + saleId;
        String delete = "DELETE FROM Sales WHERE SaleId = " + saleId;
        Statement stm = null;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(update);
            stm.addBatch(delete);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete sale successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete sale failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
