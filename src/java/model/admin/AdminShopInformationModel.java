/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.ShopInformation;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminShopInformationModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminShopInformationModel.class);

    @SuppressWarnings("unchecked")
    public static List<ShopInformation> getAllShopInformations() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ShopInformation");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static ShopInformation getShopInformationById(String shopInformationId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from ShopInformation where ShopInformationId = :shopInformationId");
            query.setParameter("shopInformationId", shopInformationId);
            return (ShopInformation) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addShopInformation(ShopInformation shopInformation) {
        Session session = AdminUtil.getSession();
        try {
            session.save(shopInformation);
            session.getTransaction().commit();
            logger.info("Add shopInformation successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add shopInformation failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateShopInformation(ShopInformation shopInformation) {
        Session session = AdminUtil.getSession();
        try {
            session.update(shopInformation);
            session.getTransaction().commit();
            logger.info("Update shopInformation successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update shopInformation failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteShopInformation(ShopInformation shopInformation) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(shopInformation);
            session.getTransaction().commit();
            logger.info("Delete shopInformation successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete shopInformation failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
