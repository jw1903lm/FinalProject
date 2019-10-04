/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.WishList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminWishListModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminWishListModel.class);

    @SuppressWarnings("unchecked")
    public static List<WishList> getAllWishList() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from WishList");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static WishList getWishListById(String productId, String userId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from WishList where ProductId = :productId and UserId = :userId");
            query.setParameter("productId", productId);
            query.setParameter("userId", userId);
            return (WishList) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addWishList(WishList wishList) {
        Session session = AdminUtil.getSession();
        try {
            session.save(wishList);
            session.getTransaction().commit();
            logger.info("Add wishList successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Add wishList failed! Error: " + e.getMessage());
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                logger.debug("Rolback failed! Error: " + ex.getMessage());
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    public static boolean updateWishList(WishList wishList) {
        Session session = AdminUtil.getSession();
        try {
            session.update(wishList);
            session.getTransaction().commit();
            logger.info("Update wishList successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Update wishList failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteWishList(WishList wishList) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(wishList);
            session.getTransaction().commit();
            logger.info("Delete wishList successfully!");
            return true;
        } catch (Exception e) {
            logger.debug("Update wishList failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
