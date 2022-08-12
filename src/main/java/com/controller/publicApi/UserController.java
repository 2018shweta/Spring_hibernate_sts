package com.controller.publicApi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/publicApi")
public class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	BCryptPasswordEncoder bCp;
	
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
		UserBean users=userRepo.findByGmail(user.getEmail());
		if(users==null)
		{
		  Optional<RoleBean> role= roleRepo.findById(11);
		user.setRole(role.get());
		try {
			user.setPassword(bCp.encode(user.getPassword()));
			userRepo.save(user);	
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.ok("allready available");
		}
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginBean login)
	{UserBean users=userRepo.findByGmail(login.getEmail());
		if(users==null || !bCp.matches(login.getPassword(), users.getPassword()))
		{
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		}
		else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(users);
			res.setMsg("Login done...");
			return ResponseEntity.ok(res);
		}
	}
	 
	@DeleteMapping("/del/{userId}")
	public ResponseEntity<?> delUser(@RequestBody @PathVariable("userId") Integer userId)
	{
		//List<UserBean> user=userRepo.findAll();
		UserBean u2=userRepo.findByUserId(userId);
		ResponseBean<UserBean> res=new ResponseBean<>();
		res.setData(u2);
		userRepo.deleteById(userId);
		res.setMsg("deleted user");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UserBean user)
	{Optional<RoleBean> role= roleRepo.findById(11);
	user.setRole(role.get());
		userRepo.save(user);
		return ResponseEntity.ok(user);
	}
	
	
}
