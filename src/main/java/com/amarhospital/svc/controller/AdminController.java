package com.amarhospital.svc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amarhospital.svc.entity.Admin;
import com.amarhospital.svc.repository.AdminRepo;



@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminRepo adminRepo;

	@GetMapping("/getAdminList")
	public List<Admin> getHelloWorld() {
		return adminRepo.findAll();
	}

	@GetMapping("/getAdminById/{id}")
	public Optional<Admin> getAdminById(@PathVariable Long id) {
		 Optional<Admin> admin = adminRepo.findById(id);
		 if(admin.isPresent()) {
			 return admin;
		 } else {
			 return Optional.empty();
		 }
	}

	@PostMapping("/saveAdmin")
	public Admin saveNewAdmin(@RequestBody Admin adminObj) {
		return adminRepo.save(adminObj);
	}
	
	@PutMapping("/updateAdmin/{id}")
	public Admin updateAdmin(@RequestBody Admin adminObj, @PathVariable Long id) {
		 Optional<Admin> admin = adminRepo.findById(id);
		 if(admin.isPresent()) {
			 adminObj.setId(id);
			 return adminRepo.save(adminObj);
		 } else {
			 return new Admin();
		 }
	}
	
	@DeleteMapping("/removeAdmin/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		 adminRepo.deleteById(id);
		 return "Item deleted";
	}

}
