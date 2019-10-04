/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.ProductComments;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminProductCommentModel {
    
    private static final Logger logger = LoggerFactory.getLogger(AdminProductCommentModel.class);

    @SuppressWarnings("unchecked")
    public static List<ProductComments> getAllProductComments() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ProductComments");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static ProductComments getProductCommentById(String productCommentId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ProductComments where CommentId = :productCommentId");
            query.setParameter("productCommentId", productCommentId);
            return (ProductComments) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addProductComment(ProductComments productComment) {
        Session session = AdminUtil.getSession();
        try {
            session.save(productComment);
            session.getTransaction().commit();
            logger.info("Add productComment successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Add productComment failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateProductComment(ProductComments productComment) {
        Session session = AdminUtil.getSession();
        try {
            session.update(productComment);
            session.getTransaction().commit();
            logger.info("Update productComment successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Update productComment failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteProductComment(ProductComments productComment) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(productComment);
            session.getTransaction().commit();
            logger.info("Delete productComment successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Delete productComment failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
