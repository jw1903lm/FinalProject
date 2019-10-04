/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Users;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminUserModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserModel.class);

    //Quan update
    @SuppressWarnings("unchecked")
    public static long countActiveUsers() {
        Session session = AdminUtil.getSession();
        Query query = session.createQuery("Select count (userId) from Users where isDisabled = false");;
        return (Long) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public static List<Users> getAllUsers() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Users");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Users> findUserByName(String userName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Users where userName LIKE :userName");
            query.setString("userName", "%" + userName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Users getUserById(String userId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Users where UserId = :userId");
            query.setParameter("userId", userId);
            return (Users) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addUser(Users user) {
        Session session = AdminUtil.getSession();
        String hashingPassword = AdminUtil.hashingPassword(user.getUserPassword());
        user.setUserPassword(hashingPassword);
        try {
            session.save(user);
            session.getTransaction().commit();
            logger.info("Add user successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add user failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateUser(Users user) {
        Session session = AdminUtil.getSession();

        if (!"".equals(user.getUserPassword())) {
            String hashingPassword = AdminUtil.hashingPassword(user.getUserPassword());
            user.setUserPassword(hashingPassword);
        } else {
            Users us = getUserById(String.valueOf(user.getUserId()));
            user.setUserPassword(us.getUserPassword());
        }
        try {
            session.update(user);
            session.getTransaction().commit();
            logger.info("Update user successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update user failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteUser(String userId) throws SQLException {
        Connection conn = null;
        Statement stm = null;
        String deleteUser = "DELETE FROM Users WHERE UserId = " + userId;
        String deleteWishLish = "DELETE FROM WishList WHERE UserId = " + userId;
        String deleteProductComment = "DELETE FROM ProductComments WHERE UserId = " + userId;
        String deleteUserFeedback = "DELETE FROM UserFeedbacks WHERE UserId = " + userId;
        String updateOrder = "UPDATE Orders SET UserId = NULL WHERE UserId = " + userId;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(updateOrder);
            stm.addBatch(deleteUserFeedback);
            stm.addBatch(deleteProductComment);
            stm.addBatch(deleteWishLish);
            stm.addBatch(deleteUser);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete user successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete user failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
