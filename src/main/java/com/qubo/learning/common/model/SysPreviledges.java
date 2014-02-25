package com.qubo.learning.common.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_PREVILEDGES")
public class SysPreviledges {
	@Id
	@GeneratedValue
	@Column(name = "previledge_id")
	private int previledgeID;
	
	@Column(name = "previledge_name")
	private String previledgeName;
	
	@ManyToMany(mappedBy="sysPreviledges")
	private Set<SysUserRole> userRoles = new HashSet<SysUserRole>();

	public int getPreviledgeID() {
		return previledgeID;
	}

	public void setPreviledgeID(int previledgeID) {
		this.previledgeID = previledgeID;
	}

	public String getPreviledgeName() {
		return previledgeName;
	}

	public void setPreviledgeName(String previledgeName) {
		this.previledgeName = previledgeName;
	}

}
