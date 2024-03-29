package entity;
// Generated Sep 3, 2019 7:58:03 PM by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Brands generated by hbm2java
 */
public class Brands  implements java.io.Serializable {


     private int brandId;
     private String brandName;
     private String logo;
     private Date created;
     private boolean isDisabled;
     private Set productses = new HashSet(0);

    public Brands() {
    }

	
    public Brands(int brandId, String brandName, String logo, Date created, boolean isDisabled) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.logo = logo;
        this.created = created;
        this.isDisabled = isDisabled;
    }
    public Brands(int brandId, String brandName, String logo, Date created, boolean isDisabled, Set productses) {
       this.brandId = brandId;
       this.brandName = brandName;
       this.logo = logo;
       this.created = created;
       this.isDisabled = isDisabled;
       this.productses = productses;
    }
   
    public int getBrandId() {
        return this.brandId;
    }
    
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    public String getBrandName() {
        return this.brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
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
    public Set getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set productses) {
        this.productses = productses;
    }




}


