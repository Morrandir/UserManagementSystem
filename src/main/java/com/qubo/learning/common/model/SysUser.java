package com.qubo.learning.common.model;


public class SysUser {
    private int user_id;
    private String user_name;
    private String password;
    private boolean enabled;
    private boolean online;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
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
