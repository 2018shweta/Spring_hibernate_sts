package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public interface UserRepository extends CrudRepository<UserBean, Integer>{
	List<UserBean> findAll();
	/* Optional<UserBean> findAllById(String email); */
@Query(value="select * from users where email=?1",nativeQuery = true)
	UserBean findByGmail(String email);
UserBean findByUserId(Integer userId);


	

}
