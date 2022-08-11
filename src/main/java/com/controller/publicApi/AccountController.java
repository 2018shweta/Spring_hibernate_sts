package com.controller.publicApi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.repository.AccountRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class AccountController {

	@Autowired
	AccountRepository accountRepo;
	@Autowired
	UserRepository userRepo;
	@PostMapping("/addAccount")
	public ResponseEntity<?> addAcoount(@RequestBody AccountBean accounts)
	{
		 Optional<UserBean> users= userRepo.findById(15);
		 accounts.setUser(users.get());
		accountRepo.save(accounts);
		return ResponseEntity.ok(accounts);
	}
	
	
	
}
