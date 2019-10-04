/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.ShopInformation;
import entity.Sizes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserSizeModel extends UserAllModel{
    
    //lay danh sach size bang productId
    public Sizes getSizeById(int sizeId){
        Sizes size = null;
        Session session = getSession();
        try {
            //Tao query tim ShopInformation moi nhat
            Query query = session.createQuery("from Sizes where isDisabled = false and sizeId=:sizeId");
            query.setInteger("sizeId", sizeId);
            //lay gia tri dau tien cua danh sach de hien thi
            size = (Sizes)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return size;
    }
    
    //lay danh sach size bang productId
    public List<Sizes> getSizeByProductId(int productId){
        List<Sizes> listSize = null;
        Session session = getSession();
        try {
            //Tao query tim ShopInformation moi nhat
            Query query = session.createQuery("from Sizes where isDisabled = false and productId=:productId");
            query.setInteger("productId", productId);
            //lay gia tri dau tien cua danh sach de hien thi
            listSize = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listSize;
    }
    
    //lay danh sach size bang sizeId
    public Sizes getSizeBySizeId(int sizeId){
        Sizes size = null;
        Session session = getSession();
        try {
            //Tao query tim ShopInformation moi nhat
            Query query = session.createQuery("from Sizes where isDisabled = false and sizeId=:sizeId");
            query.setInteger("sizeId", sizeId);
            //lay gia tri dau tien cua danh sach de hien thi
            size = (Sizes)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return size;
    }
    
    //cap nhat size
    public boolean updateSize(Sizes size){
        Session session = getSession();
        boolean check = false;
        try {
            session.update(size);
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
