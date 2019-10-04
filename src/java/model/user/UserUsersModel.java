/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.Cities;
import entity.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author MinhQuan
 */
public class UserUsersModel {

    private UserAllModel allModel;

    public UserUsersModel() {
        this.allModel = new UserAllModel();
    }

    //Lay danh sach tat ca Users
    public List<Users> getAllUsers() {
        //Tao doi tuong luu tru danh sach User
        List<Users> usersList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            usersList = session.createQuery("from Users").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return usersList;
    }

    //Lay User da duoc dang ki
    public Users getUserToLogin(Users loginUser) {
        Users user = new Users();
        Session session = allModel.getSession();
        try {
            //Tao query tim User phu hop
            Query query = session.createQuery("from Users where ((userName=:userName) and (userPassword=:userPassword) and isDisabled = false) or ((email=:email) and (userPassword=:userPassword) and isDisabled = false)");
            //Gan gia tri cho query
            query.setString("userName", loginUser.getUserName());
            query.setString("userPassword", loginUser.getUserPassword());
            query.setString("email", loginUser.getUserName());
            user = (Users) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return user;
    }

    //Lay User theo Id
    public Users getUserById(int userId) {
        Users user = new Users();
        Session session = allModel.getSession();
        try {
            //Tao query tim User phu hop
            Query query = session.createQuery("from Users where isDisabled = false and userId=:userId");
            //Gan gia tri cho query
            query.setInteger("userId", userId);
            user = (Users) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return user;
    }

    //Tao user moi
    public boolean insertUsers(Users user) {
        boolean check = false;
        Session session = allModel.getSession();
        //Tao isDisable
        user.setIsDisabled(false);
        //Tao created
        if (user.getCreated() == null) {
            user.setCreated(allModel.getCurrentDate());
        }
        try {
            //Luu user moi vao CSDL
            session.save(user);
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
    
    //Tao user moi
    public boolean updateUsers(Users user) {
        boolean check = false;
        Session session = allModel.getSession();
        try {
            //Luu user moi vao CSDL
            session.merge(user);
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
    
    //Kiem tra trung user
    public ArrayList<String> checkUser(Users user) {
        //Tao doi tuong luu tru danh sach User
        ArrayList<String> repeatValue = new ArrayList<>();
        Session session = allModel.getSession();
        Users checkUser = new Users();
        try {
            //Lay danh sach tu CSDL
            if(user.getUserName()!=null){
                Query query = session.createQuery("from Users where userName=:userName");   
                query.setString("userName", user.getUserName());
            } 
            if(user.getUserPassword()!=null){
                Query query = session.createQuery("from Users where userPassword=:userPassword");   
                query.setString("userPassword", user.getUserPassword());
            }  
            if(user.getEmail()!=null){
                Query query = session.createQuery("from Users where email=:email");   
                query.setString("email", user.getEmail());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return repeatValue;
    }
}
