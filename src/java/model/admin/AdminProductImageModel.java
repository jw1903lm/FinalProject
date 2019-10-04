/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.ProductImages;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminProductImageModel {
    
    private static final Logger logger = LoggerFactory.getLogger(AdminProductImageModel.class);

    @SuppressWarnings("unchecked")
    public static List<ProductImages> getAllProductImages() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ProductImages");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static ProductImages getProductImageById(String productImageId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ProductImages where ImageId = :productImageId");
            query.setParameter("productImageId", productImageId);
            return (ProductImages) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addProductImage(ProductImages productImage) {
        Session session = AdminUtil.getSession();
        try {
            session.save(productImage);
            session.getTransaction().commit();
            logger.info("Add productImage successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Add productImage failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateProductImage(ProductImages productImage) {
        Session session = AdminUtil.getSession();
        try {
            session.update(productImage);
            session.getTransaction().commit();
            logger.info("Update productImage successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Update productImage failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteProductImage(ProductImages productImage) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(productImage);
            session.getTransaction().commit();
            logger.info("Delete productImage successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Delete productImage failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
