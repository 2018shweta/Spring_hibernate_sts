package com.controller.publicApi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> adduser(@RequestBody UserBean user)
	{
		/*
		 * Optional<UserBean> aUser=userRepo.findAl(user.getEmail());
		 * 
		 * if(aUser==null) { userRepo.save(user); } else { return
		 * ResponseEntity.unprocessableEntity().build(); } return
		 * ResponseEntity.ok(user);
		 */
		  Optional<RoleBean> role= roleRepo.findById(11);
		user.setRole(role.get());
		try {
			userRepo.save(user);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(user);
	}
	
	
	
	
	
	
}
