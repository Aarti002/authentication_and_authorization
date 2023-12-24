package com.authentication_and_authorization_system.authentication_and_authorization.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_and_authorization_system.authentication_and_authorization.model.*;
import com.authentication_and_authorization_system.authentication_and_authorization.repository.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class ProfileWithRoleController {
	
	private ProfileWithRoleRepository profileWithRoleRepo;
	
	@Autowired
	public void setProfileWithRoleRepository(ProfileWithRoleRepository accRepo) {
        this.profileWithRoleRepo = accRepo;
    }

  @GetMapping("/getProfileWithRole")
  public List<ProfileWithRole> getProfileWithRole(){
	 List<ProfileWithRole> res=profileWithRoleRepo.findAll();
    return res;
  }
  
  @PostMapping("/addProfileWithRole")
  public String addProfileWithRole(@RequestBody ProfileWithRole acc) {
	  ProfileWithRole newAcc=new ProfileWithRole();
	  newAcc.setProfile(acc.getProfile());
	  newAcc.setRole(acc.getRole());
	  profileWithRoleRepo.save(acc);
	  return "Added New Profile With Role";
  }
  
  @PutMapping("/editProfileWithRole/{id}")
  public String editProfileWithRole(@PathVariable("id") long id, @RequestBody ProfileWithRole account) {
	  ProfileWithRole acc=profileWithRoleRepo.findById(id).get();
	  if(Objects.isNull(acc))
		  return null;
	  String updates="";
	  if(Objects.nonNull(account.getProfile())) {
		  acc.setProfile(account.getProfile());
	  }
	  else {
		  updates+="Profile, ";
	  }
	  if(Objects.nonNull(account.getRole())) {
		  acc.setRole(account.getRole());
	  }
	  else {
		  updates+="Role, ";
	  }
	  
	  if(!updates.isEmpty()) {
		  updates+="has not been updated!";
	  }
	  profileWithRoleRepo.save(acc);
	  return updates;
  }
  
  @GetMapping("/getProfileWithRole/{id}")
  public ProfileWithRole getProfileWithRole(@PathVariable("id") long id) {
	  ProfileWithRole acc=profileWithRoleRepo.findById(id).get();
	  if(!Objects.isNull(acc))
	  {
		  return acc;
	  }
	  else {
		  return null;
	  }
	  
  }
  
  @DeleteMapping("/deleteProfileWithRole/{id}")
  public String deleteProfileWithRole(@PathVariable("id") long id) {
	  ProfileWithRole acc=profileWithRoleRepo.findById(id).get();
	  if(Objects.isNull(acc)) {
		  return null;
	  }
	  profileWithRoleRepo.deleteById(id);
	  return "Profile With Role Deleted!";
  }
}