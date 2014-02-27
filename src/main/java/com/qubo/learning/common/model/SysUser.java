package com.qubo.learning.common.model;


public class SysUser {
    private int userID;
    private String userName;
    private String userPwd;
    private boolean userEnabled;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public boolean isUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(boolean userEnabled) {
        this.userEnabled = userEnabled;
    }

}



/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER")
public class SysUser {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userID;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String userPwd;

	@ManyToOne
	@JoinColumn(name="role_id")
	private SysUserRole userRole;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public SysUserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(SysUserRole userRole) {
		this.userRole = userRole;
	}


}
*/
