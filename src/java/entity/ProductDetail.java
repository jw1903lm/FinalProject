/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;

/**
 *
 * @author MinhQuan
 */
public class ProductDetail {
    private Products product;
    private ProductImages image;
    private float salePrice;
    private List<Sizes> listSize;
    private boolean available;
    private int rating;

    public ProductDetail() {
        
    } 

    public ProductDetail(Products product, ProductImages image, float salePrice, List<Sizes> listSize, boolean available, int rating) {
        this.product = product;
        this.image = image;
        this.salePrice = salePrice;
        this.listSize = listSize;
        this.available = available;
        this.rating = rating;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductImages getImage() {
        return image;
    }

    public void setImage(ProductImages image) {
        this.image = image;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public List<Sizes> getListSize() {
        return listSize;
    }

    public void setListSize(List<Sizes> listSize) {
        this.listSize = listSize;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
}
