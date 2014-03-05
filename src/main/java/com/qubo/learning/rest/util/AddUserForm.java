package com.qubo.learning.rest.util;

import com.qubo.learning.common.model.ROLE;

/**
 * Created by Qubo_Song on 3/5/14.
 */
public class AddUserForm {
    private String userName, password, confirmPassword;
    private ROLE userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public ROLE getUserRole() {
        return userRole;
    }

    public void setUserRole(ROLE userRole) {
        this.userRole = userRole;
    }

}
