package com.authentication_and_authorization_system.authentication_and_authorization.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_and_authorization_system.authentication_and_authorization.model.*;
import com.authentication_and_authorization_system.authentication_and_authorization.repository.*;
import com.authentication_and_authorization_system.authentication_and_authorization.request.*;
 

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class RoleController {
	private RoleRepository roleRepo;
	
	@Autowired
	public void setRoleRepository(RoleRepository accRepo) {
        this.roleRepo = accRepo;
    }

  @GetMapping("/getRole")
  public List<Roles> getRole(){
	 List<Roles> res=roleRepo.findAll();
    return res;
  }
  
  @PostMapping("/addRole")
  public String addRole(@RequestBody RolesRequest acc) {
	  Roles newAcc=new Roles(acc.getRoleType());
	  roleRepo.save(newAcc);
	  return "Added New Role";
  }
  
  @PutMapping("/editRole/{id}")
  public String editRole(@PathVariable("id") long id, @RequestBody RolesRequest account) {
	  Roles acc=roleRepo.findById(id).get();
	  if(Objects.isNull(acc))
		  return null;
	  String updates="";
	  if(Objects.nonNull(account.getRoleType())) {
		  acc.setRoleType(account.getRoleType());
	  }
	  else {
		  updates+="Role Type, ";
	  }
	  roleRepo.save(acc);
	  return updates;
  }
  
  @GetMapping("/getRole/{id}")
  public Roles getRole(@PathVariable("id") long id) {
	  Roles acc=roleRepo.findById(id).get();
	  if(!Objects.isNull(acc))
	  {
		  return acc;
	  }
	  else {
		  return null;
	  }
	  
  }
  
  @DeleteMapping("/deleteRole/{id}")
  public String deleteRole(@PathVariable("id") long id) {
	  Roles acc=roleRepo.findById(id).get();
	  if(Objects.isNull(acc)) {
		  return null;
	  }
	  roleRepo.deleteById(id);
	  return "Role Deleted!";
  }
}