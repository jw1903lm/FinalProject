package entity;
// Generated Sep 3, 2019 7:58:03 PM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.Date;

/**
 * ProductComments generated by hbm2java
 */
public class ProductComments  implements java.io.Serializable {


     private int commentId;
     private Users users;
     private Products products;
     private String fullName;
     private String review;
     private Integer rating;
     private Date created;
     private boolean isDisabled;

    public ProductComments() {
    }

	
    public ProductComments(int commentId, Products products, String fullName, String review, Date created, boolean isDisabled) {
        this.commentId = commentId;
        this.products = products;
        this.fullName = fullName;
        this.review = review;
        this.created = created;
        this.isDisabled = isDisabled;
    }
    public ProductComments(int commentId, Users users, Products products, String fullName, String review, Integer rating, Date created, boolean isDisabled) {
       this.commentId = commentId;
       this.users = users;
       this.products = products;
       this.fullName = fullName;
       this.review = review;
       this.rating = rating;
       this.created = created;
       this.isDisabled = isDisabled;
    }
   
    public int getCommentId() {
        return this.commentId;
    }
    
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Products getProducts() {
        return this.products;
    }
    
    public void setProducts(Products products) {
        this.products = products;
    }
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getReview() {
        return this.review;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    public Integer getRating() {
        return this.rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public boolean isIsDisabled() {
        return this.isDisabled;
    }
    
    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }




}


