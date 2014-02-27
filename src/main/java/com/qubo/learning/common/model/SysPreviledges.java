package com.qubo.learning.common.model;

import java.util.HashSet;
import java.util.Set;

public class SysPreviledges {


    private int previledgeID;
    private String previledgeName;
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





/*
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
*/
