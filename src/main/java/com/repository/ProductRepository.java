package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public interface ProductRepository extends CrudRepository<ProductBean, Integer>{

	
	
	List<ProductBean> findAll();
}
