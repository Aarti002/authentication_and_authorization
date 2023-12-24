package com.authentication_and_authorization_system.authentication_and_authorization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication_and_authorization_system.authentication_and_authorization.model.Profiles;
import com.authentication_and_authorization_system.authentication_and_authorization.repository.ProfileRepository;

@Service
public class ProfileService {
	        @Autowired
	       private ProfileRepository repo;     

	       public List<Profiles> getProfiles(){
	            return (List<Profiles>) repo.findAll();
	        }

}