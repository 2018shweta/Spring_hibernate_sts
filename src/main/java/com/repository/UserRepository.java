package com.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public interface UserRepository extends CrudRepository<UserBean, Integer>{
	List<UserBean> findAll();
	/* Optional<UserBean> findAllById(String email); */
	

}
