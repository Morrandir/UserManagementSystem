package com.qubo.learning.common.model;

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
