package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.CategoryBean;

public interface CategoryRepository extends CrudRepository<CategoryBean, Integer>{

	List<CategoryBean> findAll();
}
