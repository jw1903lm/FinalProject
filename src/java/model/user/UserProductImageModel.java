/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.ProductImages;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserProductImageModel {

    private UserAllModel allModel;

    public UserProductImageModel() {
        allModel = new UserAllModel();
    }

    //lay anh cho san pham
    public ProductImages getOneProductImageByProductId(int productId) {
        //tao doi tuong luu danh sach
        ProductImages productImage = null;
        Session session = allModel.getSession();
        try {
            Query query = session.createQuery("from ProductImages where isDisabled = false and productId=:productId");
            query.setInteger("productId", productId);
            query.setMaxResults(1);
            List<ProductImages> listProductImages = query.list();
            session.getTransaction().commit();   
            if(!(listProductImages.isEmpty())){
                productImage = listProductImages.get(0);
            }   
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session   
        session.close();
        return productImage;
    }
}
