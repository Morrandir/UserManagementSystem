package com.qubo.learning.common.model;

public class SysUserRole {


    private int role_id;
    private int user_id;
    private String role_name;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}




/*
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
*/
