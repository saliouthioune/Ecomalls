package com.vision.model;
import javax.persistence.*;
@Entity
@Table(name="Role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleId")
    private long roleId;
    private String name;
    
	public Role() {
		super();
	}
	public Role(long roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
     
}
