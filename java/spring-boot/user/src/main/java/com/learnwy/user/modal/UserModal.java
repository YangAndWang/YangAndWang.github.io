package com.learnwy.user.modal;

import javax.persistence.*;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
@Entity
@Table(name = "user")
public class UserModal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userLoginName;
    private String userDisplayName;
    private String userPassword;

    public UserModal() {
    }

    public UserModal(String userLoginName, String userDisplayName, String userPassword) {
        this.userLoginName = userLoginName;
        this.userDisplayName = userDisplayName;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
