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
public class ProfilesController {
	
	private ProfileRepository profileRepo;
	
	@Autowired
	public void setProfileRepository(ProfileRepository accRepo) {
        this.profileRepo = accRepo;
    }

  @GetMapping("/getProfiles")
  public List<Profiles> getProfiles(){
	 List<Profiles> res=profileRepo.findAll();
    return res;
  }
  
  @PostMapping("/addProfile")
  public String addProfile(@RequestBody Profiles acc) {
	  Profiles newAcc=new Profiles();
	  newAcc.setName(acc.getName());
	  newAcc.setEmail(acc.getEmail());
	  newAcc.setPhone(acc.getPhone());
	  profileRepo.save(acc);
	  return "Added New Profile";
  }
  
  @PutMapping("/editProfile/{id}")
  public String editProfiles(@PathVariable("id") long id, @RequestBody Profiles account) {
	  Profiles acc=profileRepo.findById(id).get();
	  if(Objects.isNull(acc))
		  return null;
	  String updates="";
	  if(Objects.nonNull(account.getName()) && !"".equalsIgnoreCase(account.getName())) {
		  acc.setName(account.getName());
	  }
	  else {
		  updates+="Name, ";
	  }
	  if(Objects.nonNull(account.getEmail()) && !"".equalsIgnoreCase(account.getEmail())) {
		  acc.setEmail(account.getEmail());
	  }
	  else {
		  updates+="Email, ";
	  }
	  if(Objects.nonNull(account.getPhone()) && !"".equalsIgnoreCase(account.getPhone())) {
		  acc.setPhone(account.getPhone());
	  }
	  else {
		  updates+="Phone ";
	  }
	  if(!updates.isEmpty()) {
		  updates+="has not been updated!";
	  }
	  profileRepo.save(acc);
	  return updates;
  }
  
  @GetMapping("/getProfile/{id}")
  public Profiles getProfile(@PathVariable("id") long id) {
	  Profiles acc=profileRepo.findById(id).get();
	  if(!Objects.isNull(acc))
	  {
		  return acc;
	  }
	  else {
		  return null;
	  }
	  
  }
  
  @DeleteMapping("/deleteProfile/{id}")
  public String deleteProfile(@PathVariable("id") long id) {
	  Profiles acc=profileRepo.findById(id).get();
	  if(Objects.isNull(acc)) {
		  return null;
	  }
	  profileRepo.deleteById(id);
	  return "Profile Deleted!";
  }
  
  
}