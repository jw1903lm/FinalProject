/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.WishList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserWishListModel extends UserAllModel{
    
    public boolean insertWishList(WishList wishList){
        boolean check = false;
        Session session = getSession();
        //Tao isDisable
        wishList.setIsDisabled(false);
        //Tao created
        if (wishList.getCreated() == null) {
            wishList.setCreated(getCurrentDate());
        }
        try {
            //Luu Order moi vao CSDL
            session.save(wishList);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            //in ra loi va dong Transaction
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //Dong session
        session.close();
        return check;
    }
    
    public boolean updateWishList(WishList wishList){
        boolean check = false;
        Session session = getSession();
        try {
            //Luu Order moi vao CSDL
            session.update(wishList);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            //in ra loi va dong Transaction
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //Dong session
        session.close();
        return check;
    }
    
    //Lay WishList theo UserId
    public List<WishList> getWishListByUserId(int userId) {
        List<WishList> listWishList = null;
        Session session = getSession();
        try {
            //Tao query tim User phu hop
            Query query = session.createQuery("from WishList where isDisabled = false and userId=:userId");
            //Gan gia tri cho query
            query.setInteger("userId", userId);
            listWishList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return listWishList;
    }
    
    //Lay WishList theo Id
    public WishList getWishListById(int userId, int productId) {
        WishList getWishList = null;
        Session session = getSession();
        try {
            //Tao query tim User phu hop
            Query query = session.createQuery("from WishList where userId=:userId and productId=:productId");
            //Gan gia tri cho query
            query.setInteger("userId", userId);
            query.setInteger("productId", productId);
            getWishList = (WishList)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return getWishList;
    }
}
