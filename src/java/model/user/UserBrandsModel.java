/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Brands;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserBrandsModel extends UserAllModel {
    
    //lay 3 nhan hieu goi y san pham
    public List<Brands> getThreeSuggestBrand(){
        //tao doi tuong luu danh sach
        List<Brands> listBrands = new ArrayList<>();
        Session session = getSession();
        try {
            //lay cac brand moi nhat
            List<Brands> rawListBrands = session.createQuery("from Brands where isDisabled = false order by created DESC").list();
            session.getTransaction().commit();
            //khai bao bien dem so brand da duoc them vao
            int countBrand = 0;
            for (Brands brand : rawListBrands) {
                if(!(brand.getProductses().isEmpty())){
                    listBrands.add(brand);
                    countBrand++;
                }
                if(countBrand == 3){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listBrands;
    }
    
    //lay 5 nhan hieu goi y
    public List<Brands> getBrandShowLogo(){
        //tao doi tuong luu danh sach
        List<Brands> listBrands = new ArrayList<>();
        Session session = getSession();
        try {
            //lay cac brand moi nhat
            Query query = session.createQuery("from Brands where isDisabled = false");
            query.setMaxResults(5);
            listBrands = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();            
        }
        //dong session
        session.close();
        return listBrands;
    }  
    
    //lay tat ca cac brand
    public List<Brands> getAllBrand(){
        //tao doi tuong luu danh sach
        List<Brands> listBrands = new ArrayList<>();
        Session session = getSession();
        try {
            //lay cac brand moi nhat
            Query query = session.createQuery("from Brands where isDisabled = false");
            listBrands = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();            
        }
        //dong session
        session.close();
        return listBrands;
    }  
}
