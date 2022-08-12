package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;


@Repository
public interface AccountRepository extends CrudRepository<AccountBean, Integer> {
	List<AccountBean> findAll();
	
	Optional<AccountBean> findById(Integer userId);
	@Query(value ="select * from accounts where user_id=?1",nativeQuery = true)
	List<AccountBean> findAccounts(Integer userId);
	
}
