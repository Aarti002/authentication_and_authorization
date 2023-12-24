package com.authentication_and_authorization_system.authentication_and_authorization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailableRoles.RoleType typename;

    public Roles() {

    }
    
    public Roles(AvailableRoles.RoleType typeName) {
    	super();
        this.typename = typeName;
    }
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id=id;
    }
    
    public AvailableRoles.RoleType getRoleType() {
        return typename;
    }
    public void setRoleType(AvailableRoles.RoleType roleType) {
        this.typename = roleType;
    }
}
