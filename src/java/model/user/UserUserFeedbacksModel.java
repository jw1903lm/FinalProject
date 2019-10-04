/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.UserFeedbacks;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserUserFeedbacksModel extends UserAllModel{
    
    //Tao feedback moi
    public boolean insertFeedback(UserFeedbacks userFeedback) {
        boolean check = false;
        Session session = getSession();
        //Tao isDisable
        userFeedback.setIsDisabled(false);
        //Tao created
        if (userFeedback.getCreated() == null) {
            userFeedback.setCreated(getCurrentDate());
        }
        try {
            //Luu feedback moi vao CSDL
            session.save(userFeedback);
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
    
}
