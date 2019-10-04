/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Banners;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminBannerModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminBannerModel.class);

    @SuppressWarnings("unchecked")
    public static List<Banners> getAllBanners() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Banners");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Banners> findBanerByName(String bannerName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Banners Where BannerName LIKE :bannerName");
            query.setString("bannerName", "%" + bannerName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Banners getBannerById(String bannerId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Banners where BannerId = :bannerId");
            query.setParameter("bannerId", bannerId);
            return (Banners) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addBanner(Banners banner) {
        Session session = AdminUtil.getSession();
        try {
            session.save(banner);
            session.getTransaction().commit();
            logger.info("Add banner successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add banner failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateBanner(Banners banner) {
        Session session = AdminUtil.getSession();
        try {
            session.update(banner);
            session.getTransaction().commit();
            logger.info("Update banner successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update banner failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteBanner(Banners banner) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(banner);
            session.getTransaction().commit();
            logger.info("Delete banner successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete banner failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
