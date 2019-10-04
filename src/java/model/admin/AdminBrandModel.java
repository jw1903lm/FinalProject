/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Brands;
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
public class AdminBrandModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminBrandModel.class);

    @SuppressWarnings("unchecked")
    public static List<Brands> getAllBrands() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Brands");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Brands> findBrandByName(String brandName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Brands Where BrandName LIKE :brandName");
            query.setString("brandName", "%" + brandName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Brands getBrandById(String brandId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Brands where BrandId = :brandId");
            query.setParameter("brandId", brandId);
            return (Brands) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addBrand(Brands brands) {
        Session session = AdminUtil.getSession();
        try {
            session.save(brands);
            session.getTransaction().commit();
            logger.info("Add brand successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add brand failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateBrand(Brands brand) {
        Session session = AdminUtil.getSession();
        try {
            session.update(brand);
            session.getTransaction().commit();
            logger.info("Update brand successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update brand failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteBrand(Brands brand) throws SQLException {
        Connection conn = null;
        String update = "Update Products SET BrandId = NULL where BrandId = " + brand.getBrandId();
        String delete = "DELETE FROM Brands WHERE BrandId = " + brand.getBrandId();
        Statement stm = null;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(update);
            stm.addBatch(delete);
            stm.executeBatch();
            logger.info("Delete brand successfully!");
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.error("Delete brand failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
