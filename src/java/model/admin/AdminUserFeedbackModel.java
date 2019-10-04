/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.UserFeedbacks;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminUserFeedbackModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserFeedbackModel.class);
    
    //Quan update
    @SuppressWarnings("unchecked")
    public static long countFeedBack() {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("Select count (feedbackId) from UserFeedbacks");;
        return (Long) query.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public static List<UserFeedbacks> getAllUserFeedbacks() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from UserFeedbacks");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static UserFeedbacks getFeedbackById(String userFeedbackId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from UserFeedbacks where FeedbackId = :userFeedbackId");
            query.setParameter("userFeedbackId", userFeedbackId);
            return (UserFeedbacks) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addFeedback(UserFeedbacks userfeedback) {
        Session session = AdminUtil.getSession();
        try {
            session.save(userfeedback);
            session.getTransaction().commit();
            logger.info("Add userfeedback successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add userfeedback failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateFeedback(UserFeedbacks userFeedback) {
        Session session = AdminUtil.getSession();
        try {
            session.update(userFeedback);
            session.getTransaction().commit();
            logger.info("Update userfeedback successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update userfeedback failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteFeedback(UserFeedbacks userFeedback) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(userFeedback);
            session.getTransaction().commit();
            logger.info("Delete userFeedback successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete userFeedback failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
