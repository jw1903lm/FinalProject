/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.Sliders;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserSlidersModel {

    private UserAllModel allModel;

    public UserSlidersModel() {
        this.allModel = new UserAllModel();
    }

    //Lay danh sach tat ca sliders
    public List<Sliders> getAllSliders() {
        //Tao doi tuong luu tru danh sach Sliders
        List<Sliders> slidersList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            slidersList = session.createQuery("from Sliders where isDisabled = false").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return slidersList;
    }
}
