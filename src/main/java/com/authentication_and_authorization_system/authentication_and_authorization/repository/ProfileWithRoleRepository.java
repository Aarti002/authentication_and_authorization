package com.authentication_and_authorization_system.authentication_and_authorization.repository;



import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;

import com.authentication_and_authorization_system.authentication_and_authorization.model.*;


@Repository
public interface ProfileWithRoleRepository extends JpaRepository<ProfileWithRole, Long> {

}