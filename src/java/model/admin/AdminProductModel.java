package model.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Products;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NamPA
 */
public class AdminProductModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminProductModel.class);

    //Quan update
    @SuppressWarnings("unchecked")
    public static long countActiveProduct() {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("Select count (productId) from Products where isDisabled = false");;
        return (Long) query.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Products> getAllProducts() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Products");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Products> findProductByName(String productName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Products where ProductName LIKE :productName");
            query.setString("productName", "%" + productName + "%");
            return query.list();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Products getProductById(String productId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Products where ProductId = :productId");
            query.setParameter("productId", productId);
            return (Products) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Products> getProductByCategoryId(String categoryId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Products where CatagoryId = :categoryId");
            query.setParameter("categoryId", categoryId);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addProduct(Products product) {
        Session session = AdminUtil.getSession();
        try {
            session.save(product);
            session.getTransaction().commit();
            logger.info("Add product successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add product failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateProduct(Products product) {
        Session session = AdminUtil.getSession();
        try {
            session.update(product);
            session.getTransaction().commit();
            logger.info("Update product successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update product failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteProduct(String productId) throws SQLException {
        Connection conn = null;
        Statement stm = null;
        String deleteProduct = "DELETE FROM Products WHERE ProductId = " + productId;
        String deleteSlider = "DELETE FROM Sliders WHERE ProductId = " + productId;
        String deleteSize = "DELETE FROM Sizes WHERE ProductId = " + productId;
        String deleteOrderDetail = "DELETE FROM OrderDetail WHERE ProductId = " + productId;
        String deleteProductComment = "DELETE FROM ProductComments WHERE ProductId = " + productId;
        String deleteWishList = "DELETE FROM WishList WHERE ProductId = " + productId;
        String deleteProductImage = "DELETE FROM ProductImages WHERE ProductId = " + productId;

        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(deleteWishList);
            stm.addBatch(deleteProductImage);
            stm.addBatch(deleteSlider);
            stm.addBatch(deleteProductComment);
            stm.addBatch(deleteSize);
            stm.addBatch(deleteOrderDetail);
            stm.addBatch(deleteProduct);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete product successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete product failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
