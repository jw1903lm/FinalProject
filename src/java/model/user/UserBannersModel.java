/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.Banners;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserBannersModel {

    private UserAllModel allModel;

    public UserBannersModel() {
        this.allModel = new UserAllModel();
    }

    //Lay danh sach tat ca Banner co nho
    public List<Banners> getSmallBanners() {
        //Tao doi tuong luu tru danh sach Cities
        List<Banners> bannersList = null;
        Session session = allModel.getSession();
        try {
            //Tao query tim Banner phu hop
            Query query = session.createQuery("from Banners where isDisabled = false and size = false order by BannerId DESC");
            query.setMaxResults(3);
            //Gan gia tri cho query
            bannersList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return bannersList;
    }

//    public Banners getBigBanners(int startId) {
//        //Tao doi tuong luu tru danh sach Cities
//        Banners banner = null;
//        Session session = allModel.getSession();
//        try {
//            Query query = session.createQuery("from Banners where BannerName =: startId");
//            query.setInteger("startId", startId);
//            banner = (Banners) query.uniqueResult();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            //in ra loi
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        //Dong session
//        session.close();
//        return banner;
//    }

    //Lay danh sach tat ca Banner co lon
    public List<Banners> getBigBanners() {
        //Tao doi tuong luu tru danh sach Cities
        List<Banners> listBanner = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            Query query = session.createQuery("from Banners where isDisabled = false and Size = true order by BannerId DESC");
            query.setMaxResults(2);
            listBanner = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //Dong session
        session.close();
        return listBanner;
    }
}
