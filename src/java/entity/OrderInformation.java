/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author MinhQuan
 */
public class OrderInformation {
    
    private OrderDetail orderDetail;
    private ProductImages image;
    private double salePrice;

    public OrderInformation() {
    }

    public OrderInformation(OrderDetail orderDetail, ProductImages image, double salePrice) {
        this.orderDetail = orderDetail;
        this.image = image;
        this.salePrice = salePrice;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public ProductImages getImage() {
        return image;
    }

    public void setImage(ProductImages image) {
        this.image = image;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    
}
