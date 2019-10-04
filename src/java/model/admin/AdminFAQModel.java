/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Faq;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminFAQModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminFAQModel.class);

    @SuppressWarnings("unchecked")
    public static List<Faq> getAllFaq() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Faq");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Faq> findFaqByQuestion(String question) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Faq WHERE Question LIKE :question");
            query.setString("question", "%" + question + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Faq getFaqById(String faqId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Faq where FaqId = :faqId");
            query.setParameter("faqId", faqId);
            return (Faq) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addFaq(Faq faq) {
        Session session = AdminUtil.getSession();
        try {
            session.save(faq);
            session.getTransaction().commit();
            logger.info("Add faq successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add faq failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateFaq(Faq faq) {
        Session session = AdminUtil.getSession();
        try {
            session.update(faq);
            session.getTransaction().commit();
            logger.info("Update faq successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update faq failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteFaq(Faq faq) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(faq);
            session.getTransaction().commit();
            logger.info("Delete faq successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete faq failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
