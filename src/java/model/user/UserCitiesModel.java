/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Cities;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author MinhQuan
 */
public class UserCitiesModel {
    private UserAllModel allModel;

    public UserCitiesModel() {
        this.allModel = new UserAllModel();
    }
     

    //Lay danh sach tat ca Cities
    public List<Cities> getAllCities() {
        //Tao doi tuong luu tru danh sach Cities
        List<Cities> citiesList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            citiesList = session.createQuery("from Cities where isDisabled = false").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return citiesList;
    }
    
    //Lay User da duoc dang ki
    public Cities getCityById(int citiId) {
        Cities city = new Cities();
        Session session = allModel.getSession();
        try {
            //Tao query tim User phu hop
            Query query = session.createQuery("from Cities where cityId=:cityId and isDisabled = false ");
            //Gan gia tri cho query
            query.setInteger("cityId", citiId);
            city = (Cities) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return city;
    }
}
