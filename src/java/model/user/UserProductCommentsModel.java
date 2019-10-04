/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import entity.ProductComments;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MinhQuan
 */
public class UserProductCommentsModel extends UserAllModel {

    //lay danh sach comment cua san pham
    public List<ProductComments> getProductCommentByProductId(int productId) {
        List<ProductComments> listProductComments = null;
        Session session = getSession();
        try {
            //Tao query tim comment moi den cu
            Query query = session.createQuery("from ProductComments where productId=:productId  and isDisabled = false order by Created DESC");
            //Gan gia tri cho query
            query.setInteger("productId", productId);
            listProductComments = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return listProductComments;
    }

    //dem so luong comment cua san pham
    public long countProductCommentByProductId(int productId) {
        long countComments = 0;
        Session session = getSession();
        try {
            //Tao query tim comment moi den cu
            Query query = session.createQuery("select count commentId from ProductComments where productId=:productId  and isDisabled = false");
            //Gan gia tri cho query
            query.setInteger("productId", productId);
            countComments = (long) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return countComments;
    }
    
    //lay danh sach comment theo Id
    public ProductComments getProductCommentById(int commentId) {
        ProductComments productComment = null;
        Session session = getSession();
        try {
            //Tao query tim comment moi den cu
            Query query = session.createQuery("from ProductComments where commentId=:commentId  and isDisabled = false");
            //Gan gia tri cho query
            query.setInteger("commentId", commentId);
            productComment = (ProductComments)query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //dong session
        session.close();
        return productComment;
    }

    //Tao comment moi
    public boolean addNewComment(ProductComments comment) {
        boolean check = false;
        Session session = getSession();
        //Tao isDisable
        comment.setIsDisabled(false);
        //Tao created
        if (comment.getCreated() == null) {
            comment.setCreated(getCurrentDate());
        }
        try {
            //Luu comment moi vao CSDL
            session.save(comment);
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
    
    //Xoa comment
    public boolean deleteComment(ProductComments comment) {
        boolean check = false;
        Session session = getSession();
        try {
            //Luu user moi vao CSDL
            session.delete(comment);
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
    
    //Sua comment
    public boolean updateComment(ProductComments comment) {
        boolean check = false;
        Session session = getSession();
        try {
            //Luu user moi vao CSDL
            session.merge(comment);
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
