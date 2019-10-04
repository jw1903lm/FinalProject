/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.admin;

import entity.Catagories;
import entity.Products;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author NamPA
 */
public class AdminCategoryModel {

    private static final Logger logger = LoggerFactory.getLogger(AdminCategoryModel.class);

    @SuppressWarnings("unchecked")
    public static List<Catagories> getAllCategories() {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Catagories");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Catagories> findCategoryByName(String categoryName) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Catagories where catagoryName LIKE :categoryName");
            query.setString("categoryName", "%" + categoryName + "%");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Catagories getCategoryById(String catagoryId) {
        Session session = null;
        try {
            session = AdminUtil.getSession();
            Query query = session.createQuery("from Catagories where CatagoryId = :catagoryId");
            query.setParameter("catagoryId", catagoryId);
            return (Catagories) query.list().get(0);
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean addCategory(Catagories category) {
        Session session = AdminUtil.getSession();
        try {
            session.save(category);
            session.getTransaction().commit();
            logger.info("Add category successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Add category failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateCategory(Catagories category) {
        Session session = AdminUtil.getSession();
        try {
            session.update(category);
            session.getTransaction().commit();
            logger.info("Update category successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Update category failed! Error: " + e.getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean deleteCategory(String categoryId) throws SQLException {
        Connection conn = null;
        List<Products> listProducts = AdminProductModel.getProductByCategoryId(categoryId);
        List<Integer> listProductId = new ArrayList<>();
        if (listProducts != null) {
            for (Products pro : listProducts) {
                listProductId.add(pro.getProductId());
            }
        }
        String deleteProduct = "DELETE FROM Products WHERE CatagoryId = " + categoryId;
        String deleteBanner = "DELETE FROM Banners WHERE CatagoryId = " + categoryId;
        String deleteCategory = "DELETE FROM Catagories WHERE CatagoryId = " + categoryId;
        String deleteSlider = "DELETE FROM Sliders WHERE ProductId IN(";
        String deleteSize = "DELETE FROM Sizes WHERE ProductId IN(";
        String deleteOrderDetail = "DELETE FROM OrderDetail WHERE ProductId IN(";
        String deleteProductComment = "DELETE FROM ProductComments WHERE ProductId IN(";
        String deleteWishList = "DELETE FROM WishList WHERE ProductId IN(";
        String deleteProductImage = "DELETE FROM ProductImages WHERE ProductId IN(";
        for (int i = 0; i < listProductId.size(); i++) {
            int id = listProductId.get(i);
            if (i == listProductId.size() - 1) {
                deleteSlider += id + ")";
                deleteSize += id + ")";
                deleteOrderDetail += id + ")";
                deleteProductComment += id + ")";
                deleteWishList += id + ")";
                deleteProductImage += id + ")";
            } else {
                deleteSlider += id + ",";
                deleteSize += id + ",";
                deleteOrderDetail += id + ",";
                deleteProductComment += id + ",";
                deleteWishList += id + ",";
                deleteProductImage += id + ",";
            }
        }
        Statement stm = null;
        try {
            conn = AdminUtil.getConnection();
            stm = conn.createStatement();
            stm.addBatch(deleteWishList);
            stm.addBatch(deleteProductImage);
            stm.addBatch(deleteSlider);
            stm.addBatch(deleteBanner);
            stm.addBatch(deleteProductComment);
            stm.addBatch(deleteSize);
            stm.addBatch(deleteOrderDetail);
            stm.addBatch(deleteProduct);
            stm.addBatch(deleteCategory);
            stm.executeBatch();
            conn.commit();
            logger.info("Delete category successfully!");
            return true;
        } catch (Exception e) {
            logger.error("Delete category failed! Error: " + e.getMessage());
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            AdminUtil.closeConnection(conn, stm);
        }
        return false;
    }
}
