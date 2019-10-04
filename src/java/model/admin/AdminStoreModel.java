/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Stores;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminStoreModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminStoreModel.class);

    @SuppressWarnings("unchecked")
    public static List<Stores> getAllStores() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Stores");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Stores> findStoreByName(String storeName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Stores where storeName LIKE :storeName");
            query.setString("storeName", "%" + storeName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Stores getStoreById(String storeId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Stores where StoreId = :storeId");
            query.setParameter("storeId", storeId);
            return (Stores) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addStore(Stores store) {
        Session session = AdminUtil.getSession();
        try {
            session.save(store);
            session.getTransaction().commit();
            logger.info("Add store successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add store failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateStore(Stores store) {
        Session session = AdminUtil.getSession();
        try {
            session.update(store);
            session.getTransaction().commit();
            logger.info("Update store successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update store failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteStore(Stores store) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(store);
            session.getTransaction().commit();
            logger.info("Delete store successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete store failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
