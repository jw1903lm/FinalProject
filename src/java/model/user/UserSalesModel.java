/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.user;

import entity.Sales;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserSalesModel {
    private UserAllModel allModel;

    public UserSalesModel() {
        allModel = new UserAllModel();
    }
    
    //lay sale theo id
    public Sales getSaleBySellId(int saleId){
        //tao doi tuong luu danh sach
        Sales sale = null;
        Session session = allModel.getSession();
        try {
            Query query = session.createQuery("from Sales where isDisabled = false and saleId=:saleId");
            query.setInteger("saleId", saleId);
            sale = (Sales) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return sale;
    }
    
    //lay so phan tram giam gia theo id
    public int getPercentageBySellId(int saleId){
        //tao doi tuong luu danh sach
        int salePercentage = 0;
        Session session = allModel.getSession();
        try {
            Query query = session.createQuery("from Sales where isDisabled = false and saleId=:saleId");
            query.setInteger("saleId", saleId);
            query.setMaxResults(1);
            List<Sales> listSale = query.list();
            Sales sale = listSale.get(0);
            salePercentage = sale.getPercentage();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return salePercentage;
    }
}
