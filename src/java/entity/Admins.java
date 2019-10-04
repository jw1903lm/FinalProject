package entity;
// Generated Sep 3, 2019 7:58:03 PM by Hibernate Tools 3.6.0

import java.util.Date;

/**
 * Admins generated by hbm2java
 */
public class Admins implements java.io.Serializable {

    private int adminId;
    private String adminName;
    private String adminPassword;
    private String salt;
    private Date created;
    private boolean isDisabled;

    public Admins() {
    }

    public Admins(int adminId, String adminName, String adminPassword, String salt, Date created, boolean isDisabled) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.salt = salt;
        this.created = created;
        this.isDisabled = isDisabled;
    }

    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return this.adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
