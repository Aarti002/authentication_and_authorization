package com.authentication_and_authorization_system.authentication_and_authorization.request;

import lombok.*;
import com.authentication_and_authorization_system.authentication_and_authorization.model.*;


@Getter
@Setter
public class RolesRequest{
    private AvailableRoles.RoleType roleType;
    
    public RolesRequest() {

    }

    public RolesRequest(AvailableRoles.RoleType roleType) {
        super();
        this.roleType = roleType;
    }

    public AvailableRoles.RoleType getRoleType() {
        return roleType;
    }
    public void setRoleType(AvailableRoles.RoleType roleType) {
        this.roleType = roleType;
    }
}