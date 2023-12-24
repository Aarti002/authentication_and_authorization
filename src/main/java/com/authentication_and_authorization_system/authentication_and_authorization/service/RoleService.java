package com.authentication_and_authorization_system.authentication_and_authorization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication_and_authorization_system.authentication_and_authorization.model.Roles;
import com.authentication_and_authorization_system.authentication_and_authorization.repository.RoleRepository;

@Service
public class RoleService {
	        @Autowired
	       private RoleRepository repo;     

	       public List<Roles> getRole(){
	            return (List<Roles>) repo.findAll();
	        }

}