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
public class CatagoryDetail implements java.io.Serializable {

    int page, catagoryId, brandId;
    float min, max;
    String name;
    
    public CatagoryDetail() {
    }

    public CatagoryDetail(int page, int catagoryId, int brandId, float min, float max, String name) {
        this.page = page;
        this.catagoryId = catagoryId;
        this.brandId = brandId;
        this.min = min;
        this.max = max;
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
