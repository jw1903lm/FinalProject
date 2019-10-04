/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.ShopInformation;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserShopInformationModel {
    
    private UserAllModel allModel;

    public UserShopInformationModel() {
        allModel = new UserAllModel();
    }
    
    //Lay ra 1 ShopInformation de hien thi
    public ShopInformation getOneShopInformation(){
        //Khoi tao doi tuong luu tru du lieu
        ShopInformation shopInformation = null;
        Session session = allModel.getSession();
        try {
            //Tao query tim ShopInformation moi nhat
            Query query = session.createQuery("from ShopInformation where isDisabled = false order by ShopInformationId DESC");
            query.setMaxResults(1);
            //lay gia tri dau tien cua danh sach de hien thi
            shopInformation = (ShopInformation)query.list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return shopInformation;
    }
    
}
