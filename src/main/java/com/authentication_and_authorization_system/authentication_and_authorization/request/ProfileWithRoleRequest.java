package com.authentication_and_authorization_system.authentication_and_authorization.request;

import lombok.*;
import com.authentication_and_authorization_system.authentication_and_authorization.model.*;


@Getter
@Setter
public class ProfileWithRoleRequest{
    private long profileId;
    private AvailableRoles.RoleType roleType;
    
    public ProfileWithRoleRequest() {

    }

    public ProfileWithRoleRequest(long profileId, AvailableRoles.RoleType roleType) {
        super();
        this.profileId = profileId;
        this.roleType = roleType;
    }

    public long getProfileId() {
        return profileId;
    }
    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }
    public AvailableRoles.RoleType getRoleType() {
        return roleType;
    }
    public void setName(AvailableRoles.RoleType roleType) {
        this.roleType = roleType;
    }
}