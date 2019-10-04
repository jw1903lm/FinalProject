/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Catagories;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserCatagoriesModel {
    private UserAllModel allModel;

    public UserCatagoriesModel() {
        this.allModel = new UserAllModel();
    }
    
    //Lay danh sach 4 parent catagories
    public List<Catagories> getAllParentCatagories() {
        //Tao doi tuong luu tru danh sach Catagories
        List<Catagories> catagoriesList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            Query query = session.createQuery("from Catagories where isDisabled = false and parentId = 0 order by catagoryPriority ASC");
            query.setMaxResults(4);
            catagoriesList = query.list();
            //catagoriesList = session.createQuery("from Catagories where isDisabled = false and parentId = 0 order by catagoryPriority ASC").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return catagoriesList;
    }
    
    //Lay danh sach tat ca Sub Catagories
    public List<Catagories> getAllSubCatagories() {
        //Tao doi tuong luu tru danh sach Catagories
        List<Catagories> catagoriesList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            catagoriesList = session.createQuery("from Catagories where isDisabled = false and Not (parentId = 0) order by catagoryPriority ASC").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return catagoriesList;
    }
    
    //lay danhsach subCatagory cua parentCatagory
    public List<Catagories> getSubCatagoriesOfParentCatarory(int catagoryId) {
        //Tao doi tuong luu tru danh sach Catagories
        List<Catagories> catagoriesList = null;
        Session session = allModel.getSession();
        try {
            //Lay danh sach tu CSDL
            Query query = session.createQuery("from Catagories where isDisabled = false and parentId=:catagoryId");
            query.setInteger("catagoryId", catagoryId);
            catagoriesList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            //in ra loi
            e.printStackTrace();
        }
        //Dong session
        session.close();
        return catagoriesList;
    }
}
