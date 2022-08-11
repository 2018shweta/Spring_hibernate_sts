package com.controller.publicApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/allAccounts")
	public ResponseEntity<?> allAccounts()
	{
		List<AccountBean> accounts=accountRepo.findAll();
		return ResponseEntity.ok(accounts);
	}
	
	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable("accountId") Integer accountId)
	{
		Optional<AccountBean> account= accountRepo.findById(accountId);
		if(account.isPresent())
		{
			AccountBean ac=account.get();
			accountRepo.delete(ac);
			return ResponseEntity.ok(ac);
		}
		else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	@GetMapping("/acUser/{userId}")
	public ResponseEntity<?> acByUser(@PathVariable("userId") Integer userId)
	{
		Optional<AccountBean> acs= accountRepo.findById(userId);
		System.out.println("acs"+acs);
		
		return ResponseEntity.ok(acs);
	}
	
}
