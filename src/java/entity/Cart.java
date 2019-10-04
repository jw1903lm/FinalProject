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
public class Cart {
    private ProductDetail product;
    private int quantity;
    private Sizes size;
    private String cartImage;
    private float totalPrice;
    
    public Cart() {
        
    }

    public Cart(ProductDetail product, int quantity, Sizes size, String cartImage, float totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.size = size;
        this.cartImage = cartImage;
        this.totalPrice = totalPrice;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public void setProduct(ProductDetail product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public String getCartImage() {
        return cartImage;
    }

    public void setCartImage(String cartImage) {
        this.cartImage = cartImage;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}
