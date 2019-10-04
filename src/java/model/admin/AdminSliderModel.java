/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Sliders;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminSliderModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminSliderModel.class);

    @SuppressWarnings("unchecked")
    public static List<Sliders> getAllSliders() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sliders");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Sliders> findSliderByTitle(String title) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sliders where Title LIKE :title");
            query.setString("title", "%" + title + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Sliders getSliderById(String sliderId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Sliders where SliderId = :sliderId");
            query.setParameter("sliderId", sliderId);
            return (Sliders) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addSlider(Sliders slider) {
        Session session = AdminUtil.getSession();
        try {
            session.save(slider);
            session.getTransaction().commit();
            logger.info("Add slider successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add slider failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateSlider(Sliders slider) {
        Session session = AdminUtil.getSession();
        try {
            session.update(slider);
            session.getTransaction().commit();
            logger.info("Update slider successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update slider failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteSlider(Sliders slider) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(slider);
            session.getTransaction().commit();
            logger.info("Delete slider successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete slider failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
