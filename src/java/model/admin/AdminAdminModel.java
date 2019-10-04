/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Admins;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminAdminModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminAdminModel.class);

    @SuppressWarnings("unchecked")
    public static List<Admins> getAllAdmins() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Admins");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Admins> findAdminByName(String adminName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Admins Where AdminName LIKE :adminName");
            query.setString("adminName", "%" + adminName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Admins getAdminById(String adminId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Admins where AdminId = :adminId");
            query.setParameter("adminId", adminId);
            return (Admins) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addAdmin(Admins admin) {
        Session session = AdminUtil.getSession();
        String hashingPassword = AdminUtil.hashingPassword(admin.getAdminPassword(), admin.getSalt());
        admin.setAdminPassword(hashingPassword);
        try {
            session.save(admin);
            session.getTransaction().commit();
            logger.info("Add admin successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add admin failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static void main(String[] args) {
        Admins admin = new Admins();
        admin.setAdminName("nam");
        admin.setAdminPassword("12345");
        admin.setSalt(RandomStringUtils.randomAlphanumeric(10));
        admin.setCreated(AdminUtil.getCurrentDate());
        addAdmin(admin);
    }

    public static boolean updateAdmin(Admins admin) {
        Session session = AdminUtil.getSession();

        if (!"".equals(admin.getAdminPassword())) {
            String hashingPassword = AdminUtil.hashingPassword(admin.getAdminPassword(), admin.getSalt());
            admin.setAdminPassword(hashingPassword);
        } else {
            Admins adm = getAdminById(String.valueOf(admin.getAdminId()));
            admin.setAdminPassword(adm.getAdminPassword());
        }
        try {
            session.update(admin);
            session.getTransaction().commit();
            logger.info("Update admin successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update admin failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteAdmin(Admins admin) {
        Session session = AdminUtil.getSession();
        try {
            session.delete(admin);
            session.getTransaction().commit();
            logger.info("Delete admin successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete admin failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

}
