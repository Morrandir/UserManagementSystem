package com.qubo.learning.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SYS_ROLE")
public class SysUserRole {
	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="role_name")
	private int role_name;
	
	@OneToMany(mappedBy="userRole")
	private Set<SysUser> sysUsers = new HashSet<SysUser>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "EMPLOYEE_MEETING", 
		joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "MEETING_ID") })
	private Set<SysPreviledges> sysPreviledges = new HashSet<SysPreviledges>();

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getRole_name() {
		return role_name;
	}

	public void setRole_name(int role_name) {
		this.role_name = role_name;
	}

}
