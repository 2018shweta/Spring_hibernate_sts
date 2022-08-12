package com.seed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.RoleBean;
import com.repository.RoleRepository;

@Component
public class RoleSeed {

	
	
	
	@Autowired
	RoleRepository roleRepo;
	@PostConstruct
	void roleCreate()
	{
		//RoleBean role=new RoleBean();
		RoleBean role=roleRepo.findByRoleName("admin");
		if(role==null)
		{
			RoleBean role1=new RoleBean();
			role1.setRoleName("user");
			roleRepo.save(role1);
			RoleBean role2=new RoleBean();
			role1.setRoleName("admin");
			roleRepo.save(role2);
			
		}
		else {
			System.out.println("Allready added");
		}
	}
	
}
