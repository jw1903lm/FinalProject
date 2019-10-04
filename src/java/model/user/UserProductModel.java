/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.Brands;
import entity.Products;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserProductModel {

    private UserAllModel allModel;

    public UserProductModel() {
        allModel = new UserAllModel();
    }

    //lay danh sach san pham goi y
    public List<Products> getSuggestProducts(String type) {
        //dao doi tuong luu danh sach
        List<Products> listNewArrivalProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            //danh sach New Arrival
            if (type == "new arrival") {
                query = session.createQuery("from Products where isDisabled = false order by Created DESC");
            } //danh sach Sell Product
            else if (type == "sale product") {
                query = session.createQuery("from Products where isDisabled = false and Not (SaleId = null) order by SaleId DESC");
            } //danh sach Bestselling
            else if (type == "bestselling") {
                query = session.createQuery("from Products where isDisabled = false order by BestSeller DESC");
            } //ngoai le
            else {
                query = session.createQuery("from Products where isDisabled = false");
            }
            query.setMaxResults(10);
            listNewArrivalProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listNewArrivalProducts;
    }

    //lay danh sach san pham theo thuong hieu
    public List<Products> getBrandProducts(int brandId) {
        //tao doi tuong luu danh sach
        List<Products> listBrandProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            query = session.createQuery("from Products where isDisabled = false and brandId=:brandId");
            query.setInteger("brandId", brandId);
            query.setMaxResults(10);
            listBrandProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listBrandProducts;
    }

    //lay danh sach san pham theo thuong hieu
    public List<Products> getCatagoryProducts(int catagoryId) {
        //tao doi tuong luu danh sach
        List<Products> listCatagoryProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            query = session.createQuery("from Products where isDisabled = false and catagoryId=:catagoryId");
            query.setInteger("catagoryId", catagoryId);
            query.setMaxResults(10);
            listCatagoryProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listCatagoryProducts;
    }

    //lay danh sach san pham theo thuong hieu
    public List<Products> getRelateCatagoryProducts(int catagoryId, int productId) {
        //tao doi tuong luu danh sach
        List<Products> listCatagoryProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            query = session.createQuery("from Products where isDisabled = false and catagoryId=:catagoryId and NOT (productId=:productId)");
            query.setInteger("catagoryId", catagoryId);
            query.setInteger("productId", productId);
            query.setMaxResults(10);
            listCatagoryProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listCatagoryProducts;
    }

    public Products getProductById(int productId) {
        //tao doi tuong luu danh sach
        Products product = null;
        Session session = allModel.getSession();
        try {
            Query query = session.createQuery("from Products where isDisabled = false and productId=:productId");
            query.setInteger("productId", productId);
            product = (Products) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return product;
    }
    
    //lay product theo ten
    public List<Products> getProductByName(int position, int pageSize,String productName) {
        //tao doi tuong luu danh sach
        List<Products> listCatagoryProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            query = session.createQuery("from Products where isDisabled = false and productName like :productName");
            String string = "%"+productName+"%";
            query.setString("productName", string);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listCatagoryProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listCatagoryProducts;
    }

    //lay tat ca san pham
    public List<Products> getAllProduct() {
        List<Products> listProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            query = session.createQuery("from Products where isDisabled = false order by Created DESC");
            listProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listProducts;
    }
    
    //lay danh sach san pham trong shop theo so trang
    public List<Products> getShopProductPage(int position, int pageSize, int catagoryId, int brandId, String productName) {
        List<Products> listProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            String queryString = "from Products where isDisabled = false";
            if(catagoryId != 0){
                queryString +=" and catagoryId="+ catagoryId;
            }
            if (brandId != 0) {
                queryString +=" and brandId="+ brandId;
            }
            if (productName != null) {
                queryString +=" and productName like '%"+productName+"%'";
            }
            queryString+= " order by Created DESC";
            query = session.createQuery(queryString);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listProducts;
    }
    
    //lay danh sach san pham trong shop theo so trang
    public List<Products> getAllShopProduct(int catagoryId, int brandId, String productName) {
        List<Products> listProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            String queryString = "from Products where isDisabled = false";
            if(catagoryId != 0){
                queryString = queryString + " and catagoryId="+ catagoryId;
            }
            if (brandId != 0) {
                queryString = queryString + " and brandId="+ brandId;
            }
            if (productName != null) {
                queryString = queryString + " and productName like '%"+productName+"%'";
            }
            queryString+= " order by Created DESC";
            query = session.createQuery(queryString);
            listProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listProducts;
    }
    
    //lay danh sach san pham trong shop theo so trang
    public List<Products> getAllShopProductStartId(int catagoryId, int brandId, String productName, int productId) {
        List<Products> listProducts = null;
        Session session = allModel.getSession();
        try {
            Query query = null;
            String queryString = "from Products where isDisabled = false and productId<="+productId;
            if(catagoryId != 0){
                queryString = queryString + " and catagoryId="+ catagoryId;
            }
            if (brandId != 0) {
                queryString = queryString + " and brandId="+ brandId;
            }
            if (productName != null) {
                queryString = queryString + " and productName like '%"+productName+"%'";
            }
            queryString+= " order by Created DESC";
            query = session.createQuery(queryString);
            listProducts = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listProducts;
    }
    
    public long countTotalRecords(int catagoryId, int brandId, String productName) {
        Session session = allModel.getSession();
        Query query = null;
        String queryString = "Select count (productId) from Products where isDisabled = false";
            if(catagoryId != 0){
                queryString = queryString + " and catagoryId="+ catagoryId;
            }
            if (brandId != 0) {
                queryString = queryString + " and brandId="+ brandId;
            }
            if (productName != null) {
                queryString = queryString + " and productName like '%"+productName+"%'";
            }
            query = session.createQuery(queryString);
        return (Long) query.uniqueResult();
    }
    
    //cap nhat san pham
    public boolean updateProduct(Products product){
        Session session = allModel.getSession();
        boolean check = false;
        try {
            session.update(product);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return check;
    }
}
