/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateUtil;

/**
 *
 * @author NamPA
 */
public class AdminUtil {

    private static final Logger logger = LoggerFactory.getLogger(AdminUtil.class);
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String ADDRESS = "jdbc:sqlserver://localhost;databaseName=ShowyClothes";
    private static final String USER = "sa";
    private static final String PASSWORD = "Huong9894";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            logger.error("FAILED TO REGISTER DRIVER! " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(ADDRESS, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            logger.error("FAILED TO GET CONNECTION! " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(Connection conn, Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static Session getSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
        } catch (Exception e) {
            logger.error("FAILED TO GET SESSION! ", e.getMessage());
        }
        return session;
    }

    public static Date getCurrentDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String timeString = formatter.format(new Date());
            Date created = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(timeString);
            return created;
        } catch (ParseException ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public static String hashingPassword(String password, String salt) {
        String algorithm = "SHA-256";
        MessageDigest md;
        byte byteData[];
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update((password + salt).getBytes("UTF-8"));
            byteData = md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            logger.error("ERROR HASHING PASSWORD! " + e.getMessage());
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }

        return sb.toString();
    }

    public static String hashingPassword(String password) {
        String algorithm = "SHA-256";
        MessageDigest md;
        byte byteData[];
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(password.getBytes("UTF-8"));
            byteData = md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            logger.error("ERROR HASHING PASSWORD! " + e.getMessage());
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }

        return sb.toString();
    }

    public static boolean imageNameExist(String imgName, String imgPath) {
        File img = new File(imgPath + imgName);
        return img.exists();
    }
}
