package com.authentication_and_authorization_system.authentication_and_authorization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication_and_authorization_system.authentication_and_authorization.model.ProfileWithRole;
import com.authentication_and_authorization_system.authentication_and_authorization.repository.ProfileWithRoleRepository;

@Service
public class ProfileWithRoleService {
	        @Autowired
	       private ProfileWithRoleRepository repo;     

	       public List<ProfileWithRole> getProfileWithRole(){
	            return (List<ProfileWithRole>) repo.findAll();
	        }

}